package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class ConvertSortedArrayToBinarySearchTree {
    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length - 1, nums);
    }

    private TreeNode dfs(int left, int right, int[] nums) {
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        if (left < mid) {
            root.left = dfs(left, mid - 1, nums);
        }
        if (right > mid) {
            root.right = dfs(mid + 1, right, nums);
        }
        return root;
    }
}
