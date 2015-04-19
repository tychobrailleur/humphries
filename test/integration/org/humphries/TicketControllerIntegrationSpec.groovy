package org.humphries

import grails.plugin.springsecurity.*
import grails.test.spock.IntegrationSpec
import grails.converters.JSON

class TicketControllerIntegrationSpec extends IntegrationSpec {

    def ticketController
    
    def setup() {
        ticketController = new TicketController()
    }

    void testAddNote() {
        given:
        ticketController.request.json = [ ticketId: 1, noteText: 'Very insightful note' ]
        ticketController.request.method = 'POST'
        
        when:
        SpringSecurityUtils.doWithAuth('sebastien') {
            ticketController.addNote()
        }

        then:
        ticketController.response.contentAsString
        def output = JSON.parse(ticketController.response.contentAsString)
        output.notes
        output.notes.first().text == 'Very insightful note'
    }
}
