package pages

import geb.Page

class ProjectPage extends Page {
    static url = 'project/show'
    static at = {
        title ==~ /Humphries/
    }
    
	static content = {
        project {
            $('#project h1')
        }

        tickets {
            $('#tickets')
        }
	}

    
}
