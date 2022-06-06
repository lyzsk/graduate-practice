package cn.sichu.graduate.practice.leetcode;

import java.util.Arrays;

/**
 * maxNumberK(int[] nums, int k) : 同理 Leetcode0402, 单调栈求 nums 中长度为 k 的最大数<br>
 * -> 移除 nums 中 n - k 个元素 使其最大， 其中 nums != null && 0 <= k <= nums.length
 * <p>
 * 这道题因为输出的是int[] 数组，单调栈使用数组实现，数组最左侧为栈底。使用数组实现，可以直接从左到右遍历数组得到最大子序列。
 * <p>
 * 逻辑是：
 * <p>
 * 1. 如果栈非空 && 当前元素比栈顶元素大， 移除栈顶元素 -> while(k > 0 && top > 0 && nums[i] > stack[top-1])
 * <p>
 * 2. 出for循环后，如果 k还>0， 再移除 k 个栈顶元素 -> top -= k
 * <p>
 * maxNumberK(int[] nums, int k) : 合并两个数组成为最大值， 其中 nums1 != null && nums2 != null
 * <p>
 * compare(int[] nums1, int i, int[] nums2, int j) : 比较 nums1 [i, m) 和 nums2 [j, n), 其中 nums1 != null && nums2 != null
 * <p>
 * 类似的题： Leetcode0316, Leetcode0321, Leetcode0402, Leetcode1081
 * 
 * @author sichu
 * @date 2022/06/05
 */
public class Leetcode0321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0) {
            return maxNumberK(nums2, k);
        }
        if (nums2 == null || nums2.length == 0) {
            return maxNumberK(nums1, k);
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] res = null;
        for (int i = Math.max(0, k - n), limit = Math.min(m, k); i <= limit; i++) {
            int[] subSequence1 = maxNumberK(nums1, i);
            int[] subSequence2 = maxNumberK(nums2, k - i);
            int[] merged = merge(subSequence1, subSequence2);
            res = res == null || compare(res, 0, merged, 0) < 0 ? merged : res;
        }
        return res;
    }

    private static int[] maxNumberK(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        if (k == 0) {
            return nums.clone();
        }
        if (k == n) {
            return new int[0];
        }
        int[] stack = new int[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            while (k > 0 && top > 0 && nums[i] > stack[top - 1]) {
                --top;
                --k;
            }
            stack[top] = nums[i];
            ++top;
        }
        top -= k;
        return Arrays.copyOfRange(stack, 0, top);
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (compare(nums1, i, nums2, j) >= 0) {
                res[k] = nums1[i];
                ++k;
                ++i;
            } else {
                res[k] = nums2[j];
                ++k;
                ++j;
            }
        }
        while (i < m) {
            res[k] = nums1[i];
            ++k;
            ++i;
        }
        while (j < n) {
            res[k] = nums2[j];
            ++k;
            ++j;
        }
        return res;
    }

    private static int compare(int[] nums1, int i, int[] nums2, int j) {
        int m = nums1.length;
        int n = nums2.length;
        for (int k = 0, limit = Math.min(m - i, n - j); k < limit; k++) {
            if (nums1[i + k] != nums2[j + k]) {
                return Integer.compare(nums1[i + k], nums2[j + k]);
            }
        }
        return Integer.compare(m - i, n - j);
    }
}
