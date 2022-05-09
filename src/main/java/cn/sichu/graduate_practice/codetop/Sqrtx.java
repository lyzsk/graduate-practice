package cn.sichu.graduate_practice.codetop;

/**
 * 频率40
 * <p>
 * https://leetcode.cn/problems/sqrtx/
 * 
 * @author sichu
 * @date 2022/05/09
 */
public class Sqrtx {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = -1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
