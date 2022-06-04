package cn.sichu.graduate.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目是 未排序的， 排序的话就会花费logn，不符合O(n)的要求，尝试用 set 来去重，遍历搜索O(n)
 * 
 * @author sichu
 * @date 2022/06/04
 */
public class Leetcode0128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curLength += 1;
                }
                res = Math.max(res, curLength);
            }
        }
        return res;
    }
}
