
/*

In an infinite binary tree where every node has two children, the nodes are labelled in row order.
In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right,
while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.

Example 1:
Input: label = 14
Output: [1,3,4,14]

Example 2:
Input: label = 26
Output: [1,2,6,10,26]

*/

/*

Solution: calculate the depth of current node
          calculate the offset for current node which means offset+(the value of reversed row)=current node
          then (the value of reversed row)/2 is the parent of current node
O(logn),O(logn)          

*/

public List<Integer> pathInZigZagTree(int label) {
    List<Integer> ans = new LinkedList<>();
    ans.add(0, label);
    while (label > 1) {
        int depth = (int)(Math.log(label)/Math.log(2));
        int offset = (int)Math.pow(2, depth + 1) - 1 - label;
        label = ((int)Math.pow(2, depth) + offset) / 2;
        ans.add(0, label);
    }
    return ans;
}



