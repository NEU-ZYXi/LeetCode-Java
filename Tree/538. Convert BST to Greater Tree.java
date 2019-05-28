
/*

Given a Binary Search Tree (BST), convert it to a Greater Tree 
such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:
Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13
Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

*/

/*

Solution 1: post order recursively sum each node
O(n),O(logn)

*/

private int sum = 0;
    
public TreeNode convertBST(TreeNode root) {
    if (root == null) {
        return null;
    }
    convertBST(root.right);
    root.val += sum;
    sum = root.val;
    convertBST(root.left);
    return root;
}


/*

Solution 2: post order iteratively
O(n),O(n)

*/

public TreeNode convertBST(TreeNode root) {
    int sum = 0;
    Deque<TreeNode> deque = new ArrayDeque<>();
    TreeNode cur = root;
    while (!deque.isEmpty() || cur != null) {
        while (cur != null) {
            deque.offerLast(cur);
            cur = cur.right;
        }
        cur = deque.pollLast();
        sum += cur.val;
        cur.val = sum;
        cur = cur.left;
    }
    return root;
}




