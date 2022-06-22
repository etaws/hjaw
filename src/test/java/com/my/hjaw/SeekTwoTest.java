package com.my.hjaw;

import static org.junit.Assert.*;
import org.junit.Test;

public class SeekTwoTest {

    @Test
    public void testIt() {

        checkSeekTwo(new int[]{3, 9, 20, 15, 7}, 19, new int[]{0, 0});
        checkSeekTwo(new int[]{3, 9, 20, 15, 7}, 18, new int[]{0, 3});
    }

    private void checkSeekTwo(int[] vals, int target, int[] results) {
        assertArrayEquals(results, new SeekTwo().count(vals, target));
    }

}