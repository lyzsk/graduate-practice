package cn.sichu.graduate.practice.leetcode;

/**
 * @author sichu
 * @date 2022/07/08
 */
public class Leetcode1217 {
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int pos : position) {
            if ((pos & 1) == 1) {
                ++odd;
            } else {
                ++even;
            }
        }
        return Math.min(odd, even);
    }
}
