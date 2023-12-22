package com.leetcode;

import java.util.HashMap;

/**
 * @author 徐裕鹏
 * @date 2023/11/23 15:10
 */
public class LeetCode08_LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "bbtablud";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();

        if (length <= 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxLength = 0;

        for (r = 0; r < length; r++) {
            char current = s.charAt(r);
            if (map.containsKey(current)) {
                l = Math.max(map.get(current), l);
            }
            maxLength = Math.max(r - l + 1, maxLength);
            map.put(current, r + 1);
        }

        return maxLength;
    }
}
