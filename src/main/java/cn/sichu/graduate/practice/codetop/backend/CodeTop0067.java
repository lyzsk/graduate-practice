package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0067 {
    /**
     * 因为起点是负无穷，开始一定是上坡，目标是寻找序列中第一个下降点，如果 nums[mid] < nums[mid + 1]，说明仍然不满足，不必包含 mid ，继续向右找，即 left = mid + 1;
     * <p>
     * 如果 nums[mid] > nums[mid + 1]，说明此时这个 mid 位置满足了，但不一定是第一个满足的，所以要把 mid 包含在内，向左找，即 right = mid；
     * <p>
     * 退出条件是 left == right，也就是框出了唯一的一个位置，此时退出，返回 left 即可。
     * 
     * @param nums
     * @return left
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
