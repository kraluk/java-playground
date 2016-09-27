package com.kraluk.playground.java

import spock.lang.Specification

class ApplicationSpec extends Specification {

    def "test specification"() {
        expect:
            true == (one && two)

        where:
            one  | two
            true | true
    }
}