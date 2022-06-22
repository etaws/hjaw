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
}