package org.humphries


class State {
    String name

    static hasMany = [ nextStates: State ]

    static constraints = {
        name nullable: false
    }
}
