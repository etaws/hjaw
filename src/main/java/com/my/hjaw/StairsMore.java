package com.my.hjaw;

public class StairsMore {

    public int count(int stairNumber) {

        if (stairNumber == 0) {
            return 0;
        }

        if (stairNumber == 1) {
            return 1;
        }

        if (stairNumber == 2) {
            return 2;
        }

        int pre = 2;
        int prepre = 1;
        int ret = 0;
        for (int i = 3; i <= stairNumber; i++) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }

        return ret;
    }
}
