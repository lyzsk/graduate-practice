package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * @author sichu
 * @date 2022/07/21
 */
public class OfferII014 {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        int[] count = new int[26];
        for (char ch : s1.toCharArray()) {
            ++count[ch - 'a'];
        }
        int[] cur = new int[26];
        for (int i = 0; i < m; i++) {
            ++cur[s2.charAt(i) - 'a'];
        }
        if (check(count, cur)) {
            return true;
        }
        for (int i = m; i < n; i++) {
            ++cur[s2.charAt(i) - 'a'];
            --cur[s2.charAt(i - m) - 'a'];
            if (check(count, cur)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
