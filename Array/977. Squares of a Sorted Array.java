
/*

Given an array of integers A sorted in non-decreasing order, 
return an array of the squares of each number, also in sorted non-decreasing order. 

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]

*/

/*

O(n),O(n)

*/

public int[] sortedSquares(int[] A) {
    int n = A.length, i = 0, j = n - 1;
    int[] ans = new int[n];
    for (int k = n - 1; k >= 0; --k) {
        if (Math.abs(A[i]) < Math.abs(A[j])) {
            ans[k] = A[j] * A[j];
            j--;
        } else {
            ans[k] = A[i] * A[i];
            i++;
        }
    }
    return ans;
}




