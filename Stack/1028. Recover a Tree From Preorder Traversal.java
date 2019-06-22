
/*

We run a preorder depth first search on the root of a binary tree.
At each node in this traversal, we output D dashes (where D is the depth of this node), 
then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  
The depth of the root node is 0.)
If a node has only one child, that child is guaranteed to be the left child.
Given the output S of this traversal, recover the tree and return its root.

Example 1:
Input: "1-2--3--4-5--6--7"
Output: [1,2,5,3,4,6,7]

Example 2:
Input: "1-2--3---4-5--6---7"
Output: [1,2,5,3,null,6,null,4,null,7]
 
Example 3:
Input: "1-401--349---90--88"
Output: [1,401,null,349,88,90]

*/

/*

Solution: use a deque to store travesed nodes
          first get '-' depth and value
          for preorder traversal, depth keeps increasing by 1
          if current depth is smaller than deque size, pop because we traverse back
O(n),O(n)          

*/

public TreeNode recoverFromPreorder(String S) {
    Deque<TreeNode> deque = new ArrayDeque<>();
    int n = S.length(), i = 0;
    while (i < n) {
        int depth = 0, val = 0;
        while (i < n && S.charAt(i) == '-') {
            depth++;
            i++;
        }
        while (i < n && Character.isDigit(S.charAt(i))) {
            val = val * 10 + (S.charAt(i) - '0');
            i++;
        }
        while (deque.size() > depth) {
            deque.pollLast();
        }
        TreeNode node = new TreeNode(val);
        if (!deque.isEmpty()) {
            if (deque.peekLast().left == null) {
                deque.peekLast().left = node;
            } else {
                deque.peekLast().right = node;
            }
        }
        deque.offerLast(node);
    }
    return deque.peekFirst();
}




