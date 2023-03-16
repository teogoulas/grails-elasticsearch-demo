package elasticsearch.demo

import java.time.LocalDateTime


class Project {
    String name
    String summary
    LocalDateTime beginDate
    LocalDateTime endDate
    BigDecimal northLatitude
    BigDecimal southLatitude
    BigDecimal westLatitude
    BigDecimal eastLatitude

    static constraints = {
        name nullable: false, blank: false, unique: true
    }

    static searchable = {
        name boost: 2.0
    }

    static mapping = {
        name type: 'text'
        summary type: 'text'
    }

    Map toJson() {
        return [
                'name'         : name,
                'summary'      : summary,
                'beginDate'    : beginDate,
                'endDate'      : endDate,
                'northLatitude': northLatitude,
                'southLatitude': southLatitude,
                'westLatitude' : westLatitude,
                'eastLatitude' : eastLatitude
        ]
    }
}
