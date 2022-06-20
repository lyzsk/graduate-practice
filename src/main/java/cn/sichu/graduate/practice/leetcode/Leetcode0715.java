package cn.sichu.graduate.practice.leetcode;

/**
 * @author sichu
 * @date 2022/06/20
 */
public class Leetcode0715 {
    class Node {
        private Node left;
        private Node right;
        private boolean cover;
        private int add;
    }

    private int N = (int)1e9;
    private Node root = new Node();

    private void update(Node node, int start, int end, int left, int right, int val) {
        if (left <= start && end <= right) {
            node.cover = val == 1;
            node.add = val;
            return;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (left <= mid) {
            update(node.left, start, mid, left, right, val);
        }
        if (right > mid) {
            update(node.right, mid + 1, end, left, right, val);
        }
        pushUp(node);
    }

    private boolean query(Node node, int start, int end, int left, int right) {
        if (left <= start && end <= right) {
            return node.cover;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        boolean res = true;
        if (left <= mid) {
            res = res && query(node.left, start, mid, left, right);
        }
        if (right > mid) {
            res = res && query(node.right, mid + 1, end, left, right);
        }
        return res;
    }

    private void pushUp(Node node) {
        node.cover = node.left.cover && node.right.cover;
    }

    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.add == 0) {
            return;
        }
        node.left.cover = node.add == 1;
        node.right.cover = node.add == 1;
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }

    public Leetcode0715() {

    }

    public void addRange(int left, int right) {
        update(root, 1, N, left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        return query(root, 1, N, left, right - 1);
    }

    public void removeRange(int left, int right) {
        update(root, 1, N, left, right - 1, -1);
    }
}
