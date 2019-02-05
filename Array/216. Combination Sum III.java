
/*

Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:
All numbers will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

*/

/*

O(9^k),O(k)

*/

public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), k, n, 1);
    return ans;
}

private void dfs(List<List<Integer>> ans, List<Integer> tmp, int k, int n, int num) {
    if (tmp.size() > k) return;
    else if (tmp.size() == k && n == 0) {
        ans.add(new ArrayList<>(tmp));
        return;
    }
    for (int i = num; i <= 9; ++i) {
        tmp.add(i);
        dfs(ans, tmp, k, n - i, i + 1);
        tmp.remove(tmp.size() - 1);
    }
}



