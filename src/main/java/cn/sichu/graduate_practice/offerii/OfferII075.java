package cn.sichu.graduate_practice.offerii;

/**
 * https://leetcode.cn/problems/0H97ZC/
 * 
 * @author sichu
 * @date 2022/05/18
 */
public class OfferII075 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int i : arr1) {
            max = Math.max(max, i);
        }
        int[] count = new int[max + 1];
        for (int i : arr1) {
            ++count[i];
        }

        int[] res = new int[arr1.length];
        int idx = 0;
        for (int i : arr2) {
            while (count[i] > 0) {
                res[idx] = i;
                --count[i];
                ++idx;
            }
        }
        for (int i = 0; i < max + 1; i++) {
            while (count[i] > 0) {
                res[idx] = i;
                --count[i];
                ++idx;
            }
        }
        return res;
    }
}
