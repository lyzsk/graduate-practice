package cn.sichu.graduate.practice.leetcode;

import java.util.Arrays;

/**
 * 关键1： 是从后往前回溯，因为排序是升序的，从最长的火柴开始尝试加入
 * <p>
 * 关键2： (i > 0 && edges[i] == edges[i - 1]) 剪枝判断，前一个节点和后一个节点的起始值相同时，不再往下回溯
 * 
 * @author sichu
 * @date 2022/06/01
 */
public class Leetcode0473 {
    public boolean makesquare(int[] matchsticks) {
        int totalLength = Arrays.stream(matchsticks).sum();
        if (totalLength % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        int[] edges = new int[4];
        return backtrack(matchsticks, totalLength / 4, edges, matchsticks.length - 1);
    }

    private static boolean backtrack(int[] matchsticks, int edgeLegnth, int[] edges, int startIndex) {
        if (startIndex == -1) {
            return edges[0] == edges[1] && edges[1] == edges[2] && edges[2] == edges[3];
        }
        for (int i = 0; i < edges.length; i++) {
            if (matchsticks[startIndex] + edges[i] > edgeLegnth || (i > 0 && edges[i] == edges[i - 1])) {
                continue;
            }
            edges[i] += matchsticks[startIndex];
            if (backtrack(matchsticks, edgeLegnth, edges, startIndex - 1)) {
                return true;
            }
            edges[i] -= matchsticks[startIndex];
        }
        return false;
    }
}
