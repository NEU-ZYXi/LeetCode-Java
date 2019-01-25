
/*

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:
Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4

Example 2:
Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6

*/

/*

O(n^2),O(n)

*/

public int maxPoints(Point[] points) {
    int n = points.length;
    if (n <= 2) return n;
    int ans = 0;
    for (int i = 0; i < n - 1; ++i) {
        Map<String, Integer> map = new HashMap<>();
        int overlap = 0, max = 0;
        for (int j = i + 1; j < n; ++j) {
            int dx = points[i].x - points[j].x;
            int dy = points[i].y - points[j].y;
            if (dx == 0 && dy == 0) overlap++;
            else {
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                String slope = String.valueOf(dx) + String.valueOf(dy);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }
        }
        ans = Math.max(ans, max + overlap + 1);
    }
    return ans;
}

private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}



