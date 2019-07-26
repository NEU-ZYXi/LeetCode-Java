
/*

If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.
For each integer in this list:
The hundreds digit represents the depth D of this node, 1 <= D <= 4.
The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. 
The position is the same as that in a full binary tree.
The units digit represents the value V of this node, 0 <= V <= 9.
Given a list of ascending three-digits integers representing a binary tree with the depth smaller than 5, y
ou need to return the sum of all paths from the root towards the leaves.

Example 1:
Input: [113, 215, 221]
Output: 12
Explanation: 
The tree that the list represents is:
    3
   / \
  5   1
The path sum is (3 + 5) + (3 + 1) = 12.
 
Example 2:
Input: [113, 221]
Output: 4
Explanation: 
The tree that the list represents is: 
    3
     \
      1
The path sum is (3 + 1) = 4.

*/

/*

Solution: use a map to represent a tree, and first two digits as the root position
          DFS to traverse tree to accumulate sum of different paths
O(n),O(n)          

*/

public int pathSum(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
        int key = num / 10;
        int value = num % 10;
        map.put(key, value);
    }
    return dfs(map, nums[0] / 10, 0);
}

private int dfs(Map<Integer, Integer> map, int root, int prev) {
    if (!map.containsKey(root)) {
        return 0;
    }
    int depth = root / 10, pos = root % 10, val = map.get(root);
    int left = (depth + 1) * 10 + 2 * pos - 1;
    int right = (depth + 1) * 10 + 2 * pos;
    int cur = prev + val;
    if (!map.containsKey(left) && !map.containsKey(right)) {
        return cur;
    }
    return dfs(map, left, cur) + dfs(map, right, cur);
}



