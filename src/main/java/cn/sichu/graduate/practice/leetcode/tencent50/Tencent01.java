package cn.sichu.graduate.practice.leetcode.tencent50;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * 
 * @author sichu
 * @date 2022/06/11
 */
public class Tencent01 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        return dfs(l1, l2, carry);
    }

    private static ListNode dfs(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        ListNode res = new ListNode(sum % 10);
        res.next = dfs((l1 == null ? null : l1.next), (l2 == null ? null : l2.next), sum / 10);
        return res;
    }
}
