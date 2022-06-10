package cn.sichu.graduate.practice.leetcode.tencent50;

/**
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Tencent50 {
    // public String reverseWords(String s) {
    // StringBuilder sb = new StringBuilder(s);
    // reverseEachWord(sb);
    // return sb.toString();
    // }
    //
    // private static void reverseEachWord(StringBuilder sb) {
    // int left = 0;
    // int right = 0;
    // while (left < sb.length()) {
    // while (right < sb.length() && sb.charAt(right) != ' ') {
    // ++right;
    // }
    // reverseString(sb, left, right - 1);
    // left = right + 1;
    // ++right;
    // }
    // }
    //
    // private static void reverseString(StringBuilder sb, int left, int right) {
    // while (left < right) {
    // char tmp = sb.charAt(left);
    // sb.setCharAt(left, sb.charAt(right));
    // sb.setCharAt(right, tmp);
    // ++left;
    // --right;
    // }
    // }
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        for (int i = 0; i < strs.length; i++) {
            strs[i] = new StringBuilder(strs[i]).reverse().toString();
        }
        return String.join(" ", strs);
    }
}
