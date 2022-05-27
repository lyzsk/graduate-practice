package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sichu
 * @date 2022/05/27
 */
public class Leetcode0228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (right == nums.length - 1 || nums[right] + 1 != nums[right + 1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[left]);
                if (left != right) {
                    sb.append("->").append(nums[right]);
                }
                res.add(sb.toString());
                left = right + 1;
            }
        }
        return res;
    }
}
