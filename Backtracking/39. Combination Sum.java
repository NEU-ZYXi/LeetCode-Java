
/*

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

*/

/*

O(n^m),O(m), where m is the average size of each list in the ans, which is also the depth of backtracking process

*/

public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
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
        tmp.add(candidates[i]);
        dfs(ans, tmp, candidates, target - candidates[i], i);
        tmp.remove(tmp.size() - 1);
    }
}





