package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/reverse-prefix-of-word/
 * 
 * @author sichu
 * @date 2022/04/06
 */
public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);

        if (index > 0) {
            char[] arr = word.toCharArray();
            int left = 0;
            int right = index;

            while (left < right) {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                ++left;
                --right;
            }
            return new String(arr);
        }

        return word;
    }
}
