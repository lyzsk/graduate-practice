package cn.sichu.graduate_practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * <p>
 * Offer link: {@link cn.sichu.graduate_practice.offerii.OfferII060}
 * 
 * @author sichu
 * @date 2022/05/02
 */
public class TopKFrequentElements {

    /**
     * O(n<sup>2</sup>)
     * <p>
     * O(n)哈希表的大小为 O(N)，用于排序的数组的大小也为 O(N)，
     * <p>
     * 快速排序的空间复杂度最好情况为 O(logN)，最坏情况为 O(N)
     * <p>
     * 快速选择的好处是输出的是有序的，但是题目没要求有序
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequentSolution1(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();
        // Entry将键值对的对应关系封装成了对象，即键值对对象，这样我们在遍历Map集合时，就可以从每一个键值对（Entry）对象中获取对应的键与对应的值。
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[] {num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    private static void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int)(Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        // 当pivot包含的多余k个时，虽然此时左边都比pivot的大，左区间仍是乱序的，对于k而言相当于没排序
        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            // 当pivot包含元素小于k时，起码pivot左边的都大于pivot，因此pivot左边的也大于k，这些数字可以放入结果中
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            // 当pivot和起点间的个数小于k时，则从pivot到end再继续找剩下的前（k - （pivot - start + 1））大的元素
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }

    /**
     * 13ms 比官方慢1ms 但是好理解
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequentSolution2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return occurrences.get(o1) - occurrences.get(o2);
            }
        });

        for (Integer key : occurrences.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    /**
     * 16ms， 用stream
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequentSolution3(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] res = freq.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(k)
            .mapToInt(Map.Entry::getKey).toArray();
        return res;
    }

    /**
     * stream, 但是不用for-each, 改用Arrays.stream， 10ms 最快
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequentSolution4(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        Arrays.stream(nums).forEach(num -> freq.put(num, freq.getOrDefault(num, 0) + 1));
        int[] res = freq.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(k)
            .mapToInt(Map.Entry::getKey).toArray();
        return res;
    }
}
