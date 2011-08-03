package org.humphries

class Tag {
    static belongsTo = [Tag, Ticket]
    static hasMany = [tags:Tag, tickets:Ticket]

    String name
    String description

    static constraints = {
        name(blank: false)
        description(nullable: true)
    }
}
