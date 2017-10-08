package com.kraluk.playground.java.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Just experiments related with {@link Stream}s
 *
 * @author lukasz
 */
public final class StreamExperiments {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * Very interesting case. In Java 8 the code below will throw a {@link java.util.ConcurrentModificationException},
     * but in Java 9 due to changed {@link java.util.Spliterator} in the {@link java.util.ArrayList} implementation
     * which is used in {@link Collectors#toList()} collector, everything will go totally OK.
     * <p/>
     * More details can be found in {@link java.util.ArrayList.SubList#spliterator()} implementation.
     */
    public static void modifyStream() {
        List<String> strings = Stream.of("1", "2", "3").collect(Collectors.toList());

        strings = strings.subList(0, 2);

        Stream<String> stream = strings.stream();
        strings.add("XXX");

        stream.forEach(log::info);
    }
}
