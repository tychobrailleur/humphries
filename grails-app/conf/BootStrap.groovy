import org.humphries.Ticket
import org.humphries.Tag

class BootStrap {

    def init = { servletContext ->
        def introTag = new Tag(name: "Intro")
        if (!Tag.count()) {
            new Tag(name: "Help wanted").save(failOnError: true)
            introTag.save(failOnError: true)
        }
        
        if (!Ticket.count()) {
            new Ticket(name: "Grails spike", reference: "HUMP-1", description: "Exploratory spike on grails", tag: introTag).save(failOnError: true)
        }
    }
    def destroy = {
    }
}
