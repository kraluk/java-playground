package com.kraluk.playground.java.malfunction.leak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataStructerLeakProvider implements MemoryLeakProvider {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final int CAPACITY = 1_000_000_000;
    private static final List<Double> LIST = new ArrayList<>(CAPACITY);

    private Random random = new Random();

    @Override
    public void provide() throws InterruptedException {
        log.info("Attempting to fulfil the list...");

        for (int i = 0; i < CAPACITY; i++) {
            LIST.add(random.nextDouble());
        }

        log.info("List has been fulfilled with '{}' elements.", CAPACITY);

        log.info("Before GC suggestion.");
        System.gc();
        Thread.sleep(10_000); // to allow GC do its job
        log.info("After GC.");
    }
}
