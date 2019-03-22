
/*

Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Input: [[1,1],[-1,1]]
Output: true

Example 2:
Input: [[1,1],[-1,-1]]
Output: false

*/

/*

O(n),O(n)

*/

public boolean isReflected(int[][] points) {
    Set<String> set = new HashSet<>();
    int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
    for (int[] point : points) {
        set.add(point[0] + "," + point[1]);
        left = Math.min(left, point[0]);
        right = Math.max(right, point[0]);
    }
    int mid = left + right;
    for (int[] point : points) {
        if (!set.contains((mid - point[0]) + "," + point[1])) return false;
    }
    return true;
}




