package cn.sichu.graduate_practice.hackerrank;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-mini-max-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-one&h_r=next-challenge&h_v=zen
 * 
 * @author sichu
 * @date 2022/04/28
 */
public class MiniMaxSum {
    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        int[] nums = new int[5];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        long sum = 0;

        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            sum += nums[i];
        }
        System.out.println((sum - max) + " " + (sum - min));
    }
}
