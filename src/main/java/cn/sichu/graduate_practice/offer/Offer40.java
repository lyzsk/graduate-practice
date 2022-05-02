package cn.sichu.graduate_practice.offer;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * <p>
 * 第k个最大: {@link cn.sichu.graduate_practice.medium.KthLargestElementInAnArray}
 * 
 * @author sichu
 * @date 2022/05/02
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 用 quicksort 思想, 最好情况O(n)，最坏O(n<sup>2</sup>)
     * 
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbersSolution2(int[] arr, int k) {
        quickSelect(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static void quickSelect(int[] arr, int left, int right, int index) {
        // 因为题目限制条件: 0 <= k <= arr.length <= 10000
        // 如果 k = 0, 那么如果 pos - 1 - left + 1 = pos - left = 0, Random().nextInt(0) 会 throw e
        if (left >= right) {
            return;
        }
        int pos = randomPartition(arr, left, right);
        if (pos == index) {
            return;
        } else if (pos < index) {
            quickSelect(arr, pos + 1, right, index);
        } else {
            quickSelect(arr, left, pos - 1, index);
        }
    }

    private static int randomPartition(int[] arr, int left, int right) {
        int i = new Random().nextInt(right - left + 1) + left;
        swap(arr, i, right);
        return partition(arr, left, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                ++i;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
