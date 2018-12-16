package com.kraluk.playground.java.malfunction.leak;

/**
 * Unnecessary autoboxing while adding two numbers
 */
public class AutoBoxingLeakProvider implements MemoryLeakProvider {

    private static final int LIMIT = 100_000_000;

    @Override
    public void provide() {
        AutoBoxingLeakProvider provider = new AutoBoxingLeakProvider();

        for (long number = 0; number < LIMIT; number++) {
            provider.add(number);
        }
    }

    private long add(long number) {
        Long result = 0L; // !!!
        result = result + number;
        return result;
    }
}
