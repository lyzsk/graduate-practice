package cn.sichu.graduate.practice.codetop.backend;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0063 {
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
