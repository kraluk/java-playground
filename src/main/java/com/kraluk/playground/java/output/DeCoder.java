package com.kraluk.playground.java.output;

/**
 * Just a simple character game
 *
 * @author lukasz
 */
public final class DeCoder {

    private static Character character; // static!

    public void run() {
        for (character = 'a'; character < 100; print(character)) {
            // empty on purpose
        }
    }

    private void print(int character) {
        this.character++;
        System.out.println(this.character);
    }

    public void runAnotherTime() {
        for (char index = 'a'; index < 100; System.out.println(++index)) {
            // empty on purpose
        }
    }
}
