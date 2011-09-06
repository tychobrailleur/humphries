import org.humphries.*

/*

  BootStrap initialises the test data by inserting pre-defined records in the 
  database.

*/

class BootStrap {

    def init = { servletContext ->
        def humphriesProject = new Project(name: "Humphries", code: "HUMP")
        def introTag = new Tag(name: "Intro")
 
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
                tag: introTag).save(failOnError: true)
        }
    }
    def destroy = {
    }
}
