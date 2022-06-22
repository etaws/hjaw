package com.my.hjaw;

import java.util.HashMap;
import java.util.Map;

public class SeekTwo {

    public int[] count(int[] a, int target) {

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < a.length; ++i) {
            int expected = target - a[i];
            Integer pos = m.get(expected);
            if (pos != null) {
                return new int[]{pos, i};
            }

            m.put(a[i], i);
        }

        return new int[]{0, 0};
    }
}
