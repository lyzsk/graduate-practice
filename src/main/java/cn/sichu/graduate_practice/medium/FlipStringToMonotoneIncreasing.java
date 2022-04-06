package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/
 * 
 * @author sichu
 * @date 2022/04/06
 */
public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int dp = 0;
        int countOne = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                ++countOne;
            } else {
                dp = Math.min(dp + 1, countOne);
            }
        }
        return dp;
    }
}
