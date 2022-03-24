package cn.sichu.graduate_practice.greedy;

/**
 * @see <a href = "https://leetcode-cn.com/problems/jump-game-ii/">45. 跳跃游戏 II</a>
 * @author sichu
 * @date 2022/03/24
 */
public class JumpGameII {
    /**
     * greedy 不好理解
     * 
     * @param nums
     * @return
     */
    public int jumpSolution1(int[] nums) {

        int steps = 0;
        int maxReach = 0;
        int bound = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            bound = Math.max(bound, i + nums[i]);
            if (i == maxReach) {
                maxReach = bound;
                steps++;

            }
        }

        return steps;
    }

}
