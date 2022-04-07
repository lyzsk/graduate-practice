package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 
 * @author sichu
 * @date 2022/04/07
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int left = 0;
        int right = 0;

        while (left < sb.length()) {
            while (right < sb.length() && sb.charAt(right) != ' ') {
                ++right;
            }
            reverseString(sb, left, right - 1);
            left = right + 1;
            ++right;
        }
    }

    private void reverseString(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, tmp);
            ++left;
            --right;
        }
    }

    private StringBuilder removeSpace(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') {
                sb.append(ch);
            } else if (ch == ' ' && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(ch);
            }
            ++left;
        }
        return sb;
    }
}
