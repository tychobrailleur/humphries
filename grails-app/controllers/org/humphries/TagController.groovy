package org.humphries

import grails.plugin.springsecurity.annotation.Secured

@Secured(['isAuthenticated()'])
class TagController {

    def show(String name) {
        def tag = Tag.findByName(name)
        
        def projects = Project.withCriteria {
            tags {
                eq('name', name)
            }
        }
        def tickets = Ticket.withCriteria {
            tags {
                eq('name', name)
            }
        }
        
        [ tag: tag, projects: projects, tickets: tickets ]
    }    
}
