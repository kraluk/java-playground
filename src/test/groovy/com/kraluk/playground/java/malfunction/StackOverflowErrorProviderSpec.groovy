package com.kraluk.playground.java.malfunction

import spock.lang.Specification

class StackOverflowErrorProviderSpec extends Specification {

    def "should provide a StackOverflowError"() {
        given:
        def provider = new StackOverflowErrorProvider()

        when:
        provider.provide()

        then:
        thrown(StackOverflowError)
    }
}
