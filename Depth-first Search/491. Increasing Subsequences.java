
/*

Given an integer array, your task is to find all the different possible increasing subsequences of the given array, 
and the length of an increasing subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

*/

/*

O(2^n),O(n)

*/

public List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), nums, 0);
    return ans;
}

private void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int idx) {
    if (tmp.size() >= 2) {
        ans.add(new ArrayList<>(tmp));
    }
    Set<Integer> vis = new HashSet<>();
    for (int i = idx; i < nums.length; ++i) {
        if (!vis.contains(nums[i]) && (tmp.size() == 0 || tmp.get(tmp.size() - 1) <= nums[i])) {
            tmp.add(nums[i]);
            vis.add(nums[i]);
            dfs(ans, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}




