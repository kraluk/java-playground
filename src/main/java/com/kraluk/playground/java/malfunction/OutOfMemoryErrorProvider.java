package com.kraluk.playground.java.malfunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

/**
 * Simple {@link OutOfMemoryError} provider (in terms of standard JVM heap settings)
 *
 * @author lukasz
 */
public final class OutOfMemoryErrorProvider {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final int CAPACITY = 1_000_000_000;

    public void provide() {
        log.info("Attempting to provide a little disaster...");

        new ArrayList<String>(CAPACITY);
    }
}
