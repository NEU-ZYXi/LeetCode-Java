
/*

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) 
in the linked list where tail connects to. 
If pos is -1, then there is no cycle in the linked list.
Note: Do not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

*/

/*

Solution:

          a        b 
 start ------->-------->meeting
              |         |
              <----------
                   c
 assume fast and slow meets at k steps
 k=a+b+r1(b+c) slow
 2k=a+b+r2(b+c) fast
 2k=a+b+r2(b+c)=2a+2b+2r1(b+c)
 (b+c)(r2-2r1)=a+b => (b+c)n=a+b
 a=(n-1)b+nc=(n-1)(b+c)+c which means slow moves (n-1) rounds and c
     
O(n),O(1)     

*/

public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head, start = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) {
            while (start != slow) {
                start = start.next;
                slow = slow.next;
            }
            return start;
        }
    }
    return null;
}




