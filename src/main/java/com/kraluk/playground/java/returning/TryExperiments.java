package com.kraluk.playground.java.returning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * {@code try} test cases
 *
 * @author lukasz
 */
public final class TryExperiments {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * Checks the behaviour of try/catch/finally mechanism when returning value in the try closure
     *
     * @param n simple integer
     * @return result
     * @see <a href="http://www.pixelstech.net/article/1474892842-try-%7B-return-%7D-finally-%7B%7D">more about that case</a>
     */
    public static int incrementAndReturn(int n) {

        try {
            return ++n;
        } catch (Exception e) {
            log.info("I'm in the catch block...", e);
        } finally {
            log.info("I'm in the finally block...");
            ++n;
        }

        return n;
    }
}