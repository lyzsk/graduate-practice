package cn.sichu.graduate_practice.easy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * 
 * @author sichu
 * @date 2022/04/09
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                if (index == 0 || nums1[index1] != intersection[index - 1]) {
                    intersection[index] = nums1[index1];
                    ++index;
                }
                ++index1;
                ++index2;
            } else if (nums1[index1] < nums2[index2]) {
                ++index1;
            } else {
                ++index2;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
