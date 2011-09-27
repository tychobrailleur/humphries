package org.humphries

import org.humphries.auth.User

/*
  This class represents a project.

  A project
   * has many versions
   * has many members/users
   * has many tickets
   * can contain sub-projects.

 TODO : all user do not have the same role on a project
        the association User / Project should be parameterized
        with the role of the user in respect to this project.
        => can this be easily implemente with the spring security plugin ?
*/
class Project {

    String name
    String description
    String code

    static hasMany = [
        versions: Version,
        tags:Tag, 
        tickets:Ticket,
        members: User, 
        subProjects: Project
        ]

    static constraints = {
        name(blank: false)
        code(blank: false)
        description(nullable: true)
    }
}
