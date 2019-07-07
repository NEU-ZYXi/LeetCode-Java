
/*

Given a non-empty 2D matrix matrix and an integer k, 
find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:
Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2 
Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
             and 2 is the max number no larger than k (k = 2).

*/

/*

Solution: for each pair of rows, calculate the prefix sum of all columns
          in the current submatrix, use a treeset to find the max subsum so that curSum-subsum<=k, which is the ceiling
O(n^2mlogm),O(m)          

*/

public int maxSumSubmatrix(int[][] matrix, int k) {
    int n = matrix.length, m = matrix[0].length, ans = Integer.MIN_VALUE;
    for (int i = 0; i < n; ++i) {
        int[] sums = new int[m];
        for (int j = i; j < n; ++j) {
            for (int c = 0; c < m; ++c) {
                sums[c] += matrix[j][c];
            }
            TreeSet<Integer> set = new TreeSet<>();
            set.add(0);
            int curSum = 0;
            for (int sum : sums) {
                curSum += sum;
                Integer num = set.ceiling(curSum - k);
                if (num != null) {
                    ans = Math.max(ans, curSum - num);
                }
                set.add(curSum);
            }
        }
    }
    return ans;
}




