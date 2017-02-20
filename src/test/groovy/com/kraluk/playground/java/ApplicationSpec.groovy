package com.kraluk.playground.java

import spock.lang.Specification

class ApplicationSpec extends Specification {

    def "test specification"() {
        when:
            Application.main()

        then:
            noExceptionThrown()
    }
}