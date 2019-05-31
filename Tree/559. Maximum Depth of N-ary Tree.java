
/*

Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

*/

/*

O(n),O(logn)

*/

public int maxDepth(Node root) {
    if (root == null) {
        return 0;
    }
    int ans = 0;
    for (int i = 0; i < root.children.size(); ++i) {
        ans = Math.max(ans, maxDepth(root.children.get(i)));
    }
    return ans + 1;
}




