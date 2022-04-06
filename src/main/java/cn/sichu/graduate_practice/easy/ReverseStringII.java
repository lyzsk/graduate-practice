package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * 
 * @author sichu
 * @date 2022/04/05
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2 * k) {
            int left = i;
            int right = Math.min(i + k, s.length()) - 1;
            reverse(arr, left, right);
        }

        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            ++left;
            --right;
        }
    }
}
