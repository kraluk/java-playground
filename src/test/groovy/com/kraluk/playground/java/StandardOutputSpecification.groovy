package com.kraluk.playground.java

import spock.lang.Specification

abstract class StandardOutputSpecification extends Specification {

    ByteArrayOutputStream outputContent = new ByteArrayOutputStream()
    ByteArrayOutputStream errorContent = new ByteArrayOutputStream()

    def setup() {
        outputContent = new ByteArrayOutputStream()
        errorContent = new ByteArrayOutputStream()

        System.setOut(new PrintStream(outputContent))
        System.setErr(new PrintStream(errorContent))
    }

    def cleanup() {
        System.setOut(null)
        System.setErr(null)
    }
}
