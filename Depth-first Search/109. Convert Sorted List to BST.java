
/*

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.

Example:
Given the sorted linked list: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

*/

/*

O(n),O(logn)

*/

public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    ListNode fast = head, slow = head, prev = null;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        prev = slow;
        slow = slow.next;
    }
    TreeNode root = new TreeNode(slow.val);
    if (prev != null) prev.next = null;
    else head = null;
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);
    return root;
}




