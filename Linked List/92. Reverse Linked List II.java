
/*

Reverse a linked list from position m to n. Do it in one-pass.
Note: 1 ≤ m ≤ n ≤ length of list.

Example:
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

*/

/*

O(n),O(1)

*/

public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    for (int i = 0; i < m - 1; ++i) prev = prev.next;
    ListNode cur = prev.next, nxt = cur.next;
    for (int i = 0; i < n - m; ++i) {
        cur.next = nxt.next;
        nxt.next = prev.next;
        prev.next = nxt;
        nxt = cur.next;
    }
    return dummy.next;
}



