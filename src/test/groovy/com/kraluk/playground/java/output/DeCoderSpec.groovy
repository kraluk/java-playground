package com.kraluk.playground.java.output

import com.kraluk.playground.java.StandardOutputSpecification

class DeCoderSpec extends StandardOutputSpecification {

    def "should run the Decoder and get the result"() {
        given:
        def instance = new DeCoder()

        when:
        instance.run()

        then:
        outputContent.toString() == "b\nc\nd\n"
    }

    def "should run the Decoder in another way and get the result"() {
        given:
        def instance = new DeCoder()

        when:
        instance.runAnotherTime()

        then:
        outputContent.toString() == "b\nc\nd\n"
    }
}
