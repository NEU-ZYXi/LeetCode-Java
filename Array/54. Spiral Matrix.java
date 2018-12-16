
/*

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

*/

/*

O(nm),O(1)

*/

public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    if (matrix.length == 0) 
        return ans;
    int minRow = 0, maxRow = matrix.length - 1, minCol = 0, maxCol = matrix[0].length - 1;
    while (minRow <= maxRow && minCol <= maxCol) {
        for (int i = minCol; i <= maxCol; ++i) ans.add(matrix[minRow][i]);
        minRow++;
        for (int i = minRow; i <= maxRow; ++i) ans.add(matrix[i][maxCol]);
        maxCol--;
        if (minRow > maxRow || minCol > maxCol) break;
        for (int i = maxCol; i >= minCol; --i) ans.add(matrix[maxRow][i]);
        maxRow--;
        for (int i = maxRow; i >= minRow; --i) ans.add(matrix[i][minCol]);
        minCol++;
    }
    return ans;
}



