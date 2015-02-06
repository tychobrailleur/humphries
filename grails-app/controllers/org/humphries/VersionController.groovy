package org.humphries

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class VersionController {

    def scaffold = Version
}
