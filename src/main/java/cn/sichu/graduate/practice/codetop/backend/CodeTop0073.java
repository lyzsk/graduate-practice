package cn.sichu.graduate.practice.codetop.backend;

import cn.sichu.graduate.practice.codetop.utils.Node;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0073 {
    public Node copyRandomList(Node head) {
        for (Node p = head; p != null; p = p.next.next) {
            Node q = new Node(p.val);
            q.next = p.next;
            p.next = q;
        }
        for (Node p = head; p != null; p = p.next.next) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
        }
        Node dummy = new Node(-1);
        Node cur = dummy;
        for (Node p = head; p != null; p = p.next) {
            Node q = p.next;
            cur = cur.next = q;
            p.next = q.next;
        }
        return dummy.next;
    }
}
