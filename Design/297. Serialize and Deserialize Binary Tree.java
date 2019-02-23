
/*

Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original.

Example: 
You may serialize the following tree:
    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]"

*/

/*

Solution 1: level order traversal to serialize and deserialize 
O(n),O(n)

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder ans = new StringBuilder();
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; ++i) {
                TreeNode cur = queue.poll();
                if (cur == null) ans.append("#").append(",");
                else {
                    ans.append(cur.val).append(",");
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] vals = data.split("\\,");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        queue.offer(root);
        for (int i = 1; i < vals.length; ++i) {
            TreeNode cur = queue.poll();
            if (!vals[i].equals("#")) {
                cur.left = new TreeNode(Integer.valueOf(vals[i]));
                queue.offer(cur.left);
            } 
            if (!vals[++i].equals("#")) {
                cur.right = new TreeNode(Integer.valueOf(vals[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}


/*

Solution 2: preorder traversal to serialize and deserialize
O(n),O(logn)

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        preorder(root, ans);
        return ans.toString();
    }
    
    private void preorder(TreeNode root, StringBuilder ans) {
        if (root == null) ans.append("#").append(",");
        else {
            ans.append(root.val).append(",");
            preorder(root.left, ans);
            preorder(root.right, ans);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split("\\,");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(vals));
        return deserialize(queue);
    }
    
    private TreeNode deserialize(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}




