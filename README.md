# Objectives

The aim of the project is to provide quality Open-source tools to support
our own industry.  Another goal is to get acquainted with technologies,
either new or old, which we are not familiar with but that we think are
worth looking at.

# Roadmap

TBD


# TODO


## Project

* Create project
* Add/remove member
* Tag/untag project

## User

* Registration
* Edit profile


## Ticket

* Create ticket
* Edit ticket
* Delete ticket
* Change ticket status
* Assign ticket
* Tag/untag ticket
* Add comments to ticket

## Dashboard

* project list
* ticket list

## Search

* ticket by title, tag, description
* project by name, description
* user by name

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
    
* Create a controller for `MyNewClass` (`MyNewClassController`)

        grails create-controller org.humphries.MyNewClass


### Spring Security plugin 

* [Documentation](http://grails-plugins.github.com/grails-spring-security-core/docs/manual/)


## Questions

1. Unit testing: what to test vs. not to test (tied to scaffolding)?
1. Licensing


# Implementation

The project uses a local plugin that has not been published yet,
`friendly-url`, that creates friendly URLs, so you may encounter
difficulties running the project as-is.


# Cucumber

See [Cucumber Wiki page](https://github.com/tychobrailleur/humphries/wiki/Cucumber)

Cucumber now uses Geb.   To run functional tests:

    grails test-app functional:cucumber
