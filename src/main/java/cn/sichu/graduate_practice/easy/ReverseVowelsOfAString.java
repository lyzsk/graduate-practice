package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * 
 * @author sichu
 * @date 2022/04/05
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (!isVowel(arr[left])) {
                ++left;
            } else if (!isVowel(arr[right])) {
                --right;
            } else {
                reverse(arr, left, right);
                ++left;
                --right;
            }
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {

        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;

    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'
            || ch == 'u' || ch == 'U';
    }
}
