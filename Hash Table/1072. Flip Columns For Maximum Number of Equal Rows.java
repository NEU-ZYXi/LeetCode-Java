
/*

Given a matrix consisting of 0s and 1s, we may choose any number of columns in the matrix and flip every cell in that column.
Flipping a cell changes the value of that cell from 0 to 1 or from 1 to 0.
Return the maximum number of rows that have all values equal after some number of flips.

Example 1:
Input: [[0,1],[1,1]]
Output: 1
Explanation: After flipping no values, 1 row has all values equal.

Example 2:
Input: [[0,1],[1,0]]
Output: 2
Explanation: After flipping values in the first column, both rows have equal values.

Example 3:
Input: [[0,0,0],[0,0,1],[1,1,0]]
Output: 2
Explanation: After flipping values in the first two columns, the last two rows have equal values.

*/

/*

Solution: flip same row or totally different row can form equal rows, count the two kinds of rows and find max one
O(nm),O(n)

*/

public int maxEqualRowsAfterFlips(int[][] matrix) {
    Map<String, Integer> map = new HashMap<>();
    int ans = 0;
    for (int[] row : matrix) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int val : row) {
            sb1.append(val);
            sb2.append(1 - val);
        }
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        map.put(s1, map.getOrDefault(s1, 0) + 1);
        map.put(s2, map.getOrDefault(s2, 0) + 1);
    }
    for (int val : map.values()) {
        ans = Math.max(ans, val);
    }
    return ans;
}



