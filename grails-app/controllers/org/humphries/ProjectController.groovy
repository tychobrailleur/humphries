package org.humphries

import grails.plugin.springsecurity.annotation.Secured

@Secured(['isAuthenticated()'])
class ProjectController {

    def springSecurityService
    
    def show(Long id) {
        Project project = Project.get(id)
        if (!project) {
            render(status: 404)
            return
        }

        def user = springSecurityService.currentUser

        if (!(user in project.members)) {
            render(status: 403)
            return
        }

        [ project: project ]
    }

    def addTicket(Long id) {
        def project = Project.get(id)    
    }
}

