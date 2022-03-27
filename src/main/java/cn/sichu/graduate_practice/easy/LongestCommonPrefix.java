package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 
 * @author sichu
 * @date 2022/03/27
 */
public class LongestCommonPrefix {
    /**
     * O(mn)
     * <p>
     * O(1)
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < minLen && str1.charAt(index) == str2.charAt(index)) {
            ++index;
        }
        return str1.substring(0, index);
    }
}
