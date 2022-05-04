package cn.sichu.graduate_practice.offer;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 
 * @author sichu
 * @date 2022/05/04
 */
public class Offer36 {
    Node pre = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }

        root.left = pre;
        pre = root;
        dfs(root.right);
    }
}
