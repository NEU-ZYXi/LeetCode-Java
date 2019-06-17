
/*

Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
Return the number of permutations of A that are squareful.  
Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].

Example 1:
Input: [1,17,8]
Output: 2
Explanation: 
[1,8,17] and [17,8,1] are the valid permutations.

Example 2:
Input: [2,2,2]
Output: 1

*/

/*

Solution: backtrack for each element, and use vis[] similar to Permutation II, sort array first to jump over duplicates
O(n^n),O(n)

*/

public int numSquarefulPerms(int[] A) {
    int n = A.length;
    Arrays.sort(A);
    boolean[] vis = new boolean[n];
    return dfs(A, new ArrayList<>(), vis, 0);
}

private int dfs(int[] A, List<Integer> tmp, boolean[] vis, int cur) {
    if (tmp.size() == A.length) {
        cur++;
        return cur;
    }
    for (int i = 0; i < A.length; ++i) {
        if (vis[i] || (i > 0 && A[i] == A[i - 1] && !vis[i - 1]) || (tmp.size() != 0 && !isSquare(tmp.get(tmp.size() - 1) + A[i]))) {
            continue;
        }
        tmp.add(A[i]);
        vis[i] = true;
        cur = dfs(A, tmp, vis, cur);
        vis[i] = false;
        tmp.remove(tmp.size() - 1);
    } 
    return cur;
}

private boolean isSquare(int n) {
    return (int)Math.sqrt(n) == Math.sqrt(n);
}




