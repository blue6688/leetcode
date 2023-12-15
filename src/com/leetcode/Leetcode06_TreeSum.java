package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 徐裕鹏
 * @date 2023/11/16 11:33
 */
public class Leetcode06_TreeSum {
    public static void main(String[] args) {
//        int[] ints = {-1, 0, 1, 2, -1, -4};
        int[] ints = {34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49};
//        int[] ints = {0,0,0,0};

        System.out.println(treeSum(ints));
    }

    public static List<List<Integer>> treeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length < 3) return result;

        Arrays.sort(nums);

        // -4, -1, -1, 0, 1, 2
        // 0, 0, 0, 0

        for (int first = 0; first < length; first++) {
            if (nums[first] > 0) {
                continue;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = length - 1;
            int target = -nums[first];
            for (int second = first + 1; second < length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }


                while (third > second && nums[second] + nums[third] > target) {
                    third--;
                }

//                if (second == third) {
//                    break;
//                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> temp = Arrays.asList(nums[first], nums[second], nums[third]);

                    result.add(temp);

                }


            }

        }
        return result;
    }

    public static List<List<Integer>> treeSum1(int[] nums) {

        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;

    }
}
