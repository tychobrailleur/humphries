package org.humphries

class TagTagLib {
    static namespace = 'tag'
    
    static defaultEncodeAs = [ taglib: 'raw' ]

    def list = { attrs, body ->
        def tags = attrs.model.tags

        log.info "${tags} ${attrs.model}"

        out << tags.collect {
            render(template: '/tag/tag', model: [ tag: it ])
        }.collect { it.toString().trim() }.join(', ')
    }
}
