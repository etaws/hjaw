package com.my.hjaw;

import static org.junit.Assert.*;
import org.junit.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class StairsMoreTest {

    @Test
    public void testMainIt() {

        URL cpUrl = Thread.currentThread().getContextClassLoader().getResource("");
        assertNotNull(cpUrl);

        System.out.println("Classpath is: [" + cpUrl.getPath() + "]");
    }

    @Test
    public void testStair() {

        Map<Integer, Integer> expected = new HashMap<>();

        // 0 -> 0
        // 1 -> 1
        // 2 -> 2
        // 3 -> 3
        // 4 -> 5
        // ...
        expected.put(0, 0);
        expected.put(1, 1);
        expected.put(2, 2);
        expected.put(3, 3);
        expected.put(4, 5);

        StairsMore stairs = new StairsMore();
        for (Map.Entry<Integer, Integer> entry : expected.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            assertEquals(stairs.count(k), v);
        }
    }
}