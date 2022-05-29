package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Offer17 {
    private int[] res;
    private int count = 0;

    public int[] printNumbers(int n) {
        res = new int[(int)Math.pow(10, n) - 1];
        for (int digit = 1; digit <= n; digit++) {
            for (char first = '1'; first <= '9'; first++) {
                char[] num = new char[digit];
                num[0] = first;
                dfs(num, digit, 1);
            }
        }
        return res;
    }

    private void dfs(char[] num, int digit, int startIndex) {
        if (startIndex == digit) {
            res[count] = Integer.parseInt(String.valueOf(num));
            ++count;
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[startIndex] = i;
            dfs(num, digit, startIndex + 1);
        }
    }
}
