package cn.sichu.graduate.practice.leetcode.offerii;

import cn.sichu.graduate.practice.leetcode.utils.Node3;

/**
 * @author sichu
 * @date 2022/06/18
 */
public class OfferII029 {
    public Node3 insert(Node3 head, int insertVal) {
        Node3 node = new Node3(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node3 cur = head;
        Node3 next = head.next;
        while (next != head) {
            if (insertVal >= cur.val && insertVal <= next.val) {
                break;
            }
            if (cur.val > next.val) {
                if (insertVal > cur.val || insertVal < next.val) {
                    break;
                }
            }
            cur = cur.next;
            next = next.next;
        }
        cur.next = node;
        node.next = next;
        return head;
    }
}
