package cn.sichu.graduate_practice.hackerrank;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-diagonal-difference/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-two
 * 
 * @author sichu
 * @date 2022/05/09
 */
public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int leftToRightSum = 0;
        int rightToLeftSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            leftToRightSum += arr.get(i).get(i);
            rightToLeftSum += arr.get(i).get(arr.size() - 1 - i);
        }
        return Math.abs(leftToRightSum - rightToLeftSum);
    }
}
