
/*

Given a collection of distinct integers, return all possible permutations.

Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

/*

O(n!),O(n)

*/

public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), nums, new HashSet<>());
    return ans;
}

private void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] nums, Set<Integer> vis) {
    if (tmp.size() == nums.length) {
        ans.add(new ArrayList<>(tmp));
        return;
    }
    for (int i = 0; i < nums.length; ++i) {
        if (!vis.contains(nums[i])) {
            vis.add(nums[i]);
            tmp.add(nums[i]);
            dfs(ans, tmp, nums, vis);
            tmp.remove(tmp.size() - 1);
            vis.remove(nums[i]);
        }
    }
}



