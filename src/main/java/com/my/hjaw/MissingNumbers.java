package com.my.hjaw;

import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {

    public Integer[] getMissing(Integer[] nums) {

        int i = 0;
        while (i < nums.length) {
            // 第几个数已经存在？如果是第 1 个数存在，那么 j 就是 0

            int j = 0;
            if (nums[i] < 0) {
                j = -nums[i] - 1;
            } else {
                j = nums[i] - 1;
            }


            // 如果 j 这个数已经存在，那么把 a[j] 改为负数，作为 j 存在的标志
            if (nums[j] > 0) {
                nums[j] = -nums[j];
            }

            i += 1;
        }

        List<Integer> r = new ArrayList<>();

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                r.add(j + 1);
            }
        }

        return r.toArray(r.toArray(new Integer[0]));
    }
}
