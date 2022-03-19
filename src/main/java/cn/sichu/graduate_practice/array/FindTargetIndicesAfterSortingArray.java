package cn.sichu.graduate_practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    /**
     * O(nlogn)
     * 
     * @param nums
     * @param target
     * @return
     */
    public List<Integer> targetIndicesSolution1(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 不需要sort,O(n)
     * 
     * @param nums
     * @param target
     * @return
     */
    public List<Integer> targetIndicesSolution2(int[] nums, int target) {
        int count = 0;
        int lessthan = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ++count;
            }
            if (nums[i] < target) {
                ++lessthan;
            }
        }

        List<Integer> res = new ArrayList<Integer>(count);
        for (int j = 0; j < count; j++) {
            res.add(lessthan++);
        }
        return res;

    }
}
