package cn.sichu.graduate_practice.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * 
 * @author sichu
 * @date 2022/04/02
 */
public class TwoSumIVInputIsABST {
    List<Integer> list = new ArrayList<Integer>();

    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) + list.get(right) == k) {
                return true;
            }
            if (list.get(left) + list.get(right) < k) {
                ++left;
            } else {
                --right;
            }
        }
        return false;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
