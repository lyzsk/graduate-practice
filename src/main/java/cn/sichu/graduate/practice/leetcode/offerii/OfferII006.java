package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * 
 * @author sichu
 * @date 2022/05/22
 */
public class OfferII006 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left, right};
            } else if (sum < target) {
                ++left;
            } else {
                --right;
            }
        }
        return new int[] {};
    }
}
