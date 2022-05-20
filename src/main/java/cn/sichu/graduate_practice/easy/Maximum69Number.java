package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode.cn/problems/maximum-69-number/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        int res = num;
        int digit = 1;
        int modifyDigit = 0;
        while (num != 0) {
            if (num % 10 == 6) {
                modifyDigit = digit;
            }
            digit *= 10;
            num /= 10;
        }
        res += modifyDigit * 3;
        return res;
    }

    public int maximum69NumberSolution2(int num) {
        StringBuilder sb = new StringBuilder(Integer.toString(num));
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '6') {
                sb.deleteCharAt(i);
                sb.insert(i, '9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
