package com.kraluk.playground.java.overloading;

/**
 * Crazy Overloading Challenge
 * <p/>
 * {@code System.out.print} has been used due to willingness to check {@code null} case. More details could be found in {@code OverloadingChallengeSpec}.
 *
 * @author lukasz
 */
public final class OverloadingChallenge {

    public void invoke(Object object) {
        System.out.print(Object.class.getSimpleName());
    }

    public void invoke(Exception exception) {
        System.out.print(Exception.class.getSimpleName());
    }

    public void invoke(RuntimeException runtimeException) {
        System.out.print(RuntimeException.class.getSimpleName());
    }
}
