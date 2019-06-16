
/*

In an array A containing only 0s and 1s, a K-bit flip consists of choosing a (contiguous) subarray of length K 
and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.
Return the minimum number of K-bit flips required so that there is no 0 in the array.  If it is not possible, return -1.

Example 1:
Input: A = [0,1,0], K = 1
Output: 2
Explanation: Flip A[0], then flip A[2].

Example 2:
Input: A = [1,1,0], K = 2
Output: -1
Explanation: No matter how we flip subarrays of size 2, we can't make the array become [1,1,1].

Example 3:
Input: A = [0,0,0,1,0,1,1,0], K = 3
Output: 3
Explanation:
Flip A[0],A[1],A[2]: A becomes [1,1,1,1,0,1,1,0]
Flip A[4],A[5],A[6]: A becomes [1,1,1,1,1,0,0,0]
Flip A[5],A[6],A[7]: A becomes [1,1,1,1,1,1,1,1]

*/

/*

Solution 1: for left most number, greedily flip to make it '1' because the order of flips doesn't matter
O(nk),O(1)

*/

public int minKBitFlips(int[] A, int K) {
    int ans = 0, n = A.length;
    for (int i = 0; i < n; ++i) {
        if (A[i] == 0) {
            if (i + K > n) {
                return -1;
            }
            flip(A, K, i);
            ans++;
        }
    }
    return ans;
}

private void flip(int[] A, int K, int i) {
    for (int j = i; j < i + K; ++j) {
        A[j] ^= 1;
    }
}


/*

Solution 2: use a flag to track whether '0' or '1' needs to be flipped, and an array for flipped index
            if flag=A[i] which means we need to flip current element
            for i>=K, flip back the flag one more time because A[i-K] is not in the flipped subarray
O(n),O(n)            

*/

public int minKBitFlips(int[] A, int K) {
    int ans = 0, n = A.length, isFlipped = 0;
    int[] flipped = new int[n];
    for (int i = 0; i < n; ++i) {
        if (i >= K) {
            isFlipped ^= flipped[i - K];
        }
        if (isFlipped == A[i]) {
            if (i + K > n) {
                return -1;
            }
            flipped[i] = 1;
            isFlipped ^= 1;
            ans++;
        }
    }
    return ans;
}




