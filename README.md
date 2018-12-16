# java-playground

[![CircleCI](https://circleci.com/gh/kraluk/java-playground/tree/master.svg?style=svg)](https://circleci.com/gh/kraluk/java-playground/tree/master)

The project contains some tricky and twisted cases which can be implemented with Java, but there are also some classic ones, which could be quite interesting for new Java developers and not only.

## Table of Contents

- Concurrency
    + `DeadLock`
    + `LiveLock`
- Output plays
    + `DeCoder`
- Java language specifics
    + `OverloadingStuff` - some play with overloading in Java
    + `TryExperiments` - a playground for `try` block stuff
    + `StreamExperiments` - like above, but for `java.util.Stream` things
- Providers
    + `OutOfMemoryErrorProvider`
    + `StackOverflowErrorProvider`
    
## Information

- for every, let's say, experiment there is a test/specification written in Groovy and Spock
- for most of the experiments, loggers are used, but for some specific cases, legendary `System.out.println` is also applicable.