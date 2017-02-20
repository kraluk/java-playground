package com.kraluk.playground.java.streams

import spock.lang.Specification

class StreamExperimentsSpec extends Specification {

    def "should thrown ConcurrentModificationException"() {
        when:
            StreamExperiments.modifyStream()

        then:
            thrown(ConcurrentModificationException)
    }
}
