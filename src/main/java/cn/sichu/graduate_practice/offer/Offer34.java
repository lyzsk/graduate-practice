package cn.sichu.graduate_practice.offer;

import java.util.ArrayList;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * <p>
 * same: <@link cn.sichu.graduate_practice.medium.PathSumII>
 * 
 * @author sichu
 * @date 2022/05/04
 */
public class Offer34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(res, path, root, target);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int target) {
        if (root == null) {
            return;
        }

        target -= root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<Integer>(path));
        }

        dfs(res, path, root.left, target);
        dfs(res, path, root.right, target);
        path.remove(path.size() - 1);
    }
}
