
/*

Given an n-ary tree, return the postorder traversal of its nodes' values.

*/

/*

Solution 1: recursive
O(n),O(n)

*/

public List<Integer> postorder(Node root) {
    List<Integer> ans = new ArrayList<>();
    dfs(ans, root);
    return ans;
}

private void dfs(List<Integer> ans, Node root) {
    if (root == null) {
        return;
    }
    for (Node child : root.children) {
        dfs(ans, child);
    }
    ans.add(root.val);
}


/*

Solution 2: iterative
O(n),O(n)

*/

public List<Integer> postorder(Node root) {
    List<Integer> ans = new LinkedList<>();
    if (root == null) {
        return ans;
    }
    Deque<Node> deque = new ArrayDeque<>();
    deque.offerLast(root);
    while (!deque.isEmpty()) {
        Node cur = deque.pollLast();
        ans.add(0, cur.val);
        for (Node child : cur.children) {
            deque.offerLast(child);
        }
    }
    return ans;
}




