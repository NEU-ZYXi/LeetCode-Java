
/*

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

*/

/*

O(mlogn),O(1)
where n is the length of lists, m is the average size of each ListNode

*/

public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) 
        return null;
    int n = lists.length;
    while (n > 1) {
        for (int i = 0; i < n / 2; ++i) {
            lists[i] = mergeTwoLists(lists[i], lists[n - i - 1]);
        }
        n = (n + 1) / 2;
    }
    return lists[0];
}

private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            prev.next = l1;
            l1 = l1.next;
        } else {
            prev.next = l2;
            l2 = l2.next;
        }
        prev = prev.next;
    }
    while (l1 != null) {
        prev.next = l1;
        prev = prev.next;
        l1 = l1.next;
    }
    while (l2 != null) {
        prev.next = l2;
        prev = prev.next;
        l2 = l2.next;
    }
    return dummy.next;
}




