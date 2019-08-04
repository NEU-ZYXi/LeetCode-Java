
/*

Two players play a turn based game on a binary tree. 
We are given the root of this binary tree, and the number of nodes n in the tree. 
n is odd, and each node has a distinct value from 1 to n.
Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x. 
The first player colors the node with value x red, and the second player colors the node with value y blue.
Then, the players take turns starting with the first player. 
In each turn, that player chooses a node of their color (red if player 1, blue if player 2) 
and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)
If (and only if) a player cannot choose such a node in this way, they must pass their turn.  
If both players pass their turn, the game ends, and the winner is the player that colored more nodes.
You are the second player. 
If it is possible to choose such a y to ensure you win the game, return true. 
If it is not possible, return false. 

Example 1:
Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
Output: true
Explanation: The second player can choose the node with value 2.

*/

/*

Solution 1: find the target node, and count its parent, left and right subtree
          because the second player can only take one of the three branches
O(n),O(logn)          

*/

public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    TreeNode cur = find(root, x);
    int parent = count(root) - count(cur), left = count(cur.left), right = count(cur.right);
    return Math.max(Math.max(left, right), parent) > n / 2;
}

private TreeNode find(TreeNode root, int val) {
    if (root == null) {
        return null;
    }
    if (root.val == val) {
        return root;
    }
    TreeNode left = find(root.left, val);
    return left == null ? find(root.right, val) : left;
}

private int count(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return 1 + count(root.left) + count(root.right);
}


/*

Solution 2: track the number of left and right subtree nodes during DFS
O(n),O(logn)

*/

private int left, right;
    
public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    dfs(root, x);
    int parent = n - left - right - 1;
    return Math.max(Math.max(left, right), parent) > n / 2;
}

private int dfs(TreeNode root, int val) {
    if (root == null) {
        return 0;
    }
    int left = dfs(root.left, val), right = dfs(root.right, val);
    if (root.val == val) {
        this.left = left;
        this.right = right;
    }
    return 1 + left + right;
}




