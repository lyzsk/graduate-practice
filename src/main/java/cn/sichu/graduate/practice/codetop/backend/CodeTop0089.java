package cn.sichu.graduate.practice.codetop.backend;

/**
 * Boyer-Moore 投票算法
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0089 {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count = 1;
            } else if (nums[i] == res) {
                ++count;
            } else {
                --count;
            }
        }
        return res;
    }
}
