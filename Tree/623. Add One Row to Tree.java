
/*

Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. 
The root node is at depth 1.
The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, 
create two tree nodes with value v as N's left subtree root and right subtree root. 
And N's original left subtree should be the left subtree of the new left subtree root, 
its original right subtree should be the right subtree of the new right subtree root. 
If depth d is 1 that means there is no depth d-1 at all, 
then create a tree node with value v as the new root of the whole original tree, 
and the original tree is the new root's left subtree.

Example 1:
Input: 
A binary tree as following:
       4
     /   \
    2     6
   / \   / 
  3   1 5   
v = 1
d = 2
Output: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   

Example 2:
Input: 
A binary tree as following:
      4
     /   
    2    
   / \   
  3   1    
v = 1
d = 3
Output: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1

*/

/*

O(n),O(logn)

*/

public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
        TreeNode ans = new TreeNode(v);
        ans.left = root;
        return ans;
    }
    dfs(root, v, d, 1);
    return root;
}

private void dfs(TreeNode root, int v, int d, int cur) {
    if (cur >= d || root == null) {
        return;
    }
    if (cur == d - 1) {
        TreeNode left = root.left, right = root.right;
        root.left = new TreeNode(v);
        root.right = new TreeNode(v);
        root.left.left = left;
        root.right.right = right;
    } else {
        dfs(root.left, v, d, cur + 1);
        dfs(root.right, v, d, cur + 1);
    }
}




