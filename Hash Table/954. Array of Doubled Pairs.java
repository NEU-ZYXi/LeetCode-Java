
/*

Given an array of integers A with even length, 
return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.

Example 1:
Input: [3,1,3,6]
Output: false

Example 2:
Input: [2,1,2,6]
Output: false

Example 3:
Input: [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].

Example 4:
Input: [1,2,4,16,8,4]
Output: false

*/

/*

Solution: sort and use two pointers to check A[i]=2*A[j] or A[j]=2*A[i] and mark the paired index
O(nlogn),O(n)

*/

public boolean canReorderDoubled(int[] A) {
    int n = A.length;
    Arrays.sort(A);
    boolean[] pairs = new boolean[n];
    for (int i = 0, j = 1; i < n; ++i) {
        if (!pairs[i]) {
            while (j < n && A[j] != 2 * A[i] && A[i] != 2 * A[j]) {
                j++;
            }
            if (j == n) {
                return false;
            }
            pairs[j++] = true;
        }
    }
    return true;
}




