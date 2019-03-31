
/*

Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.

Example :
Input: [1,2,3]
Output: [1,2,4]

*/

/*

O(n),O(1)

*/

public ListNode plusOne(ListNode head) {
    if (head == null) return new ListNode(1);
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = head, slow = head;
    while (fast.next != null) {
        if (fast.val != 9) slow = fast;
        fast = fast.next;
    }
    if (fast.val != 9) {
        fast.val++;
        return head;
    } else {
        slow.val++;
        slow = slow.next;
    }
    while (slow != null) {
        slow.val = 0;
        slow = slow.next;
    }
    if (dummy.next.val == 10) {
        dummy.next.val = 0;
        dummy.val = 1;
    }
    return dummy.val == 1 ? dummy : dummy.next;
}




