package elasticsearch.demo

import grails.plugins.elasticsearch.ElasticSearchService
import groovy.transform.CompileStatic

@CompileStatic
class ProjectSearchService {
    ElasticSearchService elasticSearchService

    Map search(String query) {
        elasticSearchService.search(query, [indices: Project, types: Project, score: true]) as Map
    }
}
