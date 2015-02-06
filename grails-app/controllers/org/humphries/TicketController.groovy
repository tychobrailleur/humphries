package org.humphries

import grails.converters.deep.*
import grails.plugin.springsecurity.annotation.Secured
    
import org.humphries.auth.*

/*
  Ticket controller.
*/
class TicketController {

    def scaffold = Ticket
    
    def springSecurityService

    // gets a ticket by its id, and returns a ticket for the show view
    def show = {
        [ticket: Ticket.get(params.id)]
    }
    
    @Secured(['isAuthenticated()'])
    def create() {
        if (request.method == "POST") {
            def project = Project.get(params.projectId)
            def user = User.get(springSecurityService.principal.id)
        
            def ticket = new Ticket(name: params.name, 
                description: params.description,
                code: params.code,
                creator: user,
                dateCreated: new Date())
            ticket.save(failOnError: true)
        }
    }

    // be carefull with security constraints on an action that will be called
    // with ajax : a login redirection will generally be interpreted as sucess 
    @Secured(['isAuthenticated()'])
    def addNote() {
        log.debug(" addNote ")
        def ticket = Ticket.get(params.ticketId)
        def user = User.get(springSecurityService.principal.id)

        ticket.addToNotes( new Note(text:params.noteText, 
                    creationDate: new Date(),creator:user))
        ticket.save(failOnError: true)
        // render is needed so that the jquery knows everything went fine
        render "OK"
    }

    def getNotesJSON() {
        def ticket = Ticket.get(params.ticketId)
        log.debug("get notes + " + ticket.id)
        
        def results = ticket.notes
        
        render(contentType:"text/json") {
            notes = array {
                for (n in results) {
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
