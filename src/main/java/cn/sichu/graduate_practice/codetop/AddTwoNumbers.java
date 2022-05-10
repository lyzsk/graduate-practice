package cn.sichu.graduate_practice.codetop;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * 频率44
 * <p>
 * https://leetcode.cn/problems/add-two-numbers/
 * 
 * @author sichu
 * @date 2022/05/10
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        return dfs(l1, l2, carry);
    }

    private ListNode dfs(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;

        ListNode res = new ListNode(sum % 10);
        res.next = dfs((l1 != null ? l1.next : null), (l2 != null ? l2.next : null), sum / 10);
        return res;
    }
}
