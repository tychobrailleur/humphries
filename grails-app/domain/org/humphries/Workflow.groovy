package org.humphries


import org.humphries.auth.*

class Workflow {
    String name

    State startState

    User creator

    Date dateCreated
    Date lastUpdated
    
    static constraints = {
        name nullable: false, blank: false
        creator nullable: false
    }
}
