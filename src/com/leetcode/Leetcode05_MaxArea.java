package com.leetcode;


/**
 * @author 徐裕鹏
 * @date 2023/11/16 9:48
 */
public class Leetcode05_MaxArea {
    public static void main(String[] args) {
//        int[] ints = {1,8,6,2,5,4,8,3,7};
        int[] ints = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxArea(ints));
    }

    public static int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {

            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);


        }
        return res;
    }
}
