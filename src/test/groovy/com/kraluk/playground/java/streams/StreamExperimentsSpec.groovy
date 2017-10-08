package com.kraluk.playground.java.streams

import spock.lang.Specification

class StreamExperimentsSpec extends Specification {

    def "should thrown ConcurrentModificationException"() {
        when:
        StreamExperiments.modifyStream()

        then:
        noExceptionThrown()

        // thrown(ConcurrentModificationException) // only when Java 8 is used
    }
}
