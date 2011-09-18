package org.humphries

class TicketController {

    def scaffold = Ticket

    def show = {
      def ticket = Ticket.get(params.id)
      [ticket: ticket]
    }
}
