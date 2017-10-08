package com.kraluk.playground.java.malfunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * Simple {@link StackOverflowError} provider
 *
 * @author lukasz
 */
public final class StackOverflowErrorProvider {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public void provide() {
        log.info("Attempting to provide a StackOverflowError...");
        recursiveMethod();
    }

    private void recursiveMethod() {
        recursiveMethod();
    }
}
