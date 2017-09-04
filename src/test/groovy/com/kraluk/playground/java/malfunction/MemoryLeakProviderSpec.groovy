package com.kraluk.playground.java.malfunction

import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class MemoryLeakProviderSpec extends Specification {

    def "should provide a memory leak in the JVM"() {
        setup:
        def leak = new MemoryLeakProvider()

        expect:
        leak.provide()
    }
}
