
/*

Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays, 
which have lengths L and M.  (For clarification, the L-length subarray could occur before or after the M-length subarray.)
Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) and either:
0 <= i < i + L - 1 < j < j + M - 1 < A.length, or
0 <= j < j + M - 1 < i < i + L - 1 < A.length.

Example 1:
Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.

Example 2:
Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
Output: 29
Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.

Example 3:
Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
Output: 31
Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.

*/

/*

Solution: Lsum, Msum are sum of subarray with L or M length respectively
          1. L array is before M array, accumulate Msum and Lsum for i>=M, track Lmax for Lsum
          2. M array is before L array, accumulate Lsum and Msum for i>=L, track Mmax for Msum
O(n),O(1)          

*/

public int maxSumTwoNoOverlap(int[] A, int L, int M) {
    int ans = 0, Lsum = 0, Lmax = 0, Msum = 0, Mmax = 0, n = A.length;
    for (int i = 0; i < n; ++i) {
        Msum += A[i];
        if (i >= M) {
            Msum -= A[i - M];
            Lsum += A[i - M];
        }
        if (i >= L + M) {
            Lsum -= A[i - M - L];
        }
        Lmax = Math.max(Lmax, Lsum);
        ans = Math.max(ans, Lmax + Msum);
    }
    Lsum = Lmax = Msum = Mmax = 0;
    for (int i = 0; i < n; ++i) {
        Lsum += A[i];
        if (i >= L) {
            Lsum -= A[i - L];
            Msum += A[i - L];
        }
        if (i >= L + M) {
            Msum -= A[i - M - L];
        }
        Mmax = Math.max(Mmax, Msum);
        ans = Math.max(ans, Lsum + Mmax);
    }
    return ans;
}




