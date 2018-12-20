
/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

*/

/*

Solution 1. since all the elements are strictly increasing, use binary search
O(lognm),O(1)

*/

public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) return false;
    int n = matrix.length, m = matrix[0].length;
    int l = 0, r = n * m - 1;
    while (l <= r) {
        int mid = (l + r) / 2;
        int midVal = matrix[mid / m][mid % m];
        if (midVal == target) return true;
        if (midVal > target) r = mid - 1;
        else l = mid + 1;
    }
    return false;
}


/*

Solution 2. search from top right, move left or down based on the current element compared to target
O(n+m),O(1)

*/

public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) return false;
    int n = matrix.length, m = matrix[0].length;
    int i = 0, j = m - 1;
    while (i < n && j >= 0) {
        if (matrix[i][j] == target) return true;
        if (matrix[i][j] > target) j--;
        else i++;
    }
    return false;
}




