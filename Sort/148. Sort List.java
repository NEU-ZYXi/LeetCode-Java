
/*

Sort a linked list in O(n log n) time using constant space complexity.

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4

Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5

*/

/*

O(nlogn),O(1)

*/

public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode fast = head, slow = head, prev = null;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        prev = slow;
        slow = slow.next;
    }
    prev.next = null;
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);
    ListNode ans = merge(l1, l2);
    return ans;
}

private ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
        l1.next = merge(l1.next, l2);
        return l1;
    } else {
        l2.next = merge(l1, l2.next);
        return l2;
    }
}




