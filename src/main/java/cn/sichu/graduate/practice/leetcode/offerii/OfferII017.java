package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * A~Z: 65~90, a~z: 97~122
 * 
 * @author sichu
 * @date 2022/07/21
 */
public class OfferII017 {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return "";
        }
        int[] map = new int[58];
        int diff = 0;
        for (int i = 0; i < tLen; i++) {
            ++map[t.charAt(i) - 'A'];
            --map[s.charAt(i) - 'A'];
        }
        for (int val : map) {
            if (val > 0) {
                ++diff;
            }
        }
        if (diff == 0) {
            return s.substring(0, tLen);
        }
        int left = 0;
        int right = tLen;
        int leftMin = 0;
        int rightMin = sLen;
        for (; right < sLen; right++) {
            int in = s.charAt(right) - 'A';
            --map[in];
            if (map[in] == 0) {
                --diff;
            }
            if (diff != 0) {
                continue;
            }
            for (; diff == 0; left++) {
                int out = s.charAt(left) - 'A';
                ++map[out];
                if (map[out] == 1) {
                    ++diff;
                }
            }
            if (right - left + 2 < rightMin - leftMin + 1) {
                leftMin = left - 1;
                rightMin = right;
            }
        }
        return rightMin == sLen ? "" : s.substring(leftMin, rightMin + 1);
    }
}
