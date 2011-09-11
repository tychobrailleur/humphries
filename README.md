# Objectives

The aim of the project is to provide quality Open-source tools to support
our own industry.  Another goal is to get acquainted with technologies,
either new or old, which we are not familiar with but that we think are
worth looking at.

# Roadmap

TBD


# Grails


## Command Summary

Here is a quick Grails command summary, useful when switching from one stack
to another!

* Run the app

        grails run-app
    
* Create a domain object

        grails create-domain-class org.humphries.MyNewClass
    
* Create a controller for MyNewClass (MyNewClassController)

        grails create-controller org.humphries.MyNewClass
    
## Questions

1. When to use custom controllers vs. scaffolding?
1. Unit testing: what to test vs. not to test (tied to scaffolding)?
1. Cucumber?
1. Licensing


# Cucumber

Install cucumber:

        gem install cucumber mechanize

Running Cucumber:

        cucumber features/ticket_creation.feature

