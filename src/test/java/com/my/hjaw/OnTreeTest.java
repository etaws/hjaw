package com.my.hjaw;

import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class OnTreeTest {

    @Test
    public void testMid() {
        Integer[] vals = new Integer[]{7, 9, 8, 5, 10, null, 12, 6, null, 13, null};
        Integer[] expects = new Integer[]{6, 5, 9, 13, 10, 7, 8, 12};

        Integer[] shows = new OnTree().mid(vals);

        assertArrayEquals(shows, expects);

        System.out.println("tree size: " + shows.length);
        for (Integer show : shows) {
            System.out.printf(" " + show);
        }
    }

    @Test
    public void testPre() {
        Integer[] vals = new Integer[]{7, 9, 8, 5, 10, null, 12, 6, null, 13, null};
        Integer[] expects = new Integer[]{7, 9, 5, 6, 10, 13, 8, 12};

        Integer[] shows = new OnTree().pre(vals);

        assertArrayEquals(shows, expects);

        System.out.println("tree size: " + shows.length);
        for (Integer show : shows) {
            System.out.printf(" " + show);
        }
    }

    @Test
    public void testPost() {
        Integer[] vals = new Integer[]{7, 9, 8, 5, 10, null, 12, 6, null, 13, null};
        Integer[] expects = new Integer[]{6, 5, 13, 10, 9, 12, 8, 7};

        Integer[] shows = new OnTree().post(vals);

        assertArrayEquals(shows, expects);

        System.out.println("tree size: " + shows.length);
        for (Integer show : shows) {
            System.out.printf(" " + show);
        }
    }

    @Test
    public void testHeight() {
        Integer[] vals = new Integer[]{7, 9, 8, 5, 10, null, 12, 6, null, 13, null};
        Assert.assertEquals(4, new OnTree().height(vals));
    }

    @Test
    public void testFlop() {
        Integer[] vals = new Integer[]{7, 9, 8, 5, 10, null, 12, 6, null, 13, null};
        Integer[] results = new OnTree().flop(vals);

        System.out.println("tree size: " + results.length);
        for (Integer show : results) {
            System.out.printf(" " + show);
        }
    }
}