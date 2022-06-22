package com.my.hjaw;

public class SortedMerge {

    public void merge(int[] a, int[] b) {

        if ((a.length == 0) && (b.length == 0)) {
            return;
        }

        if (b.length == 0) {
            return;
        }

        assert a.length >= b.length;

        int i = a.length;
        for (; i > 0; i--) {
            if (a[i - 1] != 0) {
                int trueLength = a.length - i + 1;
                assert a.length == (b.length + trueLength);
                break;
            }
        }

        int k = a.length;
        int j = b.length;

        while ((j > 0) && (i > 0)) {
            if (b[j - 1] >= a[i - 1]) {
                a[--k] = b[--j];
            } else {
                a[--k] = a[--i];
            }
        }

        if (j > 0) {
            while (j > 0) {
                a[--k] = b[--j];
            }
        }

        if (i > 0) {
            while (i > 0) {
                a[--k] = a[--i];
            }
        }
    }
}
