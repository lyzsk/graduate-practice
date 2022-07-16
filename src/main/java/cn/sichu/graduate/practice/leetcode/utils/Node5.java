package cn.sichu.graduate.practice.leetcode.utils;

/**
 * @author sichu
 * @date 2022/07/15
 */
public class Node5 {
    public boolean val;
    public boolean isLeaf;
    public Node5 topLeft;
    public Node5 topRight;
    public Node5 bottomLeft;
    public Node5 bottomRight;

    public Node5() {}

    public Node5(boolean _val, boolean _isLeaf, Node5 _topLeft, Node5 _topRight, Node5 _bottomLeft,
        Node5 _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}
