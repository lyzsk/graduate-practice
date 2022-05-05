package cn.sichu.graduate_practice.hackerrank;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-lonely-integer/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-two
 * 
 * @author sichu
 * @date 2022/05/05
 */
public class LonelyInteger {
    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        int res = 0;
        for (int i = 0; i < a.size(); i++) {
            res ^= a.get(i);
        }
        return res;
    }

}
