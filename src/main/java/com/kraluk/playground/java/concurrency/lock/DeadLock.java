package com.kraluk.playground.java.concurrency.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * Simple DeadLock example
 *
 * @author lukasz
 */
public final class DeadLock {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final Object RESOURCE_1 = new Object();
    private static final Object RESOURCE_2 = new Object();

    public static void main(String[] args) {
        Thread threadOne = new Thread(new ThreadOne(), "ThreadOne");
        Thread threadTwo = new Thread(new ThreadTwo(), "ThreadTwo");

        log.info("Attempting to start...");
        threadOne.start();
        threadTwo.start();
        log.info("Threads started!");
    }

    private static final class ThreadOne implements Runnable {

        @Override
        public void run() {

            synchronized (RESOURCE_2) {
                log.info("'{}': locked 'RESOURCE_2'.", Thread.currentThread().getName());

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    log.error("Exception occurred!", e);
                }

                synchronized (RESOURCE_1) {
                    log.info("'{}': locked 'RESOURCE_1'.", Thread.currentThread().getName());
                }
            }
        }
    }

    private static final class ThreadTwo implements Runnable {

        @Override
        public void run() {

            synchronized (RESOURCE_1) {
                log.info("'{}': locked 'RESOURCE_1'.", Thread.currentThread().getName());

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    log.error("Exception occurred!", e);
                }

                synchronized (RESOURCE_2) {
                    log.info("'{}': locked 'RESOURCE_2'.", Thread.currentThread().getName());
                }
            }
        }
    }
}