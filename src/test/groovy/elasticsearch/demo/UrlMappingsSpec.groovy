package elasticsearch.demo

import grails.testing.web.UrlMappingsUnitTest
import spock.lang.Specification

class UrlMappingsSpec extends Specification implements UrlMappingsUnitTest<UrlMappings> {

    void setup() {
        mockController(ProjectController)
    }

    void "project/search endpoint mapping includes query term in path"() {
        expect:
        verifyForwardUrlMapping("/project/search/grails", controller: 'project', action: 'search') {
            q = 'grails'
        }
    }
}