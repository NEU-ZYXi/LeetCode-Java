
/*

Given a collection of candidate numbers (candidates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

*/

/*

Solution: sort the array to avoid the elements with the same value being used again, which is to avoid duplicate results
O(n^m),O(m), where m is the average size of each list in ans, which is also the depth of backtracking process

*/

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(ans, new ArrayList<>(), candidates, target, 0);
    return ans;
}

private void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int idx) {
    if (target < 0) return;
    if (target == 0) {
        ans.add(new ArrayList<>(tmp));
        return;
    }
    for (int i = idx; i < candidates.length; ++i) {
        if (i > idx && candidates[i] == candidates[i - 1]) continue;
        tmp.add(candidates[i]);
        dfs(ans, tmp, candidates, target - candidates[i], i + 1);
        tmp.remove(tmp.size() - 1);
    }
}




