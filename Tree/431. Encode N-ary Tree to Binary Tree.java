
/*

Design an algorithm to encode an N-ary tree into a binary tree and decode the binary tree to get the original N-ary tree. 
An N-ary tree is a rooted tree in which each node has no more than N children. 
Similarly, a binary tree is a rooted tree in which each node has no more than 2 children. 
There is no restriction on how your encode/decode algorithm should work. 
You just need to ensure that an N-ary tree can be encoded to a binary tree and 
this binary tree can be decoded to the original N-nary tree structure.

*/

/*

Solution: set the first child to the left side of parent node and all other children nodes to the right of the first child
              1             1
            / | \          /
           2  3  4  =>    2
           |             / \
           5            5   3
                             \
                              4
O(n),O(n)

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;
        TreeNode ans = new TreeNode(root.val);
        if (root.children.size() > 0) ans.left = encode(root.children.get(0));
        TreeNode cur = ans.left;
        for (int i = 1; i < root.children.size(); ++i) {
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }
        return ans;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Node ans = new Node(root.val, new ArrayList<>());
        TreeNode cur = root.left;
        while (cur != null) {
            ans.children.add(decode(cur));
            cur = cur.right;
        }
        return ans;
    }
}




