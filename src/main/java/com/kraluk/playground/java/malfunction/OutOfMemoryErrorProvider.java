package com.kraluk.playground.java.malfunction;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * Simple {@link OutOfMemoryError} provider (in terms of standard JVM heap settings)
 *
 * @author lukasz
 */
@Slf4j
public final class OutOfMemoryErrorProvider {

    private static final int CAPACITY = 1_000_000_000;

    public void provide() {
        log.info("Attempting to provide a little disaster...");

        new ArrayList<String>(CAPACITY);
    }
}
