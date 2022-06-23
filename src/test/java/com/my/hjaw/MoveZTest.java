package com.my.hjaw;

import static org.junit.Assert.*;
import org.junit.Test;

public class MoveZTest {

    @Test
    public void testIt() {

        int[] a = new int[]{3, 9, 0, 20, 0, 15, 7};
        new MoveZ().move(a);

        assertArrayEquals(a, new int[]{3, 9, 20, 15, 7, 0, 0});
    }

}