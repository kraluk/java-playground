package com.kraluk.playground.java.malfunction.leak

import spock.lang.Specification

class AutoBoxingLeakProviderSpec extends Specification {

    def "should provide a memory leak in the JVM"() {
        given:
        def leak = new AutoBoxingLeakProvider()

        when:
        leak.provide()

        then:
        noExceptionThrown()
    }
}
