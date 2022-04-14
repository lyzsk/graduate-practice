package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/splitting-a-string-into-descending-consecutive-values/
 * 
 * @author sichu
 * @date 2022/04/11
 */
public class SplittingAStringIntoDescendingConsecutiveValues {
    public boolean splitString(String s) {
        char[] arr = s.toCharArray();
        long pre = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            pre = pre * 10 + arr[i] - '0';
            if (dfs(arr, i + 1, pre)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(char[] arr, int index, long pre) {
        if (index == arr.length) {
            return true;
        }
        long cur = 0;
        for (int i = index; i < arr.length; i++) {
            cur = cur * 10 + arr[i] - '0';
            if (pre - cur == 1) {
                if (dfs(arr, i + 1, cur)) {
                    return true;
                }
            } else if (cur >= pre) {
                break;
            }
        }
        return false;
    }
}
