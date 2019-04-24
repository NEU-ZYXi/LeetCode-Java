
/*

Given an integer n, return 1 - n in lexicographical order.
For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

*/

/*

O(10^n),O(n) where n is the number of digits not the number itself

*/

public List<Integer> lexicalOrder(int n) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 1; i < 10; ++i) dfs(ans, i, n);
    return ans;
}

private void dfs(List<Integer> ans, int cur, int n) {
    if (cur > n) return;
    ans.add(cur);
    for (int i = 0; i < 10; ++i) dfs(ans, cur * 10 + i, n);
}




