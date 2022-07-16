package cn.sichu.graduate.practice.leetcode;

import cn.sichu.graduate.practice.leetcode.utils.Node5;

/**
 * @author sichu
 * @date 2022/07/15
 */
public class Leetcode0558 {
    public Node5 intersect(Node5 quadTree1, Node5 quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            return new Node5(quadTree1.val | quadTree2.val, true, null, null, null, null);
        }
        if ((quadTree1.isLeaf && quadTree1.val) || (quadTree2.isLeaf && quadTree2.val)) {
            return new Node5(true, true, null, null, null, null);
        }
        Node5 topLeft = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topLeft,
            quadTree2.isLeaf ? quadTree2 : quadTree2.topLeft);
        Node5 topRight = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topRight,
            quadTree2.isLeaf ? quadTree2 : quadTree2.topRight);
        Node5 bottomLeft = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomLeft,
            quadTree2.isLeaf ? quadTree2 : quadTree2.bottomLeft);
        Node5 bottomRight = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomRight,
            quadTree2.isLeaf ? quadTree2 : quadTree2.bottomRight);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val
            && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node5(topLeft.val, true, null, null, null, null);
        }
        return new Node5(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
