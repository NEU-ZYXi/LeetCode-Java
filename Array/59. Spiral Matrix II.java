
/*

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/

/*

O(n*n),O(1)

*/

public int[][] generateMatrix(int n) {
    int[][] ans = new int[n][n];
    int minRow = 0, maxRow = n - 1, minCol = 0, maxCol = n - 1, cur = 1;
    while (cur <= n * n) {
        for (int i = minCol; i <= maxCol; ++i) ans[minRow][i] = cur++;
        minRow++;
        for (int i = minRow; i <= maxRow; ++i) ans[i][maxCol] = cur++;
        maxCol--;
        for (int i = maxCol; i >= minCol; --i) ans[maxRow][i] = cur++;
        maxRow--;
        for (int i = maxRow; i >= minRow; --i) ans[i][minCol] = cur++;
        minCol++;
    }
    return ans;
}




