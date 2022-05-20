package cn.sichu.graduate_practice.medium;

import java.util.ArrayList;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<Integer>();
        List<Integer> nums2 = new ArrayList<Integer>();
        inOrder(root1, nums1);
        inOrder(root2, nums2);

        List<Integer> res = new ArrayList<Integer>();
        int idx1 = 0;
        int idx2 = 0;
        while (true) {
            if (idx1 == nums1.size()) {
                res.addAll(nums2.subList(idx2, nums2.size()));
                break;
            }
            if (idx2 == nums2.size()) {
                res.addAll(nums1.subList(idx1, nums1.size()));
                break;
            }
            if (nums1.get(idx1) < nums2.get(idx2)) {
                res.add(nums1.get(idx1));
                ++idx1;
            } else {
                res.add(nums2.get(idx2));
                ++idx2;
            }
        }
        return res;
    }

    private static void inOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inOrder(root.left, res);
            res.add(root.val);
            inOrder(root.right, res);
        }
    }
}
