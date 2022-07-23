package cn.sichu.graduate.practice.leetcode.offerii;

import cn.sichu.graduate.practice.leetcode.utils.Node6;

/**
 * @author sichu
 * @date 2022/07/23
 */
public class OfferII028 {
    public Node6 flatten(Node6 head) {
        dfs(head);
        return head;
    }

    public Node6 dfs(Node6 node) {
        Node6 cur = node;
        // 记录链表的最后一个节点
        Node6 last = null;

        while (cur != null) {
            Node6 next = cur.next;
            // 如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node6 childLast = dfs(cur.child);

                next = cur.next;
                // 将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;

                // 如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                // 将 child 置为空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
