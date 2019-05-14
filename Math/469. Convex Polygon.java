
/*

Given a list of points that form a polygon when joined sequentially, find if this polygon is convex (Convex polygon definition).
Note:
There are at least 3 and at most 10,000 points.
Coordinates are in the range -10,000 to 10,000.
You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition). 
In other words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.
 
Example 1:
[[0,0],[0,1],[1,1],[1,0]]
Answer: True

Example 2:
[[0,0],[0,10],[10,10],[10,0],[5,5]]
Answer: False

*/

/*

Solution: compare the slope between each two adjacent vector, which is the cross product
          for vector BA and BC, BA^BC=|BA|*|BC|*sinθ, positive(θ<=180°), negative(θ>180°)
          BA(x1,y1), BC(x2,y2) then the cross product is x1*y2-x2*y1
O(n),O(1)

*/

public boolean isConvex(List<List<Integer>> points) {
    int n = points.size(), j = 0, k = 0;
    boolean pos = false, neg = false;
    for (int i = 0; i < n; ++i) {
        j = (i + 1) % n;
        k = (j + 1) % n;
        int ax = points.get(i).get(0), ay = points.get(i).get(1);
        int bx = points.get(j).get(0), by = points.get(j).get(1);
        int cx = points.get(k).get(0), cy = points.get(k).get(1);
        int crossProduct = calc(ax, ay, bx, by, cx, cy);
        if (crossProduct > 0) pos = true;
        else if (crossProduct < 0) neg = true;
        if (pos && neg) return false;
    }
    return true;
}

private int calc(int ax, int ay, int bx, int by, int cx, int cy) {
    int bax = bx - ax, bay = by - ay;
    int bcx = bx - cx, bcy = by - cy;
    return bax * bcy - bcx * bay;
}




