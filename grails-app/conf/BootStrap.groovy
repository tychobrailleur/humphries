import org.humphries.*
import org.humphries.auth.*

/*

  BootStrap initialises the test data by inserting pre-defined records in the 
  database.

*/

class BootStrap {

    def init = { servletContext ->
        def humphriesProject = new Project(name: "Humphries", code: "HUMP")
        def introTag = new Tag(name: "Intro")
        
        if (!User.count()) {
            def userPermission = new Permission(authority: 'USER_ROLE').save(flush:true)
            def adminPermission = new Permission(authority: 'ADMIN_ROLE').save(flush: true)
            
            def password = 'password'
            
            [pierre: 'Pierre Rust', seb: 'Sébastien Le Callonnec'].each { username, displayName ->
                def user = new User(username: username, displayName: displayName, password: password, enabled: true).save()
                UserPermission.create(user, userPermission, true)
                if (username == 'pierre') {
                    UserPermission.create(user, adminPermission, true)
                }
            }
        }
 
        if (!Project.count()) {
            humphriesProject.save(failOnError: true)
        }

        if (!Tag.count()) {
            new Tag(name: "Help wanted").save(failOnError: true)
            introTag.save(failOnError: true)
        }
        
        if (!Ticket.count()) {
            new Ticket(name: "Grails spike",
                reference: "HUMP-1",
                description: "Exploratory spike on grails",
                project: humphriesProject,
                creator: User.get(1),
                tag: introTag).save(failOnError: true)
        }
    }

    def destroy = {
    }
}

