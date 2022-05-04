package cn.sichu.graduate_practice.offer;

public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {

    }

    public Node(int val) {
        super();
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
