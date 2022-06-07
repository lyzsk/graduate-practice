package cn.sichu.graduate.practice.leetcode;

/**
 * 本质是二分查找，left = 1, 最小速度1， right = 香蕉堆的最大值(因为是一小时吃完)，
 * <p>
 * 题意里 香蕉个数 / 速度 是向上取整的，不能整除时要作 向上取整操作：
 * <ul>
 * <li>{@code if (piles[i] % mid != 0) { costTime += piles[i] / mid + 1; } else { costTime += piles[i] / mid; }}
 * <p>
 * 等价于：
 * <p>
 * costTime += (piles[i] - 1) / mid + 1;</li>
 * <li>前者12ms, 后者7ms</li>
 * </ul>
 * 
 * @author sichu
 * @date 2022/06/06
 */
public class Leetcode0875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            int costTime = 0;
            for (int i = 0; i < piles.length; i++) {
                costTime += (piles[i] - 1) / mid + 1;
            }
            if (costTime > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
