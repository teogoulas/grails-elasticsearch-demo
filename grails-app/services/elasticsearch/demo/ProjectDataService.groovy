package elasticsearch.demo

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic

import java.time.LocalDateTime

@Transactional
@CompileStatic
@Service(Project)
interface ProjectDataService {
    Project save(String name, String summary, LocalDateTime beginDate, LocalDateTime endDate, BigDecimal northLatitude, BigDecimal southLatitude, BigDecimal westLatitude, BigDecimal eastLatitude)
    Number count()
}
