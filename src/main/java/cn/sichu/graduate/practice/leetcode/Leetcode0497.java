package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author sichu
 * @date 2022/06/08
 */
public class Leetcode0497 {
    private Random random;
    private List<Integer> arr;
    private int[][] rects;

    public Leetcode0497(int[][] rects) {
        this.random = new Random();
        this.arr = new ArrayList<Integer>();
        arr.add(0);
        this.rects = rects;
        for (int[] rect : rects) {
            int a = rect[0];
            int b = rect[1];
            int x = rect[2];
            int y = rect[3];
            arr.add(arr.get(arr.size() - 1) + (x - a + 1) * (y - b + 1));
        }
    }

    public int[] pick() {
        int k = random.nextInt(arr.get(arr.size() - 1));
        int rectIndex = binarySearch(arr, k + 1) - 1;
        k -= arr.get(rectIndex);
        int[] rect = rects[rectIndex];
        int a = rect[0];
        int b = rect[1];
        int y = rect[3];
        int col = y - b + 1;
        int da = k / col;
        int db = k - col * da;
        return new int[] {a + da, b + db};
    }

    private static int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
