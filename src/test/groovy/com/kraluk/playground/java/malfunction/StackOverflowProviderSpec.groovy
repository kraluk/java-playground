package com.kraluk.playground.java.malfunction

import spock.lang.Specification

class StackOverflowProviderSpec extends Specification {

    def "should provide a StackOverflowError"() {
        given:
        def provider = new StackOverflowProvider()

        when:
        provider.provide()

        then:
        thrown(StackOverflowError)
    }
}
