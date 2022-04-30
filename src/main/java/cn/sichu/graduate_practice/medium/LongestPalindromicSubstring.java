package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 
 * @author sichu
 * @date 2022/04/20
 */
public class LongestPalindromicSubstring {
    /**
     * dp,
     * <p>
     * O(n<sup>2</sup>)
     * <p>
     * O(n<sup>2</sup>)
     * 
     * @param s
     * @return
     */
    public String longestPalindromeSolution1(String s) {
        if (s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int end = 1;
        char[] arr = s.toCharArray();
        for (int len = 2; len <= s.length(); len++) {
            for (int left = 0; left < s.length(); left++) {
                int right = len + left - 1;
                if (right > s.length() - 1) {
                    break;
                }
                if (arr[left] == arr[right]) {
                    if (right - left + 1 <= 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right]) {
                    start = left;
                    end = start + len;
                }
            }
        }
        return s.substring(start, end);
    }

    /**
     * 中心扩散，降低时间复杂度?
     * 
     * @param s
     * @return
     */
    public String longestPalindromeSolution2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int left = 0;
        int right = 0;
        int len = 1;
        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                ++len;
                --left;
            }
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                ++len;
                ++right;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                len = len + 2;
                --left;
                ++right;
            }
            if (len > maxLen) {
                maxLen = len;
                start = left;
            }
            len = 1;
        }
        return s.substring(start + 1, start + maxLen + 1);
    }

    /**
     * 
     * 
     * @param s
     * @return
     */
    public String longestPalindromeSolution3(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int start = 0;
        int end = 0;
        int maxLen = 1;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int right = 1; right < s.length(); right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                        start = left;
                        end = right;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // 保存起始位置， 用数组比全局变量快
        int[] range = new int[2];
        char[] arr = s.toCharArray();

        for (int left = 0; left < s.length(); left++) {
            // 把回文看成中间部分全是同一字符，左右部分对称
            // 找到下一个与当前字符不同的字符
            left = findLongest(arr, left, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    private static int findLongest(char[] arr, int left, int[] range) {
        // 查找中间部分
        int right = left;
        while (right < arr.length - 1 && arr[right + 1] == arr[left]) {
            right++;
        }

        // 定位中间部分最后一个字符
        int ans = right;

        // 从中间向左右扩散
        while (left > 0 && right < arr.length - 1 && arr[left - 1] == arr[right + 1]) {
            left--;
            right++;
        }

        // 记录最大长度
        if (right - left > range[1] - range[0]) {
            range[0] = left;
            range[1] = right;
        }

        return ans;
    }

    public String longestPalindromeSolution4(String s) {
        int[] range = new int[2];
        char[] arr = s.toCharArray();

        for (int left = 0; left < s.length(); left++) {
            range = findLongest2(arr, left, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    private static int[] findLongest2(char[] arr, int left, int[] range) {
        int right = left;
        while (right < arr.length - 1 && arr[right + 1] == arr[left]) {
            ++right;
        }
        while (left > 0 && right < arr.length - 1 && arr[left - 1] == arr[right + 1]) {
            ++right;
            --left;
        }
        if (right - left > range[1] - range[0]) {
            range[0] = left;
            range[1] = right;
        }
        return range;
    }

}
