package com.kraluk.playground.java.malfunction

import spock.lang.Ignore
import spock.lang.Specification

@Ignore("Just for experiments")
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
