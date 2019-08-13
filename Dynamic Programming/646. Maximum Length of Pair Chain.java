
/*

You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. 
Chain of pairs can be formed in this fashion.
Given a set of pairs, find the length longest chain which can be formed. 
You needn't use up all the given pairs. You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]

*/

/*

Solution 1: sort and greedily pick the pair that can form a longer chain
O(nlogn),O(1)

*/

public int findLongestChain(int[][] pairs) {
    int n = pairs.length, ans = 1, prev = 0;
    Arrays.sort(pairs, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    });
    for (int i = 1; i < n; ++i) {
        if (pairs[prev][1] < pairs[i][0]) {
            ans++;
            prev = i;
        }
    }
    return ans;
}


/*

Solution 2: sort and then DP to find longest chain
            dp[i] means the number of current longest chain
            dp[i]=max(dp[j]+1) for 0<=j<i if pairs[i] can follow pairs[j]
O(n^2),O(n)            

*/

public int findLongestChain(int[][] pairs) {
    int n = pairs.length;
    Arrays.sort(pairs, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    });
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < i; ++j) {
            if (pairs[j][1] < pairs[i][0]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
    return dp[n - 1];
}



