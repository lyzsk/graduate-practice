package cn.sichu.graduate_practice.hackerrank;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-one
 * 
 * @author sichu
 * @date 2022/04/28
 */
public class PlusMinus {
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

        double positiveCount = 0;
        double negativeCount = 0;
        double zeroCount = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                ++positiveCount;
            } else if (arr.get(i) < 0) {
                ++negativeCount;
            } else {
                ++zeroCount;
            }
        }

        System.out.println(positiveCount / arr.size());
        System.out.println(negativeCount / arr.size());
        System.out.println(zeroCount / arr.size());
    }
}
