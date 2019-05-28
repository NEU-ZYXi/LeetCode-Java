
/*

You need to construct a binary tree from a string consisting of parenthesis and integers.
The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. 
The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
You always start to construct the left child node of the parent first if it exists.

Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

*/

/*

O(n),O(logn)

*/

public TreeNode str2tree(String s) {
    int n = s.length();
    if (n == 0) {
        return null;
    }
    int i = 0, j = 0;
    while (j < n && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-')) {
        j++;
    }
    TreeNode root = new TreeNode(Integer.valueOf(s.substring(0, j)));
    if (j < n) {
        i = j;
        int cnt = 1;
        while (j < n - 1 && cnt != 0) {
            j++;
            if (s.charAt(j) == '(') {
                cnt++;
            } else if (s.charAt(j) == ')') {
                cnt--;
            }
        }
        root.left = str2tree(s.substring(i + 1, j));
    }
    j++;
    if (j < n) {
        root.right = str2tree(s.substring(j + 1, n - 1));
    }
    return root;
}




