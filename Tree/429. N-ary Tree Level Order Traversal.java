
/*

Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
We should return its level order traversal:
[
     [1],
     [3,2,4],
     [5,6]
]

*/

/*

O(n),O(n)

*/

public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    Node cur = root;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(cur);
    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            cur = queue.poll();
            tmp.add(cur.val);
            for (Node child : cur.children) {
                if (child != null) queue.offer(child);
            }
        }
        ans.add(tmp);
    }
    return ans;
}





