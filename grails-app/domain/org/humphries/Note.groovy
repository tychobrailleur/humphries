package org.humphries

import org.humphries.auth.User

class Note {

    User author
    Date creationDate

    String text
    static belongsTo = [ticket:Ticket]

    static constraints = {
        text(blank: false)
    }
}
