package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/20
 */
public class Leetcode1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> num1 = new ArrayList<Integer>();
        List<Integer> num2 = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        inOrder(root1, num1);
        inOrder(root2, num2);
        int p1 = 0;
        int p2 = 0;
        while (true) {
            if (p1 == num1.size()) {
                res.addAll(num2.subList(p2, num2.size()));
                break;
            }
            if (p2 == num2.size()) {
                res.addAll(num1.subList(p1, num1.size()));
                break;
            }
            if (num1.get(p1) < num2.get(p2)) {
                res.add(num1.get(p1));
                ++p1;
            } else {
                res.add(num2.get(p2));
                ++p2;
            }
        }
        return res;
    }

    private static void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}
