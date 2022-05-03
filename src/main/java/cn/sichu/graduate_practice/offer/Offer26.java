package cn.sichu.graduate_practice.offer;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        return A != null && B != null && (dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private static boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }

}
