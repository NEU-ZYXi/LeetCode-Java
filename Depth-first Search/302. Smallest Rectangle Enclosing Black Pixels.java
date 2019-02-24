
/*

An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. 
The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. 
Given the location (x, y) of one of the black pixels, return the area of the smallest rectangle that encloses all black pixels.

Example:
Input:
[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2
Output: 6

*/

/*

Solution 1: use DFS to visit all the black pixels and find the four borders
O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
public int minArea(char[][] image, int x, int y) {
    if (image.length == 0) return 0;
    int n = image.length, m = image[0].length;
    int[] ans = new int[4];
    ans[0] = Integer.MAX_VALUE;
    ans[1] = Integer.MIN_VALUE;
    ans[2] = Integer.MAX_VALUE;
    ans[3] = Integer.MIN_VALUE;
    dfs(ans, image, x, y);
    return (ans[1] - ans[0] + 1) * (ans[3] - ans[2] + 1);
}

private void dfs(int[] ans, char[][] image, int x, int y) {
    int n = image.length, m = image[0].length;
    ans[0] = Math.min(ans[0], y);
    ans[1] = Math.max(ans[1], y);
    ans[2] = Math.min(ans[2], x);
    ans[3] = Math.max(ans[3], x);
    image[x][y] = '0';
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (0 <= nx && nx < n && 0 <= ny && ny < m && image[nx][ny] == '1') dfs(ans, image, nx, ny);
    }
}


/*

Solution 2: use binary search to find the four borders
O(mlogn+nlogm),O(1)

*/

public int minArea(char[][] image, int x, int y) {
    if (image.length == 0) return 0;
    int n = image.length, m = image[0].length;
    int left = left(image, 0, x, true);
    int right = right(image, x, n - 1, true);
    int top = left(image, 0, y, false);
    int bottom = right(image, y, m - 1, false);
    return (right - left + 1) * (bottom - top + 1);
}

private int left(char[][] image, int l, int r, boolean horizontal) {
    while (l < r) {
        int mid = (l + r) / 2;
        if (hasBlack(image, mid, horizontal)) r = mid;
        else l = mid + 1;
    }
    return l;
}

private int right(char[][] image, int l, int r, boolean horizontal) {
    while (l < r) {
        int mid = (l + r) / 2 + 1;
        if (hasBlack(image, mid, horizontal)) l = mid;
        else r = mid - 1;
    }
    return r;
}

private boolean hasBlack(char[][] image, int mid, boolean horizontal) {
    if (horizontal) {
        for (int j = 0; j < image[0].length; ++j) {
            if (image[mid][j] == '1') return true;
        }
    } else {
        for (int i = 0; i < image.length; ++i) {
            if (image[i][mid] == '1') return true;
        }
    }
    return false;
}




