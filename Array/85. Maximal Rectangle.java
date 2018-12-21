
/*

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:
Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6

*/

/*

O(nm),O(m)

*/

public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) return 0;
    int ans = 0, n = matrix.length, m = matrix[0].length;
    int[] heights = new int[m];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (matrix[i][j] == '1') heights[j]++;
            else heights[j] = 0;
        }
        ans = Math.max(ans, largestRectangleArea(heights));
    }
    return ans;
}

private int largestRectangleArea(int[] heights) {
    int ans = 0, n = heights.length;
    int[] left = new int[n];
    int[] right = new int[n];
    left[0] = -1;
    right[n - 1] = n;
    for (int i = 1; i < n; ++i) {
        int j = i - 1;
        while (j > -1 && heights[j] >= heights[i]) j = left[j];
        left[i] = j;
    }
    for (int i = n - 2; i >= 0; --i) {
        int j = i + 1;
        while (j < n && heights[j] >= heights[i]) j = right[j];
        right[i] = j;
    }
    for (int i = 0; i < n; ++i) ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
    return ans;
}




