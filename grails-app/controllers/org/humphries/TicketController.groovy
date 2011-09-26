package org.humphries

//import grails.converters.*
import grails.converters.deep.*
import grails.plugins.springsecurity.Secured
    
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

    // be carefull with security constraints on an action that will be called
    // with ajax : a login redirection will generally be interpreted as sucess 
    @Secured(['isAuthenticated()'])
//      @Secured(['isFullyAuthenticated()'])
    def addNote = {
        log.debug(" addNote ")
        def ticket = Ticket.get(params.ticketId)
        def user = User.get(springSecurityService.principal.id)

        ticket.addToNotes( new Note(text:params.noteText, 
                    creationDate: new Date(),creator:user))
        ticket.save(failOnError: true)
        // render is needed so that the jquery knows everything went fine
        render "OK"
    }

    def getNotesJSON = {
        def ticket = Ticket.get(params.ticketId)
        log.error( "get notes + "+ ticket.id)
        
        //def ns = ticket.notes
        //def converter = n as JSON
        //log.debug( converter.toString())
        //render converter
        def results = ticket.notes
        
        render(contentType:"text/json") {
    		notes=array{
	    		for(n in results) {
	    			note={id=n.id 
	    			      text=n.text
	    			      creationDate=n.creationDate
	    			      creator={ id = n.creator.id
	    			        name = n.creator.displayName}
	    			     }
	    		}
	    	}
	    }
   }
}
