package cn.sichu.graduate_practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href = "https://leetcode-cn.com/problems/3sum/">15. 三数之和</a>
 * @see <a href = "https://leetcode.com/problems/3sum/">15. 3Sum</a>
 * @author sichu
 * @date 2022/03/16
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return res;
        } else {
            /**
             * 排序 O(nlogn)
             */
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                /**
                 * 第一个数大于0，后面的都比他大，不可能相加=0
                 */
                if (nums[i] > 0) {
                    break;
                }
                /**
                 * 去重复
                 */
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                /**
                 * 双指针 twoSum问题
                 */
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == -nums[i]) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        ++left;
                        --right;
                        while (left < right && nums[left] == nums[left - 1]) {
                            ++left;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            --right;
                        }
                    } else if (nums[left] + nums[right] > -nums[i]) {
                        --right;
                    } else if (nums[left] + nums[right] < -nums[i]) {
                        ++left;
                    }
                }
            }
            return res;
        }

    }
}
