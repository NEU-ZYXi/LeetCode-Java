
/*

Given a binary tree, write a function to get the maximum width of the given tree. 
The width of a tree is the maximum width among all levels.
The binary tree has the same structure as a full binary tree, but some nodes are null.
The width of one level is defined as the length between the end-nodes 
(the leftmost and rightmost non-null nodes in the level,
where the null nodes between the end-nodes are also counted into the length calculation).

Example 1:
Input: 
           1
         /   \
        3     2
       / \     \  
      5   3     9 
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

Example 2:
Input: 
          1
         /  
        3    
       / \       
      5   3     
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Example 3:
Input: 
          1
         / \
        3   2 
       /        
      5      
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).

Example 4:
Input: 
          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).

*/

/*

O(n),O(n)

*/

public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int ans = 1;
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> idx = new LinkedList<>();
    queue.offer(root);
    idx.offer(0);
    while (!queue.isEmpty()) {
        int sz = queue.size(), left = 0, right = 0;
        for (int i = 0; i < sz; ++i) {
            TreeNode cur = queue.poll();
            int curIdx = idx.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                idx.offer(curIdx * 2);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                idx.offer(curIdx * 2 + 1);
            }
            if (i == 0) {
                left = curIdx;
            }
            if (i == sz - 1) {
                right = curIdx;
            }
        }
        ans = Math.max(ans, right - left + 1);
    }
    return ans;
}



