package cn.sichu.graduate.practice.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * @author sichu
 * @date 2022/06/18
 */
public class Offer37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new ArrayList<String>(Arrays.asList(dataArray));
        return deserialize(dataList);
    }

    private static String serialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = serialize(root.left, str);
            str = serialize(root.right, str);
        }
        return str;
    }

    private static TreeNode deserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = deserialize(dataList);
        root.right = deserialize(dataList);
        return root;
    }
}
