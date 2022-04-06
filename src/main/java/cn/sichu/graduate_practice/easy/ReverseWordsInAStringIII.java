package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 
 * @author sichu
 * @date 2022/04/06
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int left = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr, left, i - 1);
                left = i + 1;
            }
            if (i == arr.length - 1) {
                reverse(arr, left, i);
            }
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
