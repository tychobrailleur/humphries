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

    State state
    
    static belongsTo = [project:Project,
        detectedVersion: Version,
        targetVersion: Version,
        resolvedVersion: Version]

    static hasMany = [tags:Tag, notes:Note]

    static constraints = {
        name blank: false
        reference blank: false
        description blank: false
        assignedTo nullable: true
        targetVersion nullable: true
        detectedVersion nullable: true
        resolvedVersion nullable: true
    }
}
