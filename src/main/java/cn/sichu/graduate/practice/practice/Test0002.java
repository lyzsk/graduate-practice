package cn.sichu.graduate.practice.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode0300 变种，输出最长递增子序列
 * 
 * @author sichu
 * @date 2022/06/06
 */
public class Test0002 {
    public List<Integer> lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > res.get(res.size() - 1)) {
                res.add(num);
            } else {
                int j = 0;
                while (num > res.get(j)) {
                    ++j;
                }
                res.set(j, num);
            }
        }
        return res;
    }

    public List<Integer> lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        List<List<Integer>> paths = new ArrayList<>();
        int max = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            List<Integer> temp1 = new ArrayList<>();
            temp1.add(nums[i]);
            paths.add(temp1);
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // dp[i] = Math.max(dp[i],dp[j]+1);
                    if (dp[i] < dp[j] + 1) {
                        List<Integer> temp = new ArrayList<>(paths.get(j));
                        temp.add(nums[i]);
                        paths.remove(i);
                        paths.add(temp);
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                index = i;
            }
        }
        if (index == -1)
            return null;
        return paths.get(index);
    }

    public static void main(String[] args) {
        Test0002 test = new Test0002();
        int[] nums1 = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = new int[] {0, 1, 0, 3, 2, 3};
        int[] nums3 = new int[] {7, 7, 7, 7, 7, 7, 7};
        System.out.println(test.lengthOfLIS(nums1));
        System.out.println(test.lengthOfLIS2(nums1) + "\n");
        System.out.println(test.lengthOfLIS(nums2));
        System.out.println(test.lengthOfLIS2(nums2) + "\n");
        System.out.println(test.lengthOfLIS(nums3));
        System.out.println(test.lengthOfLIS2(nums3) + "\n");
    }
}
