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
        user.springSecurityService = [
            encodePassword: { String password ->
                password
            }
        ]
        user.save(flush: true)
        ticket = Ticket.build(name: 'foobar', creator: user, description: 'quxbaz', reference: 'boo').save(flush: true)
        
        controller.springSecurityService = [principal: [id: user.id]]
    }

    void testShow() {
        when:
        def returnValue = controller.show('boo')

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
        request.method = 'POST'

        when:
        controller.addNote()

        then:
        def savedTicket = Ticket.get(ticket.id)
        savedTicket.notes
        savedTicket.notes.size() == 1
    }
}
