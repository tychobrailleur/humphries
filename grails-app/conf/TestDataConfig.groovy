import org.humphries.auth.User

testDataConfig {
    sampleData {
        User {
            displayName = 'john doe'
            username = 'john'
            password = 'password'
            enabled = true
            slug = 'john-doe'
            springSecurityService = [
                encodePassword: { String password ->
                    password
                }
            ]
        }
    }
}
