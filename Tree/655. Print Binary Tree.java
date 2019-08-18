
/*

Print a binary tree in an m*n 2D string array following these rules:
The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. 
The column and the row where the root node belongs will separate the rest space into two parts 
(left-bottom part and right-bottom part). 
You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. 
The left-bottom part and the right-bottom part should have the same size. 
Even if one subtree is none while the other is not, 
you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree.
However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.

Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
 
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
 
Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:
[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]

*/

/*

O(n),O(n)

*/

public List<List<String>> printTree(TreeNode root) {
    int height = getHeight(root), n = (1 << height) - 1;
    List<List<String>> ans = new ArrayList<>();
    List<String> row = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
        row.add("");
    }
    for (int i = 0; i < height; ++i) {
        ans.add(new ArrayList<>(row));
    }
    levelorder(ans, root, 0, 0, n - 1);
    return ans;
}

private int getHeight(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return 1 + Math.max(getHeight(root.left), getHeight(root.right));
}

private void levelorder(List<List<String>> ans, TreeNode root, int level, int l, int r) {
    if (root == null) {
        return;
    }
    ans.get(level).set((l + r) / 2, String.valueOf(root.val));
    levelorder(ans, root.left, level + 1, l, (l + r) / 2 - 1);
    levelorder(ans, root.right, level + 1, (l + r) / 2 + 1, r);
}




