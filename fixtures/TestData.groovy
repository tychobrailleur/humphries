fixture {

    // Tags
    intro(org.humphries.Tag, name: 'Intro')
    help(org.humphries.Tag, name: 'Help Wanted')

    // Permissions
    userPermission(org.humphries.auth.Permission, authority: 'ROLE_USER')
    adminPermission(org.humphries.auth.Permission, authority: 'ROLE_ADMIN')

    // User
    pierre(org.humphries.auth.User, username: 'pierre', displayName: 'Pierre Rust', password: 'password', enabled: true)
    sebastien(org.humphries.auth.User, username: 'sebastien', displayName: 'Sébastien Le Callonnec', password: 'password', enabled: true)

    assgined(org.humphries.State, name: 'Assigned')
    start(org.humphries.State, name: 'New', nextStates: [ assgined ])

    workflow(org.humphries.Workflow, name: 'Basic', startState: start, creator: pierre,
        dateCreated: new Date(),
        lastUpdated: new Date())

    
    // Project
    humphries(org.humphries.Project, name: "Humphries", code: "HUMP", members: [pierre], workflow: workflow)
    
    // Version
    firstVersion(org.humphries.Version,  versionNum: '0.0.1', 
                name: 'very first version',
                creator: pierre, 
                creationDate: new Date(),
                project: humphries)

    // Tickets
    grailsSpike(org.humphries.Ticket, name: "Grails spike",
                reference: "HUMP-1",
                description: "Exploratory spike on grails",
        dateCreated: new Date(),
        lastUpdated: new Date(),
        project: humphries,
        state: start,
        creator: pierre,
        tags: [ intro, help ])
}
post {
    org.humphries.auth.UserPermission.create(pierre, userPermission, true)
    org.humphries.auth.UserPermission.create(pierre, adminPermission, true)
    org.humphries.auth.UserPermission.create(sebastien, userPermission, true)
}
