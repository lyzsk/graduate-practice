package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/same-tree/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class SameTree {
    /**
     * O(min(m, n))
     * <p>
     * O(min(m, n))
     * 
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

    }
}
