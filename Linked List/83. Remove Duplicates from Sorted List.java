
/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:
Input: 1->1->2
Output: 1->2

Example 2:
Input: 1->1->2->3->3
Output: 1->2->3

*/

/*

O(n),O(1)

*/

public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = head, slow = dummy;
    while (fast != null && fast.next != null) {
        while (fast != null && fast.next != null && fast.val == fast.next.val) fast = fast.next;
        slow.next = fast;
        slow = slow.next;
        fast = fast.next;
    }
    return dummy.next;
}


public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = head;
    while (cur != null) {
        while (cur != null && cur.next != null && cur.val == cur.next.val) cur.next = cur.next.next;
        cur = cur.next;
    }
    return dummy.next;
}



