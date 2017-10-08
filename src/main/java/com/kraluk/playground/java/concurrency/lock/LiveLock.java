package com.kraluk.playground.java.concurrency.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static com.kraluk.playground.java.concurrency.lock.LiveLock.SLEEP_TIME;

/**
 * Simple LiveLock example
 *
 * @author lukasz
 */
public final class LiveLock {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    static final long SLEEP_TIME = 1000;

    public static void main(String[] args) {
        Object left = "left";
        Object right = "right";

        // One's left is one's left
        Pedestrian one = new Pedestrian(left, right, 0);
        log.info("Created First Pedestrian.");

        // One's left is two's right, so have to swap order
        Pedestrian two = new Pedestrian(right, left, 1);
        log.info("Created Second Pedestrian.");

        one.setOther(two);
        two.setOther(one);

        new Thread(one, " First").start();
        new Thread(two, "Second").start();
    }
}

final class Pedestrian implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private Object left;
    private Object right;

    private Object current;

    private Pedestrian other;

    Pedestrian(Object left, Object right, int firstDirection) {
        this.left = left;
        this.right = right;

        if (firstDirection == 0) {
            current = this.left;
        } else {
            current = this.right;
        }
    }

    private void switchDirection() throws InterruptedException {
        Thread.sleep(SLEEP_TIME);
        current = getOppositeDirection();

        log.info("'{}' is stepping aside.", Thread.currentThread().getName());
    }

    private Object getDirection() {
        return current;
    }

    void setOther(Pedestrian other) {
        this.other = other;
    }

    private Object getOppositeDirection() {
        if (current.equals(left)) {
            return right;
        } else {
            return left;
        }
    }

    @Override
    public void run() {
        while (getDirection().equals(other.getDirection())) {
            try {
                switchDirection();
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                log.error("Exception occurred!", e);
            }
        }
    }
}
