package org.humphries

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
}
