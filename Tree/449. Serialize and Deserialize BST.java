
/*

Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary search tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 

*/

/*

Solution 1: level order traversal
O(n),O(n)

*/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; ++i) {
                TreeNode cur = queue.poll();
                if (cur == null) ans.append("#,");
                else {
                    ans.append(cur.val + ",");
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
        String[] vals = data.split(",");
        TreeNode ans = new TreeNode(Integer.valueOf(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(ans);
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
        return ans;
    }
}


/*

Solution 2: preorder traversal
O(n),O(n)

*/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        preorder(ans, root);
        return ans.toString();
    }
    
    private void preorder(StringBuilder ans, TreeNode root) {
        if (root == null) ans.append("#,");
        else {
            ans.append(root.val + ",");
            preorder(ans, root.left);
            preorder(ans, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(vals));
        return deserialize(queue);
    }
    
    private TreeNode deserialize(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals("#")) return null;
        TreeNode ans = new TreeNode(Integer.valueOf(cur));
        ans.left = deserialize(queue);
        ans.right = deserialize(queue);
        return ans;
    }
}





