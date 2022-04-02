package cn.sichu.graduate_practice.medium;

import java.util.ArrayList;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 
 * @author sichu
 * @date 2022/04/02
 */
public class PathSumII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    /**
     * O(n<sup>2</sup>)
     * <p>
     * O(n)
     * 
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        targetSum -= root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<Integer>(path));
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.remove(path.size() - 1);
    }
}
