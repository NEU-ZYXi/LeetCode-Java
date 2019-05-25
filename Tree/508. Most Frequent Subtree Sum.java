
/*

Given the root of a tree, you are asked to find the most frequent subtree sum. 
The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node 
(including the node itself). 
So what is the most frequent subtree sum value? 
If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:
  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.

Examples 2
Input:
  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.

*/

/*

Solution: use post order traversal to get subtree sum
O(n),O(n)

*/

public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    dfs(root, map);
    List<Integer> ans = new ArrayList<>();
    int max = 0;
    for (int val : map.values()) {
        max = Math.max(max, val);
    }
    for (int key : map.keySet()) {
        if (map.get(key) == max) {
            ans.add(key);
        }
    }
    int[] ret = new int[ans.size()];
    for (int i = 0; i < ret.length; ++i) {
        ret[i] = ans.get(i);
    }
    return ret;
}

private int dfs(TreeNode root, Map<Integer, Integer> map) {
    if (root == null) {
        return 0;
    }
    int left = dfs(root.left, map);
    int right = dfs(root.right, map);
    int sum = root.val + left + right;
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    return sum;
}




