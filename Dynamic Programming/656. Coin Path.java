
/*

Given an array A (index starts at 1) consisting of N integers: A1, A2, ..., AN and an integer B. 
The integer B denotes that from any place (suppose the index is i) in the array A, 
you can jump to any one of the place in the array A indexed i+1, i+2, …, i+B if this place can be jumped to.
Also, if you step on the index i, you have to pay Ai coins. 
If Ai is -1, it means you can’t jump to the place indexed i in the array.
Now, you start from the place indexed 1 in the array A, and your aim is to reach the place indexed N using the minimum coins. 
You need to return the path of indexes (starting from 1 to N) in the array 
you should take to get to the place indexed N using minimum coins.
If there are multiple paths with the same cost, return the lexicographically smallest such path.
If it's not possible to reach the place indexed N then you need to return an empty array.

Example 1:
Input: [1,2,4,-1,2], 2
Output: [1,3,5]
 
Example 2:
Input: [1,2,4,-1,2], 1
Output: []

*/

/*

Solution: dp[i] means the min cost for A[i...n-1] because we need smallest lexicographical order so start from the end
          dp[i]=min(dp[j])+A[i] for i<j<=i+B if A[i] and A[j] is not equal to '-1'
          then rebuild the array by find the position for tot=dp[i]
O(nB),O(n)          

*/

public List<Integer> cheapestJump(int[] A, int B) {
    List<Integer> ans = new ArrayList<>();
    int n = A.length;
    int[] dp = new int[n];
    if (A[0] == -1 || A[n - 1] == -1) {
        return ans;
    }
    Arrays.fill(dp, -1);
    dp[n - 1] = A[n - 1];
    for (int i = n - 2; i >= 0; --i) {
        if (A[i] == -1) {
            continue;
        }
        int min = Integer.MAX_VALUE;
        for (int j = Math.min(n - 1, i + B); j > i; --j) {
            if (A[j] != -1) {
                min = Math.min(min, dp[j]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return ans;
        }
        dp[i] = A[i] + min;
    }
    int tot = dp[0];
    for (int i = 0; i < n; ++i) {
        if (dp[i] == tot) {
            ans.add(i + 1);
            tot -= A[i];
        }
    }
    return ans;
}




