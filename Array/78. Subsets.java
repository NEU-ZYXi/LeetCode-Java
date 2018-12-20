
/*

Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

/*

Solution 1. backtracking method
O(2^n),O(n)

*/

public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), nums, 0);
    return ans;
}

private void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int idx) {
    ans.add(new ArrayList<>(tmp));
    for (int i = idx; i < nums.length; ++i) {
        tmp.add(nums[i]);
        dfs(ans, tmp, nums, i + 1);
        tmp.remove(tmp.size() - 1);
    }
}


/*

Solution 2. bit manipulation
use bits to represent whether the ith element is taken or not, we have j=2^n possible subsets in total
for each one, if ith bit is '1' which means (j>>i)&1=1, the ith element is in this subset
O(n*2^n),O(1)

*/

public List<List<Integer>> subsets(int[] nums) {
    int n = nums.length, m = (int)Math.pow(2, n);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < m; ++i) ans.add(new ArrayList<>());
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (((j >> i) & 1) == 1) ans.get(j).add(nums[i]);
        }
    }
    return ans;
}



