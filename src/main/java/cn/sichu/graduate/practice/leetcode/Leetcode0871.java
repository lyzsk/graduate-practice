package cn.sichu.graduate.practice.leetcode;

import java.util.PriorityQueue;

/**
 * 贪心： 加一次，尽可能多加
 * <p>
 * 哪些加油站可以加油，取决于 当前油量能跑多远
 * <p>
 * 哪个加油站油最多，优先队列 大根堆
 * 
 * @author sichu
 * @date 2022/07/02
 */
public class Leetcode0871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int need = target - startFuel;
        int res = 0;
        int p = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        while (p < stations.length || !queue.isEmpty()) {
            if (need <= 0) {
                return res;
            }
            while (p < stations.length && stations[p][0] <= startFuel) {
                queue.add(stations[p][1]);
                ++p;
            }
            if (p < stations.length && stations[p][0] > startFuel && queue.isEmpty()) {
                return -1;
            }
            if (!queue.isEmpty()) {
                int add = queue.poll();
                startFuel += add;
                need -= add;
                res += 1;
            }
        }
        return need <= 0 ? res : -1;
    }
}
