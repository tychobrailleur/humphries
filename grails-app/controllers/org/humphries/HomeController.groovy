package org.humphries

import grails.plugin.springsecurity.annotation.Secured

@Secured('permitAll')
class HomeController {
    def index() {
        def projects = Project.list()
        def recentTickets = Ticket.list(sort: 'lastUpdated', order: 'desc')
        
        [ projects: projects, recentTickets: recentTickets ]
    }
}
