
/*

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

/*

Solution 1. take each node i as the root node, and the left subtree is built from 0...i-1, right subtree is from i+1...n
            recursively generate the list of left nodes and right nodes, choose each of them to combine as a tree
            F(i)=G(i-1)*G(n-i)
O(m*Catalan(n))=O(m*4^n),O(n), where Catalan number means C(n)=C(0)*C(n-1)+C(1)*C(n-2)+...+C(n-1)*C(0), m is average length

*/

public List<TreeNode> generateTrees(int n) {
    if (n == 0) return new ArrayList<>();
    return solve(1, n);
}

private List<TreeNode> solve(int l, int r) {
    List<TreeNode> ans = new ArrayList<>();
    if (l > r) ans.add(null);
    for (int i = l; i <= r; ++i) {
        List<TreeNode> leftTree = solve(l, i - 1);
        List<TreeNode> rightTree = solve(i + 1, r);
        for (TreeNode left : leftTree) {
            for (TreeNode right : rightTree) {
                TreeNode root = new TreeNode(i);
                root.left = left;
                root.right = right;
                ans.add(root);
            }
        }
    }
    return ans;
}


/*

Solution 2. dp[i] means the list of tree nodes with length i
            for dp[i], we could any j+1 as the root node where 0<j<i, left node from dp[j] and right node from dp[i-j-1]
            for left node, do not need to update its value since it's smaller than root node
            for right node, need offset to update its value since right node should be larger than root node j+1
O(m*Catalan(n))=O(m*4^n),O(n)           

*/

public List<TreeNode> generateTrees(int n) {
    List<TreeNode> dp[] = new ArrayList[n + 1];
    dp[0] = new ArrayList<>();
    if (n == 0) return dp[0];
    dp[0].add(null);
    for (int i = 1; i <= n; ++i) {
        dp[i] = new ArrayList<>();
        for (int j = 0; j < i; ++j) {
            for (TreeNode left : dp[j]) {
                for (TreeNode right : dp[i - j - 1]) {
                    TreeNode root = new TreeNode(j + 1);
                    root.left = left;
                    root.right = clone(right, j + 1);
                    dp[i].add(root);
                }
            }
        }
    }
    return dp[n];
}

private TreeNode clone(TreeNode root, int offset) {
    if (root == null) return null;
    TreeNode node = new TreeNode(root.val + offset);
    node.left = clone(root.left, offset);
    node.right = clone(root.right, offset);
    return node;
}





