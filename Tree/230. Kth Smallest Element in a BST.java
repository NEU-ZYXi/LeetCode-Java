
/*

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

*/

/*

Solution 1: inorder traversal recursively until get the kth element
O(k),O(logn)

*/

public int kthSmallest(TreeNode root, int k) {
    int[] ans = new int[] {0, k};
    dfs(root, ans);
    return ans[0];
}

private void dfs(TreeNode root, int[] ans) {
    if (root == null) return;
    dfs(root.left, ans);
    ans[1]--;
    if (ans[1] == 0) {
        ans[0] = root.val;
        return;
    }
    dfs(root.right, ans);
}


/*

Solution 2: inorder traversal iteratively until get the kth element
O(k),O(k)

*/

public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> deque = new LinkedList<>();
    TreeNode cur = root;
    while (!deque.isEmpty() || cur != null) {
        while (cur != null) {
            deque.offerLast(cur);
            cur = cur.left;
        }
        cur = deque.pollLast();
        k--;
        if (k == 0) return cur.val;
        cur = cur.right;
    }
    return 0;
}


/*

Solution 3: count the left subtree as mid value to binary search
            if k=mid+1, which means the root node is the kth element
            if k>mid+1, which means the kth element is in the right subtree of (k-mid-1)th element
            if k<mid+1, which means the kth element is in the left subtree of kth element
O(nlogn),O(logn)            

*/

public int kthSmallest(TreeNode root, int k) {
    int mid = count(root.left);
    if (k == mid + 1) return root.val;
    else if (k < mid + 1) return kthSmallest(root.left, k);
    else return kthSmallest(root.right, k - mid - 1);
}

private int count(TreeNode root) {
    return root == null ? 0 : 1 + count(root.left) + count(root.right);
}



