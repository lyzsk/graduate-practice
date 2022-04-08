package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/gas-station/
 * 
 * @author sichu
 * @date 2022/04/07
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        while (i < gas.length) {
            int gasSum = 0;
            int costSum = 0;
            int count = 0;

            while (count < gas.length) {
                int j = (i + count) % gas.length;
                gasSum += gas[j];
                costSum += cost[j];
                if (costSum > gasSum) {
                    break;
                }
                ++count;
            }

            if (count == gas.length) {
                return i;
            } else {
                i = i + count + 1;
            }
        }
        return -1;
    }
}
