package elasticsearch.demo

import grails.plugins.elasticsearch.ElasticSearchResult
import grails.plugins.elasticsearch.ElasticSearchService
import groovy.transform.CompileStatic

@CompileStatic
class ProjectSearchService {
    ElasticSearchService elasticSearchService

    Map search(String query) {
        ElasticSearchResult result = elasticSearchService.search(query, [indices: Project, types: Project, score: true])
        return [
                'total': result.getTotal().value,
                'searchResults': result.getSearchResults(),
                'scores': result.getScores(),
                'sort': result.getSort(),
                'aggregations': result.getAggregations(),
        ]
    }
}

