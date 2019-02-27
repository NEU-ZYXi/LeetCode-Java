
/*

Write a program to find the nth super ugly number.
Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

Example:
Input: n = 12, primes = [2,7,13,19]
Output: 32 
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
             super ugly numbers given primes = [2,7,13,19] of size 4.

*/

/*

Solution: ans[i] is the ith ugly number, nums[j] means the index of next element can be multiplied with primes[j]
          find the minimum for each primes[j]*ans[nums[j]] to get the next element
          and for all the primes[j] that can form the next element, move their index nums[j] forward
O(nm),O(n+m)          

*/

public int nthSuperUglyNumber(int n, int[] primes) {
    int[] ans = new int[n];
    int m = primes.length;
    int[] nums = new int[m];
    ans[0] = 1;
    for (int i = 1; i < n; ++i) {
        ans[i] = Integer.MAX_VALUE;
        for (int j = 0; j < m; ++j) ans[i] = Math.min(ans[i], primes[j] * ans[nums[j]]);
        for (int j = 0; j < m; ++j) {
            if (ans[i] == primes[j] * ans[nums[j]]) nums[j]++;
        }
    }
    return ans[n - 1];
}




