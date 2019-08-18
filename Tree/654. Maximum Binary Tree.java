
/*

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:
      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1

*/

/*

Solution 1: O(n^2),O(n)

*/

public TreeNode constructMaximumBinaryTree(int[] nums) {
    int n = nums.length;
    return dfs(nums, 0, n - 1);
}

private TreeNode dfs(int[] nums, int l, int r) {
    if (l > r) {
        return null;
    }
    int idx = l;
    for (int i = l; i <= r; ++i) {
        if (nums[i] > nums[idx]) {
            idx = i;
        }
    }
    TreeNode root = new TreeNode(nums[idx]);
    root.left = dfs(nums, l, idx - 1);
    root.right = dfs(nums, idx + 1, r);
    return root;
}


/*

Solution 2: whenever we have a larger node, find the largest one less than current node in the deque and make it left subtree
O(n),O(n)

*/

public TreeNode constructMaximumBinaryTree(int[] nums) {
    int n = nums.length;
    if (n == 0) {
        return null;
    }
    Deque<TreeNode> deque = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
        TreeNode cur = new TreeNode(nums[i]);
        while (!deque.isEmpty() && deque.peekLast().val < nums[i]) {
            cur.left = deque.pollLast();
        }
        if (!deque.isEmpty()) {
            deque.peekLast().right = cur;
        }
        deque.offerLast(cur);
    }
    while (deque.size() > 1) {
        deque.pollLast();
    }
    return deque.peekLast();
}



