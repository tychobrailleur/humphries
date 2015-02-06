fixture {
    humphries(org.humphries.Project, name: "Humphries", code: "HUMP")

    // Tags
    intro(org.humphries.Tag, name: 'Intro')
    help(org.humphries.Tag, name: 'Help Wanted')


    // Permissions
    userPermission(org.humphries.auth.Permission, authority: 'ROLE_USER')
    adminPermission(org.humphries.auth.Permission, authority: 'ROLE_ADMIN')

    // User
    pierre(org.humphries.auth.User, username: 'pierre', displayName: 'Pierre Rust', password: 'password', enabled: true)
    sebastien(org.humphries.auth.User, username: 'sebastien', displayName: 'Sébastien Le Callonnec', password: 'password', enabled: true)

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
                project: humphries,
                creator: pierre)
}
post {
    org.humphries.auth.UserPermission.create(pierre, userPermission, true)
    org.humphries.auth.UserPermission.create(pierre, adminPermission, true)
    org.humphries.auth.UserPermission.create(sebastien, userPermission, true)
}
