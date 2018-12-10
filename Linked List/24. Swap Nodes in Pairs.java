
/*

Given a linked list, swap every two adjacent nodes and return its head.

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.

*/

/*

O(n),O(1)

*/

public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    while (prev.next != null && prev.next.next != null) {
        ListNode l1 = prev.next, l2 = prev.next.next;
        l1.next = l2.next;
        l2.next = l1;
        prev.next = l2;
        prev = l1;
    }
    return dummy.next;
}




