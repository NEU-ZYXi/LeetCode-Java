
/*

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Example 1:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4->1->9 after calling your function.

Example 2:
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4->5->9 after calling your function.

*/

/*

O(1),O(1)

*/

public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}



