package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 
 * @author sichu
 * @date 2022/03/27
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;

        return preHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        super();
    }

    public ListNode(int val) {
        super();
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        super();
        this.val = val;
        this.next = next;
    }

}
