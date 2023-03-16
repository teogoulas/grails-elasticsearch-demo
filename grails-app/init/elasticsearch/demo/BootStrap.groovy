package elasticsearch.demo

import groovy.transform.CompileStatic

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@CompileStatic
class BootStrap {

    public final static List<Map<String, String>> GRAILS_PROJECTS = [
            [
                    name         : 'GOTHAAM: Greater New York Oxidant Trace gas Halogen and Aerosol Airborne Mission',
                    summary      : 'GOTHAAM is a collaborative field study to study the atmospheric chemistry of the New York City air plume, to understand the sources and sinks of air pollution in the region, and to think about how the plume impacts air quality and climate for the region. GOTHAAM will investigate the atmospheric chemistry in the skies above greater New York City in July-August 2023 using NSF/NCAR C-130 research aircraft.',
                    beginDate    : '2023-07-01 00:00:00',
                    endDate      : '2023-08-12 23:59:59',
                    northLatitude: '45.00',
                    southLatitude: '35.00',
                    westLatitude : '-80.00',
                    eastLatitude : '-70.00'
            ],
            [
                    name         : 'CG_WaveS: Convective Gravity Waves in the Stratosphere',
                    summary      : 'CG WaveS will seek to measure and quantify gravity waves excited by deep convection ranging from single cells to frontal systems and squall lines and their propagation and dissipation throughout the stratosphere. This will be accomplished by HIAPER lidar measurements using Rayleigh and Na resonance lidars aboard the NSF/NCAR HIAPER GV aircraft for flights over the central United States.',
                    beginDate    : '2023-05-28 00:00:00',
                    endDate      : '2023-07-02 23:59:59',
                    northLatitude: '46.00',
                    southLatitude: '34.00',
                    westLatitude : '-103.00',
                    eastLatitude : '-87.00'
            ],
    ] as List<Map<String, String>>

    ProjectDataService projectDataService

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    def init = { servletContext ->
        for (Map<String, String> projectInfo : GRAILS_PROJECTS) {
            projectDataService.save(projectInfo.name, projectInfo.summary, LocalDateTime.parse(projectInfo.beginDate, formatter), LocalDateTime.parse(projectInfo.endDate, formatter), new BigDecimal(projectInfo.northLatitude), new BigDecimal(projectInfo.southLatitude), new BigDecimal(projectInfo.westLatitude), new BigDecimal(projectInfo.eastLatitude))
        }
    }
    def destroy = {
    }
}

