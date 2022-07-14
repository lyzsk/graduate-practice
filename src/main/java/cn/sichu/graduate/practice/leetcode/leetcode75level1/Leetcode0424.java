package cn.sichu.graduate.practice.leetcode.leetcode75level1;

/**
 * @author sichu
 * @date 2022/07/12
 */
public class Leetcode0424 {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int res = 0;
        while (right < s.length()) {
            ++freq[arr[right] - 'A'];
            maxCount = Math.max(maxCount, freq[arr[right] - 'A']);
            ++right;
            if (right - left > maxCount + k) {
                --freq[arr[left] - 'A'];
                ++left;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
