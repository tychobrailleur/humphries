package org.humphries

import grails.plugin.springsecurity.annotation.Secured

@Secured(['isAuthenticated()'])
class ProjectController {

    static allowedMethods = [ create: 'GET', save: 'POST' ]

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

    @Secured(["hasRole('ROLE_ADMIN')"])
    def create() {}

    @Secured(["hasRole('ROLE_ADMIN')"])
    def save() {
        def workflow = Workflow.findByName('Basic')

        def project = new Project(name: params.name,
            description: params.description,
            code: params.code,
            workflow: workflow)

        project.addToMembers(springSecurityService.currentUser)

        project.save(flush: true)

        if (project.hasErrors()) {
            // TODO handle error
        }

        show(project.id)
    }
}
