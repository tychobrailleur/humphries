package org.humphries.auth

class User {

    transient springSecurityService

    String displayName
    String username
    String password
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    String slug
    static slugCandidate = 'displayName'
    
    static constraints = {
        username blank: false, unique: true
        password blank: false
        slug nullable: true
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Permission> getAuthorities() {
        UserPermission.findAllByUser(this).collect { it.permission } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }
    
    public String toString() {
        displayName
    }

    protected void encodePassword() {
        if (!springSecurityService) {
            throw new RuntimeException("Uninitialized security service for ${displayName}")
        }
        
        password = springSecurityService.encodePassword(password)
    }
}
