
/*

Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
You may assume each number in the sequence is unique.

Consider the following binary search tree: 
     5
    / \
   2   6
  / \
 1   3
 
Example 1:
Input: [5,2,6,1,3]
Output: false

Example 2:
Input: [5,2,1,3,6]
Output: true

*/

/*

Solution 1: in preorder sequence, for each root node, the sequence should be [mid,small,large]
            for each value, if it's right node, use a deque to find its root node value
            then all the values after it should larger than the current root node value
O(n),O(n)          

*/

public boolean verifyPreorder(int[] preorder) {
    int min = -1;
    Deque<Integer> deque = new LinkedList<>();
    for (int val : preorder) {
        if (val < min) return false;
        while (!deque.isEmpty() && deque.peekLast() < val) min = deque.pollLast();
        deque.offerLast(val);
    }
    return true;
}


/*

Solution 2: use the original array and index to implement stack
O(n),O(1)

*/

public boolean verifyPreorder(int[] preorder) {
    int min = -1, i = 0;
    for (int val : preorder) {
        if (val < min) return false;
        while (i >= 1 && preorder[i - 1] < val) min = preorder[--i];
        preorder[i++] = val;
    }
    return true;
}



