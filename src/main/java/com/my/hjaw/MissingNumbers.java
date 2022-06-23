package com.my.hjaw;

import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {

    public Integer[] getMissing(Integer[] a) {

        for (Integer v : a) {
            flopIt(v, a);
        }

        List<Integer> r = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                r.add(i + 1);
            }
        }
        return r.toArray(r.toArray(new Integer[0]));
    }

    private void flopIt(int v, Integer[] a) {
        if (v < 0) {
            v = -v;
        }

        assert (v >= 1) && (v <= a.length);

        v = v - 1;
        if (a[v] <= 0) {
            return;
        }

        a[v] = -a[v];
    }
}
