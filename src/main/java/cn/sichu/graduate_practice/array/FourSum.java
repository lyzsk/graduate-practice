package cn.sichu.graduate_practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href = "https://leetcode-cn.com/problems/4sum/">18. 四数之和</a>
 * @see <a href = "https://leetcode.com/problems/4sum/">18. 4Sum</a>
 * @author sichu
 * @date 2022/03/17
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 4) {
            return res;
        } else {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        if (nums[left] + nums[right] == target - nums[i] - nums[j]) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            ++left;
                            --right;
                            while (left < right && nums[left] == nums[left - 1]) {
                                ++left;
                            }
                            while (left < right && nums[right] == nums[right + 1]) {
                                --right;
                            }
                        } else if (nums[left] + nums[right] < target - nums[i] - nums[j]) {
                            ++left;
                        } else {
                            --right;
                        }
                    }
                }
            }
            return res;
        }
    }
}
