
/*

Given an n-ary tree, return the preorder traversal of its nodes' values.

*/

/*

Solution 1: recursive
O(n),O(n)

*/

public List<Integer> preorder(Node root) {
    List<Integer> ans = new ArrayList<>();
    dfs(ans, root);
    return ans;
}

private void dfs(List<Integer> ans, Node root) {
    if (root == null) {
        return;
    }
    ans.add(root.val);
    for (Node child : root.children) {
        dfs(ans, child);
    }
}


/*

Solution 2: iterative
O(n),O(n)

*/

public List<Integer> preorder(Node root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    Deque<Node> deque = new ArrayDeque<>();
    deque.offerLast(root);
    while (!deque.isEmpty()) {
        Node cur = deque.pollLast();
        ans.add(cur.val);
        for (int i = cur.children.size() - 1; i >= 0; --i) {
            deque.offerLast(cur.children.get(i));
        }
    }
    return ans;
}



