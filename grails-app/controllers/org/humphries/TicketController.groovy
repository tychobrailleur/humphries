package org.humphries

import grails.converters.deep.*
import grails.plugin.springsecurity.annotation.Secured
    
import org.humphries.auth.*

/*
  Ticket controller.
*/
@Secured(['isAuthenticated()'])
class TicketController {

    static allowedMethods = [ create: 'POST', addNote: 'POST' ]
    
    def springSecurityService

    def list() {
        log.info("List tickets")
        [tickets: Ticket.list()]
    }

    def show(String id) {

        log.debug("Reference: ${id}")
        def ticket = Ticket.findByReference(id)

        // If reference cannot be found, try by its id.
        if (!ticket) {
            ticket = Ticket.get(id)
        }
        
        [ ticket: ticket ]
    }

    def create() {
        def project = Project.get(params.projectId)
        def user = User.get(springSecurityService.principal.id)
        
        def ticket = new Ticket(name: params.name, 
            description: params.description,
            code: params.code,
            creator: user,
            dateCreated: new Date())
        ticket.save(failOnError: true)
    }

    // be carefull with security constraints on an action that will be called
    // with ajax : a login redirection will generally be interpreted as success 
    def addNote() {
        log.debug(" addNote ")
        def ticket = Ticket.get(params.ticketId)
        def user = springSecurityService.currentUser

        ticket.addToNotes(text:params.noteText, 
            creationDate: new Date(), creator:user).save(flush: true)

        if (ticket.hasErrors()) {
            response.status = 400
            render
        } else {        
            // render is needed so that the jquery knows everything went fine
            renderNotes(ticket)
        }
    }

    def getNotesJSON() {
        def ticket = Ticket.get(params.ticketId)
        log.debug("get notes ${ticket.id}")
        
        renderNotes(ticket)
    }

    def assignToMe(String id) {
        def ticket = Ticket.get(id)
        def user = springSecurityService.currentUser

        ticket.assignedTo = user
        ticket.save(flush: true)
        
        render ticket as JSON
    }

    /**
     * Ensures the only properties exposed are for “public comsumption”.
     */
    private renderNotes(Ticket ticket) {
        render(contentType:"text/json") {
            notes = array {
                for (n in ticket.notes) {
                    note = {id = n.id 
                        text = n.text
                        creationDate = n.creationDate
                        creator = {
                            id = n.creator.id
                            name = n.creator.displayName
                        }
                    }
                }
            }
        }
    }
}
