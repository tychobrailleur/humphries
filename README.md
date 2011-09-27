# Objectives

The aim of the project is to provide quality Open-source tools to support
our own industry.  Another goal is to get acquainted with technologies,
either new or old, which we are not familiar with but that we think are
worth looking at.

# Roadmap

TBD


# Grails


## Documentation

* [User Guide](http://grails.org/doc/latest/)



## Command Summary

Here is a quick Grails command summary, useful when switching from one stack
to another!

* Run the app

        grails run-app
    
* Create a domain object

        grails create-domain-class org.humphries.MyNewClass
    
* Create a controller for MyNewClass (MyNewClassController)

        grails create-controller org.humphries.MyNewClass


### Spring Security plugin 

* [Documentation](http://grails-plugins.github.com/grails-spring-security-core/docs/manual/)


## Questions

1. When to use custom controllers vs. scaffolding?

    → Pierre: also, dynamic scaffolding vs. static scaffolding?

1. Unit testing: what to test vs. not to test (tied to scaffolding)?
1. Licensing


# Cucumber

Install cucumber:

        gem install cucumber webrat Selenium

Start Selenium:

        selenium

Running Cucumber for a specific feature file:

        cucumber features/ticket_creation.feature

Running specific tags:

        cucumber --tags @wip

# Webrat+Selenium

We have only been able to run Selenium against an old version of Firefox (i.e. 3.6.23) on Ubuntu, not against more recent versions. 

Set firefox executable path as follows on the command line:

       export SELENIUM_BROWSER="*firefox /path/to/firefox"

Webrat documentation: http://rdoc.info/github/brynary/webrat/master/frames

## Questions, issues

* Webrat vs. Capybara?
