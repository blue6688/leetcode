package com.leetcode;

/**
 * @author 徐裕鹏
 * @date 2023/11/23 15:10
 */
public class LeetCode07_Trap {

    public static void main(String[] args) {
//        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4, 2, 0, 3, 2, 5};
        int res = trap(height);
        System.out.println(res);
    }

    public static int trap(int[] height) {
        int length = height.length;
        int area = 0;
        int left = 0;
        int right = length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (right > left) {

            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                area = area + leftMax - height[left];
                left++;
            } else if (height[left] >= height[right]) {
                rightMax = Math.max(rightMax, height[right]);
                area = area + rightMax - height[right];
                right--;
            }
        }
        return area;
    }
}
