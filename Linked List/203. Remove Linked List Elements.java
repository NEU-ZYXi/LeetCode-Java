
/*

Remove all elements from a linked list of integers that have value val.

Example:
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

*/

/*

O(n),O(1)

*/

public ListNode removeElements(ListNode head, int val) {
    if (head == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    while (prev != null) {
        while (prev.next != null && prev.next.val == val) prev.next = prev.next.next;
        prev = prev.next;
    }
    return dummy.next;
}




