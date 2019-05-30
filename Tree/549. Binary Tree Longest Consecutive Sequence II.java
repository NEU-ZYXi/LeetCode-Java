
/*

Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
Especially, this path can be either increasing or decreasing. 
For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. 
On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.

Example 1:
Input:
        1
       / \
      2   3
Output: 2
Explanation: The longest consecutive path is [1, 2] or [2, 1].
 
Example 2:
Input:
        2
       / \
      1   3
Output: 3
Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].

*/

/*

O(n),O(logn)

*/

private int ans = 0;
    
public int longestConsecutive(TreeNode root) {
    dfs(root);
    return ans;
}

private int[] dfs(TreeNode root) {
    if (root == null) {
        return new int[] {0, 0};
    }
    int[] left = dfs(root.left);
    int[] right = dfs(root.right);
    int asc = 1, dsc = 1;
    if (root.left != null) {
        if (root.val - root.left.val == 1) {
            dsc = left[1] + 1;
        } else if (root.left.val - root.val == 1) {
            asc = left[0] + 1;
        }
    }
    if (root.right != null) {
        if (root.val - root.right.val == 1) {
            dsc = Math.max(dsc, right[1] + 1);
        } else if (root.right.val - root.val == 1) {
            asc = Math.max(asc, right[0] + 1);
        }
    }
    ans = Math.max(ans, asc + dsc - 1);
    return new int[] {asc, dsc};
}




