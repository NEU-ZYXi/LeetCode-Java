
/*

Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize an N-ary tree.
An N-ary tree is a rooted tree in which each node has no more than N children. 
There is no restriction on how your serialization/deserialization algorithm should work. 
Ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.

*/

/*

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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder ans = new StringBuilder();
        serialize(root, ans);
        return ans.toString();
    }
    
    private void serialize(Node root, StringBuilder ans) {
        if (root == null) ans.append("#,");
        else {
            ans.append(root.val + "(" + root.children.size() + ")" + ",");
            for (Node child : root.children) serialize(child, ans);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }
    
    private Node deserialize(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals("#")) return null;
        int val = Integer.valueOf(cur.substring(0, cur.indexOf("(")));
        int size = Integer.valueOf(cur.substring(cur.indexOf("(") + 1, cur.indexOf(")")));
        Node root = new Node(val, new ArrayList<>());
        for (int i = 0; i < size; ++i) root.children.add(deserialize(queue));
        return root;
    }
}





