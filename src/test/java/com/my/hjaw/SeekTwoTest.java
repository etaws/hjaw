package com.my.hjaw;

import static org.junit.Assert.*;
import org.junit.Test;

public class SeekTwoTest {

    @Test
    public void testIt() {

        checkSeekTwo(new int[]{3, 9, 20, 15, 7}, 19, new int[]{0, 0});
        checkSeekTwo(new int[]{3, 9, 20, 15, 7}, 18, new int[]{0, 3});
        checkSeekTwo(new int[]{15, 11, 7, 2}, 9, new int[]{2, 3});
        checkSeekTwo(new int[]{2, 3, 4}, 6, new int[]{0, 2});
        checkSeekTwo(new int[]{3, 3}, 6, new int[]{0, 1});

    }

    private void checkSeekTwo(int[] vals, int target, int[] results) {
        assertArrayEquals(results, new SeekTwo().count(vals, target));
    }

}