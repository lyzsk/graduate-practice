package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode-cn.com/problems/remove-element/">27. 移除元素</a>
 * @see <a href = "https://leetcode.com/problems/remove-element/">27. Remove Element</a>
 * @author sichu
 * @date 2022/03/17
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == val) {
                ++fast;
            } else {
                nums[slow] = nums[fast];
                ++fast;
                ++slow;
            }
        }
        return slow;
    }
}
