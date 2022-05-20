package cn.sichu.graduate_practice.codetop;

/**
 * 频率56
 * <p>
 * https://leetcode.cn/problems/minimum-window-substring/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        // 目标字符串指定字符出现次数
        int[] need = new int[128];
        // 已有字符串指定字符出现次数
        int[] have = new int[128];

        for (int i = 0; i < t.length(); i++) {
            ++need[t.charAt(i)];
        }
        int left = 0;
        int right = 0;
        // 最小长度的初始值为一个 一定不可能达到的长度
        int min = s.length() + 1;
        int count = 0;
        int start = 0;
        while (right < s.length()) {
            char rightCh = s.charAt(right);
            if (need[rightCh] == 0) {
                ++right;
                continue;
            }
            if (have[rightCh] < need[rightCh]) {
                ++count;
            }
            ++have[rightCh];
            ++right;

            // 当且仅当已有字符串已经包含了所有目标字符串的字符，且出现频次一定大于或等于指定频次
            while (count == t.length()) {
                // 当窗口的长度比已有的最短值小时，更改最小值，并记录起始位置
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                char leftCh = s.charAt(left);
                if (need[leftCh] == 0) {
                    ++left;
                    continue;
                }
                if (have[leftCh] == need[leftCh]) {
                    --count;
                }
                --have[leftCh];
                ++left;
            }
        }

        // 如果最小长度还为初始值，说明没有符合条件的子串
        if (min == s.length() + 1) {
            return "";
        }
        return s.substring(start, start + min);
    }
}
