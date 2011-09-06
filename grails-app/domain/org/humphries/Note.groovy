package org.humphries

class Note {

    String text
    static belongsTo = [ticket:Ticket]

    static constraints = {
        text(blank: false)
    }
}
