
/*

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

*/

/*

Solution 1: O(n),O(n)

*/

public List<Double> averageOfLevels(TreeNode root) {
    List<Double> ans = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        double sum = 0;
        for (int i = 0; i < size; ++i) {
            TreeNode cur = queue.poll();
            sum += cur.val;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        ans.add(sum / size);
    }
    return ans;
}


/*

Solution 2: O(n),O(n)

*/

class Node {
    private long sum;
    private int cnt;

    public Node(long sum, int cnt) {
        this.sum = sum;
        this.cnt = cnt;
    }
}

public List<Double> averageOfLevels(TreeNode root) {
    List<Double> ans = new ArrayList<>();
    List<Node> nodes = new ArrayList<>();
    dfs(root, nodes, 0);
    for (int i = 0; i < nodes.size(); ++i) {
        ans.add((double)nodes.get(i).sum / nodes.get(i).cnt);
    }
    return ans;
}

private void dfs(TreeNode root, List<Node> nodes, int depth) {
    if (root == null) {
        return;
    }
    if (depth == nodes.size()) {
        nodes.add(new Node(root.val, 1));
    } else {
        nodes.get(depth).sum += root.val;
        nodes.get(depth).cnt++;
    }
    dfs(root.left, nodes, depth + 1);
    dfs(root.right, nodes, depth + 1);
}




