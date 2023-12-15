package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * @author 徐裕鹏
 * @date 2023/11/15 16:53
 */
public class Leetcode03_LongestConsecutive {
    public static void main(String[] args) {
        int[] ints = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println(longestConsecutive(ints));

    }

    public static int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length <= 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }

        Integer counter = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : set) {
            counter++;
            if (!set.contains(integer + 1)) {
                result.add(counter);
                counter = 0;
            }
        }
        return Collections.max(result);
    }
}
