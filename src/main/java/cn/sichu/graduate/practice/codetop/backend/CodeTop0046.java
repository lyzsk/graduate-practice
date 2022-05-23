package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/22
 */
public class CodeTop0046 {
    public String minWindow(String s, String t) {
        if (s == null || "".equals(s) || t == null || "".equals(t) || s.length() < t.length()) {
            return "";
        }
        int[] need = new int[128];
        int[] have = new int[128];
        for (int i = 0; i < t.length(); i++) {
            ++need[t.charAt(i)];
        }
        int slow = 0;
        int fast = 0;
        int windowLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int count = 0;
        while (fast < s.length()) {
            if (need[s.charAt(fast)] == 0) {
                ++fast;
                continue;
            }
            if (have[s.charAt(fast)] < need[s.charAt(fast)]) {
                ++count;
            }
            ++have[s.charAt(fast)];
            ++fast;
            while (count == t.length()) {
                if (fast - slow < windowLength) {
                    windowLength = fast - slow;
                    windowStart = slow;
                }
                if (need[s.charAt(slow)] == 0) {
                    ++slow;
                    continue;
                }
                if (have[s.charAt(slow)] == need[s.charAt(slow)]) {
                    --count;
                }
                --have[s.charAt(slow)];
                ++slow;
            }
        }
        if (windowLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(windowStart, windowStart + windowLength);
    }
}
