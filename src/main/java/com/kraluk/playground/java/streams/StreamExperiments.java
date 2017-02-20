package com.kraluk.playground.java.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Just experiments related with {@link Stream}s
 *
 * @author lukasz
 */
@Slf4j
public final class StreamExperiments {

    public static void modifyStream() {
        List<String> strings = Stream.of("1", "2", "3").collect(Collectors.toList());

        strings = strings.subList(0, 2);

        Stream<String> stream = strings.stream();
        strings.add("XXX");

        stream.forEach(log::info);
    }
}
