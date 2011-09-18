package org.humphries

import org.humphries.auth.*

class Ticket {
    String name
    String reference
    String description
    
    User creator
    User assignedTo
    
    Date dateCreated
    Date lastUpdated

    static belongsTo = [project:Project]
    static hasMany = [tags:Tag, notes:Note]

    static constraints = {
        name(blank: false)
        reference(blank: false)
        description(blank: false)
        assignedTo(nullable: true)
    }
}
