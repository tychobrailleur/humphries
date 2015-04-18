import cucumber.api.PendingException

import pages.*

this.metaClass.mixin (cucumber.api.groovy.EN)

Given(~/^I am logged in as User$/) { ->
    to LoginPage
    at LoginPage

    page.login('pierre', 'password')
}
When(~/^I go to the dashboard$/) { ->
    to DashboardPage
    at DashboardPage
}
Then(~/^I should see a list of the projects "(.*?)" is a member of$/) { String arg1 ->
    //    page.project.contains 'Pierre'
}
Then(~/^I should see a list of the tickets assigned to "(.*?)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
