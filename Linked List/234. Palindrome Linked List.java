
/*

Given a singly linked list, determine if it is a palindrome.

Example 1:
Input: 1->2
Output: false

Example 2:
Input: 1->2->2->1
Output: true

*/

/*

O(n),O(1)

*/

public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;
    while (slow != null) {
        if (fast.val != slow.val) return false;
        fast = fast.next;
        slow = slow.next;
    }
    return true;
}

private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}



