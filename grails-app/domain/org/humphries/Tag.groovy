package org.humphries

class Tag {
    static belongsTo = [Tag, Ticket, Project]
    static hasMany = [tags:Tag, tickets:Ticket, projects:Project]

    String name
    String description

    static constraints = {
        name(blank: false)
        description(nullable: true)
    }
}
