package cn.sichu.graduate.practice.leetcode;

/**
 * 数组中有一个重复的整数 <==> 链表中存在环
 * <p>
 * 找到数组中的重复整数 <==> 找到链表的环入口
 * <p>
 * slow = slow.next ==> 本题 slow = nums[slow]
 * <p>
 * fast = fast.next.next ==> 本题 fast = nums[nums[fast]]
 * 
 * @author sichu
 * @date 2022/06/01
 */
public class Leetcode0287 {
    // public int findDuplicate(int[] nums) {
    // for (int i = 0; i < nums.length; i++) {
    // while (nums[nums[i] - 1] != nums[i]) {
    // swap(nums, nums[i] - 1, i);
    // }
    // }
    // for (int i = 0; i < nums.length; i++) {
    // if (nums[i] != i + 1) {
    // return nums[i];
    // }
    // }
    // return -1;
    // }
    //
    // private static void swap(int[] nums, int left, int right) {
    // int tmp = nums[left];
    // nums[left] = nums[right];
    // nums[right] = tmp;
    // }
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int p1 = 0;
        int p2 = slow;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }
}
