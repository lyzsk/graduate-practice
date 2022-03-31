package cn.sichu.graduate_practice.easy;

public class RemoveDuplicatesFromSortedList {
    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
