package org.humphries

import org.humphries.auth.User

/*
  This class represents a project.
  TODO A project can contain sub-projects.
*/
class Project {
    String name
    String description
    String code

    static hasMany = [tags:Tag, tickets:Ticket, members: User]

    static constraints = {
        name(blank: false)
        code(blank: false)
        description(nullable: true)
    }
}
