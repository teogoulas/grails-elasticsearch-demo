package elasticsearch.demo


import grails.converters.*
import groovy.transform.CompileStatic

import static org.springframework.http.HttpStatus.*

@CompileStatic
class ProjectController {

    ProjectSearchService projectSearchService

	static responseFormats = ['json']

    static allowedMethods = [
            search: "GET"
    ]

    def search(String q) {
        if ( !q ) {
            render status: NOT_FOUND
            return
        }
        respond projectSearchService.search(q)
    }
}
