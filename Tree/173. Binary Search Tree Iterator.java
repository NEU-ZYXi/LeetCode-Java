
/*

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.

Example:
[3, 7, 9, 15, 20]
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false

*/

/*

constructor(): O(logn),O(n)
next(): O(1),O(n), since each node is only visited twice and next() is called n times

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    
    Deque<TreeNode> deque;
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        this.deque = new LinkedList<>();
        this.cur = root;
        while (cur != null) {
            deque.offerLast(cur);
            cur = cur.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        this.cur = deque.pollLast();
        int ans = cur.val;
        cur = cur.right;
        while (cur != null) {
            deque.offerLast(cur);
            cur = cur.left;
        }
        return ans;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !deque.isEmpty();
    }
}




