package com.my.hjaw;

public class MoveZ {

    public void move(int[] a) {

        int j = 0;

        for (int i = 0; i < a.length; ++i) {
            if (a[i] != 0) {
                a[j++] = a[i];
            }
        }

        for (; j < a.length; ++j) {
            a[j] = 0;
        }

    }
}
