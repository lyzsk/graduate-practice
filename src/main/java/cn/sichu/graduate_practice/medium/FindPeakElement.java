package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 * 
 * @author sichu
 * @date 2022/04/07
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
