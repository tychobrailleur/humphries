package org.humphries

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class ProjectController {

    def scaffold = Project
}
