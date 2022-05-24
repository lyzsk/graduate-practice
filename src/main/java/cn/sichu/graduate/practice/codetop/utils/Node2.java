package cn.sichu.graduate.practice.codetop.utils;

/**
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {

    }

    public Node2(int _val) {
        this.val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right) {
        this.val = _val;
        this.left = _left;
        this.right = _right;
    }
}
