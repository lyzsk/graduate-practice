package cn.sichu.graduate.practice.leetcode;

/**
 * @author sichu
 * @date 2022/07/19
 */
public class Leetcode0731 {
    public Leetcode0731() {

    }

    public boolean book(int start, int end) {
        if (query(root, 0, N, start, end - 1) == 2) {
            return false;
        }
        update(root, 0, N, start, end - 1, 1);
        return true;
    }

    class Node {
        // 左右孩子节点
        private Node left, right;
        // 当前节点值，以及懒惰标记的值
        private int val, add;
    }

    private int N = (int)1e9;
    private Node root = new Node();

    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val += val;
            node.add += val;
            return;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        if (l <= mid) {
            update(node.left, start, mid, l, r, val);
        }
        if (r > mid) {
            update(node.right, mid + 1, end, l, r, val);
        }
        pushUp(node);
    }

    public int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return node.val;
        }
        pushDown(node);
        int mid = (start + end) >> 1, ans = 0;
        if (l <= mid) {
            ans = query(node.left, start, mid, l, r);
        }
        if (r > mid) {
            ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
        }
        return ans;
    }

    private void pushUp(Node node) {
        // 每个节点存的是当前区间的最大值
        node.val = Math.max(node.left.val, node.right.val);
    }

    private void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.add == 0) {
            return;
        }
        node.left.val += node.add;
        node.right.val += node.add;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }
}
