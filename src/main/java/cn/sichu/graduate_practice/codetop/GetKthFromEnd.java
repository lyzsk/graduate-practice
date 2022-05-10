package cn.sichu.graduate_practice.codetop;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * 频率45
 * <p>
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 
 * @author sichu
 * @date 2022/05/10
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
