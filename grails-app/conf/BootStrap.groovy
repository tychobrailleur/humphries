import org.humphries.*
import org.humphries.auth.*

import grails.util.GrailsUtil
import org.codehaus.groovy.grails.commons.GrailsApplication 
/*

  BootStrap initialises the test data by inserting pre-defined records in the 
  database.

*/

class BootStrap {
    def fixtureLoader

    def init = { servletContext ->
        boolean isProd = GrailsUtil.environment == GrailsApplication.ENV_PRODUCTION

        if (!isProd) {
            fixtureLoader.load('TestData')
        }
    }

    def destroy = {
    }
}

