package org.humphries

import org.humphries.auth.User

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@Mock([Ticket, User, Tag])
@Build([Ticket, User, Tag])
@TestFor(TagTagLib)
class TagTagLibSpec extends Specification {
    
    def setup() {
    }

    def cleanup() {
    }

    void "displays the tags correctly"() {
        given:
        def t = Ticket.build(tags: [ Tag.build(name: 'foobar'), Tag.build(name: 'quxbaz')])

        expect:
        applyTemplate('<tag:list model="${ticket}"/>', [ticket: t]) == '<a href="/tag/show?name=foobar">foobar</a>, ' + '<a href="/tag/show?name=quxbaz">quxbaz</a>'
    }
}
