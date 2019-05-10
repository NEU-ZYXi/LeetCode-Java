
/*

Given an array A of integers, return true if and only if it is a valid mountain array.
Recall that A is a mountain array if and only if:
A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[B.length - 1]
 
Example 1:
Input: [2,1]
Output: false

Example 2:
Input: [3,5,5]
Output: false

Example 3:
Input: [0,3,2,1]
Output: true

*/

/*

O(n),O(1)

*/

public boolean validMountainArray(int[] A) {
    int n = A.length;
    if (n <= 2 || A[0] >= A[1]) return false;
    boolean up = true;
    for (int i = 2; i < n; ++i) {
        if (A[i] < A[i - 1]) up = false;
        else if (A[i] == A[i - 1] || !up) return false;
    }
    return !up;
}




