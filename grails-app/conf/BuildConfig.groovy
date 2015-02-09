grails.servlet.version = '3.0'
grails.project.work.dir = 'target'
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn"
    checksums true
    legacyResolve false
    
    repositories {
        inherits true

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
    }
    dependencies {
        runtime 'mysql:mysql-connector-java:5.1.13'
        runtime 'hsqldb:hsqldb:1.8.0.10'
        runtime 'commons-beanutils:commons-beanutils:1.8.3'

        build('com.lowagie:itext:2.0.8') {
            excludes 'bcprov-jdk14'
        }

        build 'org.yaml:snakeyaml:1.11'
        
        test 'org.grails:grails-datastore-test-support:1.0.2-grails-2.4'
    }

    plugins {
        build ':tomcat:7.0.55'

        // plugins for the compile step
        compile ':scaffolding:2.1.2'
        compile ':cache:1.1.8'
        compile ':asset-pipeline:2.1.1'
        compile ':sass-asset-pipeline:2.0.4'
        compile ':spring-security-core:2.0-RC4'
        compile ':fixtures:1.3'
        compile ':build-test-data:2.4.0'

        // plugins needed at runtime but not for compilation
        runtime ':hibernate4:4.3.6.1'
        runtime ':database-migration:1.4.0'
        runtime ':jquery:1.11.1'
        
    }
}
