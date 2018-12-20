
/*

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

/*

O(n^k),O(k)

*/

public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), n, k, 1);
    return ans;
}

private void dfs(List<List<Integer>> ans, List<Integer> tmp, int n, int k, int idx) {
    if (tmp.size() == k) {
        ans.add(new ArrayList<>(tmp));
        return;
    }
    for (int i = idx; i <= n; ++i) {
        tmp.add(i);
        dfs(ans, tmp, n, k, i + 1);
        tmp.remove(tmp.size() - 1);
    }
}





