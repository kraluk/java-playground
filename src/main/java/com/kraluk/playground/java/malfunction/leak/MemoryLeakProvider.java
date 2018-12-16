package com.kraluk.playground.java.malfunction.leak;

/**
 * Memory Leak provider
 * <p>
 * <b>Currently just a PoC</b>
 *
 * @author lukasz
 */
public interface MemoryLeakProvider {

    void provide() throws Exception;
}
