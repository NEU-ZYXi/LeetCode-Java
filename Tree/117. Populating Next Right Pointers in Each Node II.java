
/*

Given a binary tree
struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

Note:
You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL

*/

/*

Solution: head is the pointer of the head node of the current level
          cur is the pointer of the node of the current level
          p is the pointer to track the link of the next level
O(n),O(1)Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL          

*/

public void connect(TreeLinkNode root) {
    TreeLinkNode head = root;
    TreeLinkNode cur = null;
    TreeLinkNode p = null;
    while (head != null) {
        cur = head;
        head = null;
        p = null;
        while (cur != null) {
            if (cur.left != null) {
                if (p != null) p.next = cur.left;
                else head = cur.left;
                p = cur.left;
            } 
            if (cur.right != null) {
                if (p != null) p.next = cur.right;
                else head = cur.right;
                p = cur.right;
            }
            cur = cur.next;
        }
    }
}




