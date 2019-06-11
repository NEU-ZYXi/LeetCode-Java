
/*

Given a set of points in the xy-plane, determine the minimum area of any rectangle formed from these points, 
with sides not necessarily parallel to the x and y axes.
If there isn't any rectangle, return 0.

Example 1:
Input: [[1,2],[2,1],[1,0],[0,1]]
Output: 2.00000
Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2.

Example 2:
Input: [[0,1],[2,1],[1,1],[1,0],[2,0]]
Output: 1.00000
Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.

Example 3:
Input: [[0,3],[1,2],[3,1],[1,3],[2,1]]
Output: 0
Explanation: There is no possible rectangle to form from these points.

Example 4:
Input: [[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
Output: 2.00000
Explanation: The minimum area rectangle occurs at [2,1],[2,3],[3,3],[3,1], with an area of 2.

*/

/*

O(n^3),O(n)

*/

public double minAreaFreeRect(int[][] points) {
    double ans = Double.MAX_VALUE;
    Set<String> set = new HashSet<>();
    for (int[] point : points) {
        set.add(point[0] + "," + point[1]);
    }
    for (int[] p1 : points) {
        for (int[] p2 : points) {
            if (p1[0] == p2[0] && p1[1] == p2[1]) {
                continue;
            }
            for (int[] p3 : points) {
                if (dist(p1, p2) != dist(p1, p3) + dist(p2, p3)) {
                    continue;
                }
                int x = p1[0] + p2[0] - p3[0];
                int y = p1[1] + p2[1] - p3[1];
                if (set.contains(x + "," + y)) {
                    double area = Math.sqrt(dist(p1, p3)) * Math.sqrt(dist(p2, p3));
                    if (Double.compare(area, 0) != 0) {
                        ans = Math.min(ans, area);
                    }
                }
            }
        }
    }
    return Double.compare(ans, Double.MAX_VALUE) == 0 ? 0 : ans;
}

private int dist(int[] p1, int[] p2) {
    return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
}




