package org.humphries

import org.humphries.auth.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['isAuthenticated()'])
class UserController {
    def show(String id) {
        User user = User.findBySlug(id)
        
        [ user: user ]
    }
}
