
/*

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/

/*

O(2^n),O(n)

*/

public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    dfs(ans, new ArrayList<>(), nums, 0);
    return ans;
}

private void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int idx) {
    ans.add(new ArrayList<>(tmp));
    for (int i = idx; i < nums.length; ++i) {
        if (i > idx && nums[i] == nums[i - 1]) continue;
        tmp.add(nums[i]);
        dfs(ans, tmp, nums, i + 1);
        tmp.remove(tmp.size() - 1);
    }
}




