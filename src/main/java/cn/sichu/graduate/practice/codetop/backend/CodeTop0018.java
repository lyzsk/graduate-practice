package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class CodeTop0018 {
    public String longestPalindrome(String s) {
        int[] range = new int[2];
        char[] arr = s.toCharArray();
        for (int left = 0; left < s.length(); left++) {
            left = findLongest(arr, left, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    private static int findLongest(char[] arr, int left, int[] range) {
        int right = left;
        while (right < arr.length - 1 && arr[right] == arr[right + 1]) {
            ++right;
        }
        int res = right;

        while (left > 0 && right < arr.length - 1 && arr[left - 1] == arr[right + 1]) {
            ++right;
            --left;
        }
        if (right - left > range[1] - range[0]) {
            range[0] = left;
            range[1] = right;
        }

        return res;
    }
}
