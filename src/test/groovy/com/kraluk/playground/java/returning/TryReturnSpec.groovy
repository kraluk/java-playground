package com.kraluk.playground.java.returning

import spock.lang.Specification

class TryReturnSpec extends Specification {

    def "try and return in the given block"() {

        given:
            def input = 2

        when:
            def result = TryReturn.incrementAndReturn(input)

        then:
            result == 3 // not 4
    }
}