package com.kraluk.playground.java.concurrency.lock;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import static com.kraluk.playground.java.concurrency.lock.LiveLock.SLEEP_TIME;

/**
 * Simple LiveLock example
 *
 * @author lukasz
 */
@Slf4j
public class LiveLock {

    static final long SLEEP_TIME = 1000;

    public static void main(String[] args) throws InterruptedException {
        Object left = "left";
        Object right = "right";

        // One's left is one's left
        Pedestrian one = new Pedestrian(left, right, 0);

        // One's left is two's right, so have to swap order
        Pedestrian two = new Pedestrian(right, left, 1);

        one.setOther(two);
        two.setOther(one);

        new Thread(one, " First").start();
        new Thread(two, "Second").start();
    }
}

@Slf4j
class Pedestrian implements Runnable {

    private Object left;
    private Object right;

    private Object current;

    @Setter(AccessLevel.PACKAGE)
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
