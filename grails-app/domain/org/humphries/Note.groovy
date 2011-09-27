package org.humphries

import org.humphries.auth.User

class Note {

    User creator
    Date creationDate

    String text
    static belongsTo = [ticket:Ticket]

    static constraints = {
        text(blank: false)
    }
    static mapping = {
        creator fetch: 'join'
    }

}
