package elasticsearch.demo

import grails.plugins.elasticsearch.ElasticSearchService
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ProjectSearchServiceSpec extends Specification implements ServiceUnitTest<ProjectSearchService>{

    def setup() {
    }

    def cleanup() {
    }

    def "search uses indices and types `Project` and score `true`"() {

        service.elasticSearchService = Mock(ElasticSearchService) as ElasticSearchService

        when:
        service.search('Grails')

        then:
        1 * service.elasticSearchService.search('Grails', [indices: Project, types: Project, score: true])
    }
}
