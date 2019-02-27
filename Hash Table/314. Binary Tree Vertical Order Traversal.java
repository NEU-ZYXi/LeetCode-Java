
/*

Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
If two nodes are in the same row and column, the order should be from left to right.

Examples 1:
Input: [3,9,20,null,null,15,7]
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 
Output:
[
  [9],
  [3,15],
  [20],
  [7]
]

Examples 2:
Input: [3,9,8,4,0,1,7]
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 
Output:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]

Examples 3:
Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
Output:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]

*/

/*

Solution: use queues for tree nodes and columns, for each node, columns of left and right nodes are col-1 and col+1
O(n),O(n)

*/

public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    Map<Integer, List<Integer>> map = new HashMap<>();
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> cols = new LinkedList<>();
    queue.offer(root);
    cols.offer(0);
    while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();
        int col = cols.poll();
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(cur.val);
        min = Math.min(min, col);
        max = Math.max(max, col);
        if (cur.left != null) {
            queue.offer(cur.left);
            cols.offer(col - 1);
        }
        if (cur.right != null) {
            queue.offer(cur.right);
            cols.offer(col + 1);
        }
    }
    for (int i = min; i <= max; ++i) ans.add(map.get(i));
    return ans;
}




