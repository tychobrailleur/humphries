package org.humphries

import grails.plugins.springsecurity.Secured

@Secured(["hasRole('ADMIN_ROLE')"])
class VersionController {

    def scaffold = Version
}
