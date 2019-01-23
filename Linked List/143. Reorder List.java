
/*

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

*/

/*

O(n),O(1)

*/

public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;
    ListNode fast = head, slow = head, prev = null, l1 = head;
    while (fast != null && fast.next != null) {
        prev = slow;
        fast = fast.next.next;
        slow = slow.next;
    }
    prev.next = null;
    ListNode l2 = reverse(slow);
    merge(l1, l2);
}

private ListNode reverse(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
        ListNode tmp = head.next;
        head.next = newHead;
        newHead = head;
        head = tmp;
    }
    return newHead;
}

private void merge(ListNode l1, ListNode l2) {
    while (l1 != null) {
        ListNode tmp1 = l1.next, tmp2 = l2.next;
        l1.next = l2;
        if (tmp1 == null) return;
        l2.next = tmp1;
        l1 = tmp1;
        l2 = tmp2;
    }

}




