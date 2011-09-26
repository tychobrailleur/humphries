package org.humphries

import grails.test.*

class TicketControllerTests extends ControllerUnitTestCase {

    def ticketController

    protected void setUp() {
        super.setUp()
        ticketController = new TicketController()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testShow() {
        TicketController.metaClass.getParams = {-> [id:1] }
        def testTicket = new Ticket(id: 1, name: 'foobar', 
                description: 'quxbaz')
        mockDomain(Ticket, [testTicket])
        
        def returnValue = ticketController.show()
        assertNotNull returnValue
        
        // Get ticket from map
        def foundTicket = returnValue['ticket']
        assertNotNull foundTicket
        assertEquals 'foobar', foundTicket.name
    }
    
    void testAddNote() {
        TicketController.metaClass.getParams = { -> 
                [ticketId: 1, noteText: 'foobar']}
        def testTicket = new Ticket(id: 1, name: 'foobar', 
                description: 'quxbaz')
        mockDomain(Ticket, [testTicket])
        
        ticketController.addNote()
        
        def savedTicket = Ticket.get(1)
        assertNotNull savedTicket.notes
        assertEquals 1, savedTicket.notes.size()
    }
}
