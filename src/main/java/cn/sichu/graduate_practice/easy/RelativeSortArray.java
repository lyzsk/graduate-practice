package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode.cn/problems/relative-sort-array/
 * 
 * @author sichu
 * @date 2022/05/18
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int i : arr1) {
            max = Math.max(max, i);
        }
        int[] count = new int[max + 1];
        // 计数
        for (int i : arr1) {
            ++count[i];
        }

        int[] res = new int[arr1.length];
        int idx = 0;
        // arr2 排序
        for (int i : arr2) {
            while (count[i] > 0) {
                res[idx] = i;
                --count[i];
                ++idx;
            }
        }
        // 对于 arr2 没有的元素，自然排序
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
