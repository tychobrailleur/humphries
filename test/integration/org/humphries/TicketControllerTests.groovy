package org.humphries

class TicketControllerTests extends GroovyTestCase {

    def ticketController
    
    protected void setUp() {
        super.setUp()
        ticketController = new TicketController()
    }

    void testAddNote() {
        ticketController.params.ticketId = 1
        ticketController.params.noteText = 'Very insightful note'
        ticketController.addNote()
        assertEquals "OK", ticketController.response.contentAsString
        
        def ticket = Ticket.get(1)
        assertNotNull ticket.notes
        
        def note = ticket.notes.toArray()[0]
        assertEquals 'Very insightful note', note.text
        assertNotNull note.creationDate
    }
}
