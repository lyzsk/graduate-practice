package cn.sichu.graduate.practice.leetcode;

/**
 * @author sichu
 * @date 2022/06/17
 */
public class Leetcode1089 {
    public void duplicateZeros(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0, j = 0; j < arr.length; i++, j++) {
            if (arr[i] == 0) {
                ++j;
            } else {
                res[j] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
    }
}
