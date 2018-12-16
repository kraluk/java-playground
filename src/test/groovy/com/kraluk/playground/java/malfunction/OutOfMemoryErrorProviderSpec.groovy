package com.kraluk.playground.java.malfunction

import spock.lang.Specification

class OutOfMemoryErrorProviderSpec extends Specification {

    def "should provide an OutOfMemoryError"() {
        given:
        def provider = new OutOfMemoryErrorProvider()

        when:
        provider.provide()

        then:
        thrown(OutOfMemoryError)
    }
}
