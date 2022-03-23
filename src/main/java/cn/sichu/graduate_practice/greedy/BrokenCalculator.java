package cn.sichu.graduate_practice.greedy;

/**
 * @see<a href = "https://leetcode-cn.com/problems/broken-calculator/">991. 坏了的计算器</a>
 * @see<a href = "https://leetcode.com/problems/broken-calculator/">991. Broken Calculator</a>
 * @author sichu
 * @date 2022/03/23
 */
public class BrokenCalculator {
    /**
     * y = x, return 0;
     * <p>
     * y < x, return x - y;
     * <p>
     * y > x,
     * <ul>
     * <li>y 奇数, 递归求y + 1的次数，再+1;
     * <li>y 偶数, 递归求 y/2 的次数，再+1;
     * </ul>
     * Time: O(logn)
     * <p>
     * Space: O(1)
     * 
     * @param startValue
     * @param target
     * @return
     */
    public int brokenCalc(int startValue, int target) {
        if (target <= startValue) {
            return startValue - target;
        } else {
            if (target % 2 == 0) {
                return 1 + brokenCalc(startValue, target / 2);
            } else {
                return 1 + brokenCalc(startValue, target + 1);
            }
        }
    }
}
