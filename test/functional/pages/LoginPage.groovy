package pages

import geb.Page

class LoginPage extends Page {
    static url = 'login/auth'
    static at = {
        title ==~ /Login/
    }
    
	static content = {
        login { $('input', name: 'j_username') }
        password { $('input', name: 'j_password') }
        loginButton { $('input', value: 'Login') }
    }

    def login(String username, String pass) {
        login = username
        password = pass

        loginButton.click()
    }
}
