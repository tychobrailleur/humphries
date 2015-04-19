package org.humphries

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock
import grails.buildtestdata.mixin.Build

@TestFor(Project)
@Mock([Ticket, Workflow])
@Build([Ticket, Workflow])
class ProjectSpec extends Specification {
    def project
    
    def setup() {
        project = new Project(name: 'foobar', code: 'H', workflow: Workflow.build()).save(failOnError: true)
        project.addToTickets(Ticket.build(reference: 'H-1'))
        project.addToTickets(Ticket.build(reference: 'H-5'))
        project.addToTickets(Ticket.build(reference: 'H-2'))
    }

    def "getNextTicketReference returns the correct next reference"() {
        expect:
        project.getNextTicketReference() == 'H-6'
    }

    def "getNextTicketReference returns the first reference when no ticket"() {
        when:
        def project =  new Project(name: 'foobar', code: 'H', workflow: Workflow.build()).save(failOnError: true)

        then:
        project.getNextTicketReference() == 'H-1'
    }
}
