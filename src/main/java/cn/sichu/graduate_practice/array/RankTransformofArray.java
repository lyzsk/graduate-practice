package cn.sichu.graduate_practice.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href = "https://leetcode.com/problems/rank-transform-of-an-array/">1331. Rank Transform of an Array</a>
 * @author sichu
 * @date 2022/03/19
 */
public class RankTransformofArray {
    /**
     * Time: O(nlogn)
     * <p>
     * Space: O(n)
     * 
     * @param arr
     * @return
     */
    public int[] arrayRankTransform(int[] arr) {
        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);
        HashMap<Integer, Integer> rankmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < tmp.length; i++) {
            rankmap.putIfAbsent(tmp[i], rankmap.size() + 1);
        }
        for (int j = 0; j < arr.length; j++) {
            tmp[j] = rankmap.get(arr[j]);
        }
        return tmp;
    }
}
