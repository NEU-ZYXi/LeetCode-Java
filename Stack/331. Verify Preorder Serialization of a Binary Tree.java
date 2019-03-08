
/*

One way to serialize a binary tree is to use pre-order traversal. 
When we encounter a non-null node, we record the node's value. 
If it is a null node, we record using a sentinel value such as #.
     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. 
Find an algorithm without reconstructing the tree.
Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true

Example 2:
Input: "1,#"
Output: false

Example 3:
Input: "9,#,#,1"
Output: false

*/

/*

Solution 1: use a deque to simulate preorder traversal
            1. push nodes into deque which means traverse all left nodes
            2. when we find a # node, pop the least left node and the least root node
            3. then go to right subtree and do the same process
            4. all the nodes will be popped if it's a valid preorder traversal and the last one inside is a # node
O(n),O(n)            

*/

public boolean isValidSerialization(String preorder) {
    String[] nodes = preorder.split(",");
    Deque<String> deque = new LinkedList<>();
    for (int i = 0; i < nodes.length; ++i) {
        String cur = nodes[i];
        while (!deque.isEmpty() && cur.equals("#") && deque.peekLast().equals(cur)) {
            deque.pollLast();
            if (deque.isEmpty()) return false;
            deque.pollLast();
        }
        deque.offerLast(cur);
    }
    return deque.size() == 1 && deque.pollLast().equals("#");
}


/*

Solution 2: use degree to represent the tree, which means the out degree of nodes as a whole
            at the beginning we have degree of 1, for each node, it occupies a degree where degree should minus one
            if the node is not empty, which will bring two more degrees
            check if degree is less than 0 during the way and it's 0 in the end
O(n),O(1)            

*/

public boolean isValidSerialization(String preorder) {
    String[] nodes = preorder.split(",");
    int degree = 1;
    for (String node : nodes) {
        degree--;
        if (degree < 0) return false;
        if (!node.equals("#")) degree += 2;
    }
    return degree == 0;
}
    
    


