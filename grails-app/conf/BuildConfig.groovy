grails.servlet.version = '3.0'
grails.project.work.dir = 'target'
grails.project.target.level = 1.7
grails.project.source.level = 1.7

grails.project.fork = [
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {
    inherits 'global'
    log 'warn'
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
        build ':jetty:3.0.0'

        // plugins for the compile step
        compile ':scaffolding:2.1.2'
        compile ':cache:1.1.8'
        compile ':quartz:1.0.2'
        compile ':asset-pipeline:2.1.1'
        compile ':sass-asset-pipeline:2.1.1'
        compile ':spring-security-core:2.0-RC4'
        compile ':fixtures:1.3'
        compile ':build-test-data:2.4.0'
        compile ':dbconsole:1.1'

        // plugins needed at runtime but not for compilation
        runtime ':hibernate4:4.3.6.1'
        runtime ':database-migration:1.4.0'
        runtime ':jquery:1.11.1'
        runtime ':twitter-bootstrap:3.3.4'
    }
}
