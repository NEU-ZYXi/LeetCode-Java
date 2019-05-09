
/*

Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) 
such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
Find the number of boomerangs. 

Example:
Input:
[[0,0],[1,0],[2,0]]
Output:
2
Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

*/

/*

O(n^2),O(n)

*/

public int numberOfBoomerangs(int[][] points) {
    int ans = 0, n = points.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (i != j) {
                int dis = getDistance(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
        }
        for (int val : map.values()) ans += val * (val - 1);
        map.clear();
    }
    return ans;
}

private int getDistance(int[] p, int[] q) {
    return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
}





