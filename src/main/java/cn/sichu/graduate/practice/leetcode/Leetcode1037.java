package cn.sichu.graduate.practice.leetcode;

/**
 * 数学问题： 三点不在一条直线 -> 两个向量的叉乘结果不会为0
 * <p>
 * k1 = y2 - y1 / x2 - x1;
 * <p>
 * k2 = y3 - y1 / x3 - x1
 * <p>
 * -> y2 - y1 * x3 - x1 != y3 - y1 * x2 - x1
 * 
 * @author sichu
 * @date 2022/06/07
 */
public class Leetcode1037 {
    public boolean isBoomerang(int[][] points) {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1])
            * (points[1][0] - points[0][0]);
    }
}
