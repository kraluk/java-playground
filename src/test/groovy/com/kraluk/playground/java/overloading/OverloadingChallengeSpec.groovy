package com.kraluk.playground.java.overloading

import com.kraluk.playground.java.StandardOutputSpecification
import spock.lang.Unroll

class OverloadingChallengeSpec extends StandardOutputSpecification {

    @Unroll
    def "should get #expected"() {
        given:
        def challenge = new OverloadingChallenge()

        when:
        challenge.invoke(argument)

        then:
        outputContent.toString() == expected

        where:
        argument               || expected
        new Object()           || Object.class.getSimpleName()
        new Exception()        || Exception.class.getSimpleName()
        new RuntimeException() || RuntimeException.class.getSimpleName()
    }

    def "should get Object from NULL"() {
        given:
        def challenge = new OverloadingChallenge()

        when:
        challenge.invoke(null)

        then:
        outputContent.toString() == Object.class.getSimpleName()
    }
}
