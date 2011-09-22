package org.humphries

class Note {

    User author
    Date creationDate

    String text
    static belongsTo = [ticket:Ticket]

    static constraints = {
        text(blank: false)
    }
}
