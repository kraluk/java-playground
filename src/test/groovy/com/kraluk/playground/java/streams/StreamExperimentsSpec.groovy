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

    def "should calculate without a Stream"() {
        when:
        def result = StreamExperiments.Calculation.calculate()

        then:
        result == 60
    }

    def "should calculate with a Stream"() {
        when:
        def result = StreamExperiments.Calculation.calculateWithStream()

        then:
        result == 60
    }
}
