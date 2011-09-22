package org.humphries

import grails.converters.*

/*
  Ticket controller.
*/
class TicketController {

    def scaffold = Ticket

    // gets a ticket by its id, and returns a ticket for the show view
    def show = {
      def ticket = Ticket.get(params.id)
      [ticket: ticket]
    }
    
    
    def addNote = {
        def ticket = Ticket.get(params.ticketId)
        ticket.addToNotes(
            new Note(text:params.noteText, creationDate: new Date()))
        ticket.save()
        // render is needed so that the jquery knows everything went fine
        render "OK"
    }
    
    def getNotes = {
        //debug "get notes"
        def ticket = Ticket.get(params.ticketId)
        render ticket.notes as JSON        
    }
}
