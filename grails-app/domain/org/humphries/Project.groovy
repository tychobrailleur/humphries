package org.humphries

class Project {
    String name
    String description
    String code

    static hasMany = [tags:Tag, tickets:Ticket]

    static constraints = {
        name(blank: false)
        code(blank: false)
        description(nullable: true)
    }
}
