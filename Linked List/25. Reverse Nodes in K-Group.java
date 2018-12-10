
/*

iven a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5

*/

/*

Solution: calculate the length of linked list as n, for each part with k nodes, reverse it
O(n),O(1)

*/

public ListNode reverseKGroup(ListNode head, int k) {
    int n = 0;
    for (ListNode cur = head; cur != null; cur = cur.next) n++;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy, cur = head;
    while (n >= k) {
        for (int i = 1; i < k; ++i) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
        }
        prev = cur;
        cur = prev.next;
        n -= k;
    }
    return dummy.next;
}
    
    



