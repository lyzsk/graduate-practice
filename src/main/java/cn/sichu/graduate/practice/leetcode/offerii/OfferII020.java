package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class OfferII020 {
    public int countSubstrings(String s) {
        int res = 0;
        char[] arr = s.toCharArray();
        for (int left = 0; left < s.length(); left++) {
            res += extend(arr, left, left);
            res += extend(arr, left, left + 1);
        }
        return res;
    }

    private static int extend(char[] arr, int left, int right) {
        int res = 0;
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            ++res;
            --left;
            ++right;
        }
        return res;
    }
}
