package com.my.hjaw;

import static org.junit.Assert.*;
import org.junit.Test;

public class SortedMergeTest {

    @Test
    public void testIt() {
        int[] a = new int[]{3, 9, 20, 0, 0};
        int[] b = new int[]{1, 2};
        new SortedMerge().merge(a, b);

        assertArrayEquals(new int[]{1, 2, 3, 9, 20}, a);
    }

    @Test
    public void testEmpty() {
        int[] a = new int[]{0, 0};
        int[] b = new int[]{1, 2};
        new SortedMerge().merge(a, b);

        assertArrayEquals(new int[]{1, 2}, a);
    }

    @Test
    public void testEmptyB() {
        int[] a = new int[]{3, 4, 5};
        int[] b = new int[]{};
        new SortedMerge().merge(a, b);

        assertArrayEquals(new int[]{3, 4, 5}, a);
    }

    @Test
    public void testBothEmpty() {
        int[] a = new int[]{0, 0};
        int[] b = new int[]{};
        new SortedMerge().merge(a, b);

        assertArrayEquals(new int[]{0, 0}, a);
    }

    @Test
    public void testOnList() {
        Integer[] c = new SortedMerge().mergeByList(new Integer[]{3, 9, 20}, new Integer[]{1, 2});

        assertArrayEquals(new Integer[]{1, 2, 3, 9, 20}, c);
    }

    @Test
    public void testDistinctList() {
        assertArrayEquals(new Integer[]{3, 9, 20}, new SortedMerge().distinctList(new Integer[]{3, 9, 20}));
        assertArrayEquals(new Integer[]{3, 9, 20}, new SortedMerge().distinctList(new Integer[]{3, 3, 9, 9, 20}));
    }
}