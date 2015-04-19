package org.humphries

import org.humphries.auth.User

import grails.test.mixin.*
import spock.lang.Specification
import spock.lang.Shared
import grails.test.mixin.Mock
import grails.buildtestdata.mixin.Build
import grails.test.mixin.domain.DomainClassUnitTestMixin

@TestFor(TicketController)
@Mock([Ticket, User, Note, Project, Workflow, State])
@Build([Ticket, User, Note, Project, Workflow, State])
class TicketControllerSpec extends Specification {

    @Shared
    User user

    @Shared
    Ticket ticket

    def setup() {
        user = User.build(username: 'test', password: 'password')        
        user.springSecurityService = [
            encodePassword: { String password ->
                password
            }
        ]
        user.save(flush: true, failOnError: true)

        def project = Project.build(workflow: Workflow.build(creator: user))
        project.addToTickets(name: 'foobar', creator: user, description: 'quxbaz', reference: 'boo', assignedTo: user, state: State.build())
        project.save(flush: true, failOnError: true)
        
        ticket = project.tickets.first()
        
        controller.springSecurityService = [currentUser: user]
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
        request.method = 'POST'
        request.json = [ ticketId: ticket.id, noteText: 'foobar' ]

        when:
        controller.addNote()

        then:
        def savedTicket = Ticket.get(ticket.id)
        savedTicket.notes
        savedTicket.notes.size() == 1
    }
}
