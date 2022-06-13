package cn.sichu.graduate.practice.leetcode;

/**
 * @author sichu
 * @date 2022/06/12
 */
public class Leetcode1051 {
    // public int heightChecker(int[] heights) {
    // int[] expected = heights.clone();
    // Arrays.sort(expected);
    // int res = 0;
    // for (int i = 0; i < heights.length; i++) {
    // if (heights[i] != expected[i]) {
    // ++res;
    // }
    // }
    // return res;
    // }
    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int i = 0; i < heights.length; i++) {
            ++arr[heights[i]];
        }
        int count = 0;
        for (int i = 0, j = 1; i < heights.length; i++) {
            while (arr[j] == 0) {
                ++j;
            }
            if (j != heights[i]) {
                ++count;
            }
            --arr[j];
        }
        return count;
    }
}
