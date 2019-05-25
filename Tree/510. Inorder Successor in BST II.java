
/*

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
The successor of a node p is the node with the smallest key greater than p.val.
You will have direct access to the node but not to the root of the tree. 
Each node will have a reference to its parent node.

Example 1:
Input: 
root = {"$id":"1","left":{"$id":"2","left":null,"parent":{"$ref":"1"},"right":null,"val":1},"parent":null,
        "right":{"$id":"3","left":null,"parent":{"$ref":"1"},"right":null,"val":3},"val":2}
p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of Node type.

Example 2:
Input: 
root = {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":{"$id":"4","left":null,"parent":{"$ref":"3"},"right":null,"val":1},
        "parent":{"$ref":"2"},"right":null,"val":2},"parent":{"$ref":"1"},"right":{"$id":"5","left":null,"parent":{"$ref":"2"},
        "right":null,"val":4},"val":3},"parent":null,"right":{"$id":"6","left":null,"parent":{"$ref":"1"},
        "right":null,"val":6},"val":5}
p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.

*/

/*

O(n),O(1)

*/

public Node inorderSuccessor(Node x) {
    if (x.right == null) {
        Node ans = x.parent;
        while (ans != null && x.val > ans.val) {
            ans = ans.parent;
        }
        return ans;
    } else {
        Node ans = x.right;
        while (ans != null && ans.left != null) {
            ans = ans.left;
        }
        return ans;
    }
}





