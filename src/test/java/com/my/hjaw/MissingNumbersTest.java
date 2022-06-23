package com.my.hjaw;

import static org.junit.Assert.*;
import org.junit.Test;

public class MissingNumbersTest {

    @Test
    public void testIt() {

        assertArrayEquals(runIt(new Integer[]{1, 1}), new Integer[]{2});
        assertArrayEquals(runIt(new Integer[]{3, 2, 1, 2, 3, 7, 7}), new Integer[]{4, 5, 6});
    }

    private Integer[] runIt(Integer[] a) {
        return new MissingNumbers().getMissing(a);
    }

}