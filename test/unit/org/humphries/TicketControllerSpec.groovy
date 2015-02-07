package org.humphries

import org.humphries.auth.User

import grails.test.mixin.*
import spock.lang.Specification
import spock.lang.Shared
import grails.test.mixin.Mock
import grails.buildtestdata.mixin.Build
import grails.test.mixin.domain.DomainClassUnitTestMixin

@TestFor(TicketController)
@TestMixin(DomainClassUnitTestMixin)
@Mock([Ticket, User, Note])
@Build([Ticket, User, Note])
class TicketControllerSpec extends Specification {

    @Shared
    User user

    @Shared
    Ticket ticket

    def setup() {
        user = User.build(username: 'test')
        ticket = Ticket.build(name: 'foobar', description: 'quxbaz')
        
        controller.springSecurityService = [principal: [id: user.id]]
    }

    void testShow() {
        given:
        params.id = ticket.id

        when:
        def returnValue = controller.show()
        println returnValue

        then:
        returnValue
        
        // Get ticket from map
        returnValue['ticket']
        'foobar' == returnValue['ticket'].name
    }
    
    void testAddNote() {
        given:
        params.ticketId = ticket.id
        params.noteText = 'foobar'

        when:
        controller.addNote()

        then:
        def savedTicket = Ticket.get(ticket.id)
        savedTicket.notes
        savedTicket.notes.size() == 1
    }
}
