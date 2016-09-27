package com.kraluk.playground.java.returning;

import lombok.extern.slf4j.Slf4j;

/**
 * {@code try} test cases
 *
 * @author lukasz
 */
@Slf4j
public class TryReturn {

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