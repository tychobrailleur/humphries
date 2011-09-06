package org.humphries

class Ticket {
    String name
    String reference
    String description

    static belongsTo = [project:Project]
    static hasMany = [tags:Tag, notes:Note]

    static constraints = {
        name(blank: false)
        reference(blank: false)
        description(blank: false)
    }
}
