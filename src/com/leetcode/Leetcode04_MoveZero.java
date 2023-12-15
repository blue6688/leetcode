package com.leetcode;

import java.util.Arrays;

/**
 * @author 徐裕鹏
 * @date 2023/11/15 18:02
 */
public class Leetcode04_MoveZero {
    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes(ints);
        System.out.println(Arrays.toString(ints));


    }

    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }

    }
}
