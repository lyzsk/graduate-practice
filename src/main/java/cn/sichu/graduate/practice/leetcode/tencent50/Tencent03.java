package cn.sichu.graduate.practice.leetcode.tencent50;

/**
 * @author sichu
 * @date 2022/06/11
 */
public class Tencent03 {
    public String longestPalindrome(String s) {
        int[] range = new int[2];
        char[] arr = s.toCharArray();
        for (int left = 0; left < arr.length; left++) {
            left = findLongest(arr, range, left);
        }
        return s.substring(range[0], range[1] + 1);
    }

    private static int findLongest(char[] arr, int[] range, int startIndex) {
        int left = startIndex;
        int right = startIndex;
        while (right < arr.length - 1 && arr[right] == arr[right + 1]) {
            ++right;
        }
        int res = right;
        while (left > 0 && right < arr.length - 1 && arr[left - 1] == arr[right + 1]) {
            --left;
            ++right;
        }
        if (range[1] - range[0] < right - left) {
            range[0] = left;
            range[1] = right;
        }
        return res;
    }
}
