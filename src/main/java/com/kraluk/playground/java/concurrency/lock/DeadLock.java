package com.kraluk.playground.java.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * Simple DeadLock example
 *
 * @author lukasz
 */
@Slf4j
public class DeadLock {

    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args)  {
        Thread threadOne = new Thread(new ThreadOne(), "ThreadOne");
        Thread threadTwo = new Thread(new ThreadTwo(), "ThreadTwo");

        log.info("Attempting to start...");
        threadOne.start();
        threadTwo.start();
        log.info("Threads started!");
    }

    private static class ThreadOne implements Runnable {

        @Override
        public void run() {

            synchronized (resource2) {
                log.info("'{}': locked 'resource2'.", Thread.currentThread().getName());

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    log.error("Exception occurred!", e);
                }

                synchronized (resource1) {
                    log.info("'{}': locked 'resource1'.", Thread.currentThread().getName());
                }
            }
        }
    }

    private static class ThreadTwo implements Runnable {

        @Override
        public void run() {

            synchronized (resource1) {
                log.info("'{}': locked 'resource1'.", Thread.currentThread().getName());

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    log.error("Exception occurred!", e);
                }

                synchronized (resource2) {
                    log.info("'{}': locked 'resource2'.", Thread.currentThread().getName());
                }
            }
        }
    }
}