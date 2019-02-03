
/*

Reverse a singly linked list.

Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

*/

/*

Solution 1: iterative way
O(n),O(1)

*/

public ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
        ListNode tmp = head.next;
        head.next = newHead;
        newHead = head;
        head = tmp;
    }
    return newHead;
}


/*

Solution 2: recursive way
O(n),O(n)

*/

public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}



