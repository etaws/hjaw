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

    @Test
    public void testReverseList() {
        assertArrayEquals(new Integer[]{3}, new SortedMerge().reverseList(new Integer[]{3}));
        assertArrayEquals(new Integer[]{3, 9, 20}, new SortedMerge().reverseList(new Integer[]{20, 9, 3}));
    }

    @Test
    public void testMidList() {
        assertArrayEquals(new Integer[]{3}, new SortedMerge().midList(new Integer[]{3}));
        assertArrayEquals(new Integer[]{4}, new SortedMerge().midList(new Integer[]{3, 4}));
        assertArrayEquals(new Integer[]{9}, new SortedMerge().midList(new Integer[]{3, 9, 20}));
        assertArrayEquals(new Integer[]{10}, new SortedMerge().midList(new Integer[]{3, 9, 10, 20}));
    }

    @Test
    public void testKList() {
        assertArrayEquals(new Integer[]{3}, new SortedMerge().kTailList(new Integer[]{3}, 1));
        assertArrayEquals(new Integer[]{4}, new SortedMerge().kTailList(new Integer[]{3, 4}, 1));
        assertArrayEquals(new Integer[]{9}, new SortedMerge().kTailList(new Integer[]{3, 9, 20}, 2));
        assertArrayEquals(new Integer[]{3}, new SortedMerge().kTailList(new Integer[]{3, 9, 10, 20}, 4));
        assertArrayEquals(new Integer[0], new SortedMerge().kTailList(new Integer[]{3, 9, 10, 20}, 5));
    }

}