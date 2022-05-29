package cn.sichu.graduate.practice.leetcode.offer;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSelect(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private static void quickSelect(int[] arr, int left, int right, int index) {
        if (left >= right) {
            return;
        }
        int pos = randomPartition(arr, left, right);
        if (pos == index) {
            return;
        }
        if (pos < index) {
            quickSelect(arr, pos + 1, right, index);
        }
        if (pos > index) {
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
