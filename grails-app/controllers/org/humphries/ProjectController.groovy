package org.humphries

import grails.plugins.springsecurity.Secured

@Secured(["hasRole('ADMIN_ROLE')"])
class ProjectController {

    def scaffold = Project
}
