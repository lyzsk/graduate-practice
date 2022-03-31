package cn.sichu.graduate_practice.medium;

import java.util.ArrayList;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<TreeNode>();

        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (int j = 0; j < leftTrees.size(); j++) {
                for (int k = 0; k < rightTrees.size(); k++) {
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = leftTrees.get(j);
                    curTree.right = rightTrees.get(k);
                    allTrees.add(curTree);
                }
            }
        }
        return allTrees;
    }
}
