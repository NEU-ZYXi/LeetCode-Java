
/*

You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

*/

/*

O(n+m),O(n+m)

*/

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Deque<Integer> deque1 = new LinkedList<>();
    Deque<Integer> deque2 = new LinkedList<>();
    while (l1 != null) {
        deque1.offerLast(l1.val);
        l1 = l1.next;
    }
    while (l2 != null) {
        deque2.offerLast(l2.val);
        l2 = l2.next;
    }
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    int sum = 0;
    while (!deque1.isEmpty() || !deque2.isEmpty()) {
        sum /= 10;
        if (!deque1.isEmpty()) sum += deque1.pollLast();
        if (!deque2.isEmpty()) sum += deque2.pollLast();
        prev.next = new ListNode(sum % 10);
        prev = prev.next;
    }
    if (sum >= 10) prev.next = new ListNode(1);
    ListNode newHead = null;
    while (dummy.next != null) {
        ListNode tmp = dummy.next.next;
        dummy.next.next = newHead;
        newHead = dummy.next;
        dummy.next = tmp;
    }
    return newHead;
}




