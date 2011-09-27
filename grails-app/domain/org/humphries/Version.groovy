package org.humphries

import org.humphries.auth.User

class Version {

    User creator
    Date creationDate

    String versionNum
    String name
    String description

    static belongsTo = [project:Project]

    static constraints = {
        versionNum(blank: false)
        name(blank: false)
        description(nullable: true)
    }

}
