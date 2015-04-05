package org.humphries


class Workflow {
    String name
   
    static constraints = {
        name nullable: false, blank: false
        
    }
}
