package com.kraluk.playground.java.malfunction;

import lombok.extern.slf4j.Slf4j;

/**
 * Simple {@link StackOverflowError} provider
 *
 * @author lukasz
 */
@Slf4j
public final class StackOverflowProvider {

    public void provide() {
        log.info("Attempting to provide a StackOverflowError...");
        recursiveMethod();
    }

    private void recursiveMethod() {
        recursiveMethod();
    }
}
