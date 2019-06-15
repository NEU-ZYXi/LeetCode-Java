
/*

Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': 
a value of 0 represents 'a', a value of 1 represents 'b', and so on.
Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
(As a reminder, any shorter prefix of a string is lexicographically smaller: 
for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)

Example 1:
Input: [0,1,2,3,4,3,4]
Output: "dba"

Example 2:
Input: [25,1,3,1,3,0,2]
Output: "adz"

Example 3:
Input: [2,2,1,null,1,0,null,0]
Output: "abc"

*/

/*

Solution: keep adding the current node value to the prefix because A<B doesn't promise A+C<B+C so that we use top-down DFS
O(n),O(logn)          

*/

public String smallestFromLeaf(TreeNode root) {
    if (root == null) {
        return "";
    }
    return dfs(root, "");
}

private String dfs(TreeNode root, String s) {
    s = String.valueOf((char)('a' + root.val)) + s;
    if (root.left == null && root.right == null) {
        return s;
    }
    if (root.left == null || root.right == null) {
        return root.left == null ? dfs(root.right, s) : dfs(root.left, s);
    }
    String left = dfs(root.left, s);
    String right = dfs(root.right, s);
    return left.compareTo(right) < 0 ? left : right;
}




