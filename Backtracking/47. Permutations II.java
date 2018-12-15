
/*

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

/*

Solution: 排序去重，记录i位置是否已被加入结果
          1. 若i位已在结果中，则跳过
          2. 若a[i]==a[i-1]且i-1不在结果中，由于i-1的结果已被访问过，则i位不再继续访问，跳过
O(n!),O(n)          

*/

public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    dfs(ans, new ArrayList<>(), nums, new HashSet<>());
    return ans;
}

private void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] nums, Set<Integer> vis) {
    if (tmp.size() == nums.length) {
        ans.add(new ArrayList<>(tmp));
        return;
    }
    for (int i = 0; i < nums.length; ++i) {
        if (vis.contains(i)) continue;
        if (i > 0 && nums[i] == nums[i - 1] && !vis.contains(i - 1)) continue;
        tmp.add(nums[i]);
        vis.add(i);
        dfs(ans, tmp, nums, vis);
        vis.remove(i);
        tmp.remove(tmp.size() - 1);
    }
}




