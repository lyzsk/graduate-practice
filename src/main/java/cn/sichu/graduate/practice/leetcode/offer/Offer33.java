package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/06/09
 */
public class Offer33 {
    // public boolean verifyPostorder(int[] postorder) {
    // Deque<Integer> stack = new ArrayDeque<Integer>();
    // int root = Integer.MAX_VALUE;
    // for (int i = postorder.length - 1; i >= 0; i--) {
    // if (postorder[i] > root) {
    // return false;
    // }
    // while (!stack.isEmpty() && stack.peekFirst() > postorder[i]) {
    // root = stack.removeFirst();
    // }
    // stack.addFirst(postorder[i]);
    // }
    // return true;
    // }

    /**
     * 虽然是 O(n^2), 但是比上面 O(n) 的还快:)
     * 
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private static boolean recur(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int root = postorder[right];
        int idx = left;
        while (postorder[idx] < root) {
            ++idx;
        }
        int mid = idx;
        while (idx < right) {
            if (postorder[idx] < root) {
                return false;
            }
            ++idx;
        }
        return recur(postorder, left, mid - 1) && recur(postorder, mid, right - 1);
    }
}
