package cn.sichu.graduate_practice.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-countingsort1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-two&h_r=next-challenge&h_v=zen
 * 
 * @author sichu
 * @date 2022/05/09
 */
public class CountingSortI {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>(Collections.nCopies(100, 0));
        for (int i = 0; i < arr.size(); i++) {
            res.set(arr.get(i), res.get(arr.get(i)) + 1);
        }
        return res;
    }
}
