
/*

Given a picture consisting of black and white pixels, find the number of black lonely pixels.
The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.
A black lonely pixel is character 'B' that located at a specific position 
where the same row and same column don't have any other black pixels.

Example:
Input: 
[['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]
Output: 3
Explanation: All the three 'B's are black lonely pixels.

*/

/*

O(nm),O(n+m)

*/

public int findLonelyPixel(char[][] picture) {
    int ans = 0, n = picture.length, m = picture[0].length;
    int[] row = new int[n], col = new int[m];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (picture[i][j] == 'B') {
                row[i]++;
                col[j]++;
            }
        }
    }
    for (int i = 0; i < n; ++i) {
        if (row[i] == 1) {
            for (int j = 0; j < m; ++j) {
                if (picture[i][j] == 'B') {
                    if (col[j] == 1) {
                        ans++;
                    }
                    break;
                }
            }
        }
    }
    return ans;
}




