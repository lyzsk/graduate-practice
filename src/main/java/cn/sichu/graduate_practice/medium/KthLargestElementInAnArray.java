package cn.sichu.graduate_practice.medium;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * <p>
 * 最小k个: {@link cn.sichu.graduate_practice.offer.Offer40}
 * 
 * @author sichu
 * @date 2022/05/02
 */
public class KthLargestElementInAnArray {
    /**
     * 基于quicksort,平均O(nlogn)，通过加入随机化实际可以更快到O(n)
     * <p>
     * 空间复杂度O(logn)
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestSolution1(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int index) {
        if (left >= right) {
            return nums[index];
        }
        int pos = randomPartition(nums, left, right);
        if (pos == index) {
            return nums[pos];
        } else {
            return pos < index ? quickSelect(nums, pos + 1, right, index) : quickSelect(nums, left, pos - 1, index);
        }
    }

    private static int randomPartition(int[] nums, int left, int right) {
        // 1. 随机数范围: [0, right-left+1) + left -> [left, right+1) = [left, right]
        int i = new Random().nextInt(right - left + 1) + left;
        // 2. 交换 nums[i], nums[right], 也就是将随机数先放在 [left, right] 最右边
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    private static int partition(int[] nums, int left, int right) {
        // 3. 在调用当前方法的 randomPartition 方法中， 已经确定了随机数是 nums[right]
        int pivot = nums[right];
        int i = left;

        // 首先比较区间在 [left, right) 之间，所以 nums[j] 中的 left <= j < right
        for (int j = left; j < right; j++) {
            // 4. nums[j] 跟随机数 pivot 比较， 小于 pivot 的数跟 [left, right] 左边区间交换
            if (nums[j] < pivot) {
                swap(nums, i, j);
                ++i;
            }
        }
        // 5. 此时已经将 < pivot 的值都放在一边了， 将 pivot 也就是 nums[right] 跟 nums[i] 交换，
        // 从而分成两个区间 左边: [left, i-1]; 右边: [i+1, right]， 左边区间的值都小于 pivot
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 堆排序思想
     * <p>
     * O(nlogn)
     * <p>
     * O(logn)
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestSolution2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private static void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize >> 1; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private static void maxHeapify(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    /**
     * 垃圾，比sort还慢
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestSolution3(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        // 第k大元素下标是nums.length - k
        int target = nums.length - k;

        while (true) {
            int index = partition2(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private static int partition2(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // j 初始值为left, 先右移，再交换，小于 pivot 的元素都被交换到前面
                ++j;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中, 满足 nums[left + 1..j] < pivot, 并且 nums(j..i) >= pivot
        swap(nums, j, left);
        // 交换以后 nums[left..j - 1] < pivot, nums[j] = pivot, nums[j + 1..right] >= pivot
        return j;
    }
}
