
/*

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:
Input: 1->2->3->3->4->4->5
Output: 1->2->5

Example 2:
Input: 1->1->1->2->3
Output: 2->3

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
        if (slow.next == fast) slow = slow.next;
        else slow.next = fast.next;
        fast = fast.next;
    }
    return dummy.next;
}





