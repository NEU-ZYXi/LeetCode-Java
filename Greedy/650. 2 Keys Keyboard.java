
/*

Initially on a notepad only one character 'A' is present. 
You can perform two operations on this notepad for each step:
Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. 
Output the minimum number of steps to get n 'A'.

Example 1:
Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.

*/

/*

Solution 1: dp[i] means the min step to get n
            dp[i]=min(dp[j]+i/j) if we paste j for ((i/j)-1) times plus one copy to get i
O(n^2),O(n)

*/

public int minSteps(int n) {
    int[] dp = new int[n + 1];
    for (int i = 2; i <= n; ++i) {
        dp[i] = Integer.MAX_VALUE;
        for (int j = 1; j < i; ++j) {
            if (i % j == 0) {
                dp[i] = Math.min(dp[i], dp[j] + i / j);
            }
        }
    }
    return dp[n];
}


/*

Solution 2: greedily cut off current number n with one copy and (i-1) times paste to get n
O(nlogn),O(1)

*/

public int minSteps(int n) {
    int ans = 0;
    for (int i = 2; i <= n; ++i) {
        while (n % i == 0) {
            n /= i;
            ans += i;
        }
    }
    return ans;
}



