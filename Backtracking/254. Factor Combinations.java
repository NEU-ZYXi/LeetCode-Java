
/*

Numbers can be regarded as product of its factors. For example,
8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:
You may assume that n is always positive.
Factors should be greater than 1 and less than n.

Example 1:
Input: 1
Output: []

Example 2:
Input: 37
Output:[]

Example 3:
Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]

Example 4:
Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]

*/

/*

O((sqrt(n))^(n/2)),O(n/2)

*/

public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), n, 2);
    return ans;
}

private void dfs(List<List<Integer>> ans, List<Integer> tmp, int n, int start) {
    for (int i = start; i <= Math.sqrt(n); ++i) {
        if (n % i == 0) {
            tmp.add(i);
            tmp.add(n / i);
            ans.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            dfs(ans, tmp, n / i, i);
            tmp.remove(tmp.size() - 1);
        }
    }
}




