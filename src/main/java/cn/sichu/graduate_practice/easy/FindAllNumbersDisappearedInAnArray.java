package cn.sichu.graduate_practice.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 * 
 * @author sichu
 * @date 2022/05/10
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = (nums[i] - 1) % nums.length;
            nums[x] += nums.length;
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
