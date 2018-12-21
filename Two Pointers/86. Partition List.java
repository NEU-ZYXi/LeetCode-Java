
/*

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example:
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

*/

/*

O(n),O(1)

*/

public ListNode partition(ListNode head, int x) {
    ListNode dummy1 = new ListNode(0), prev1 = dummy1;
    ListNode dummy2 = new ListNode(0), prev2 = dummy2;
    ListNode cur = head;
    while (cur != null) {
        if (cur.val < x) {
            prev1.next = cur;
            prev1 = prev1.next;
        } else {
            prev2.next = cur;
            prev2 = prev2.next;
        }
        cur = cur.next;
    }
    prev1.next = dummy2.next;
    prev2.next = null;
    return dummy1.next;
}




