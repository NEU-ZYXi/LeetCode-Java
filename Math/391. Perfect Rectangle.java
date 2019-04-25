
/*

Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
Each rectangle is represented as a bottom-left point and a top-right point. 
For example, a unit square is represented as [1,1,2,2]. 
(coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).

Example 1:
rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]
Return true. All 5 rectangles together form an exact cover of a rectangular region.
 
Example 2:
rectangles = [
  [1,1,2,3],
  [1,3,2,4],
  [3,1,4,2],
  [3,2,4,4]
]
Return false. Because there is a gap between the two rectangular regions.
 
Example 3:
rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [3,2,4,4]
]
Return false. Because there is a gap in the top center.
 
Example 4:
rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [2,2,4,4]
]
Return false. Because two of the rectangles overlap with each other.

*/

/*

O(n),O(n)

*/

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 31 * x;
        return 31 * hash + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point p = (Point)obj;
            return this.x == p.x && this.y == p.y;
        }
        return false;
    }
}

public boolean isRectangleCover(int[][] rectangles) {
    int x1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y1 = Integer.MAX_VALUE, y2 = Integer.MIN_VALUE;
    int area = 0;
    Set<Point> set = new HashSet<>();
    for (int[] rec : rectangles) {
        area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
        x1 = Math.min(x1, rec[0]);
        x2 = Math.max(x2, rec[2]);
        y1 = Math.min(y1, rec[1]);
        y2 = Math.max(y2, rec[3]);
        Point p1 = new Point(rec[0], rec[1]);
        Point p2 = new Point(rec[0], rec[3]);
        Point p3 = new Point(rec[2], rec[1]);
        Point p4 = new Point(rec[2], rec[3]);
        if (!set.add(p1)) set.remove(p1);
        if (!set.add(p2)) set.remove(p2);
        if (!set.add(p3)) set.remove(p3);
        if (!set.add(p4)) set.remove(p4);
    }
    Point p1 = new Point(x1, y1);
    Point p2 = new Point(x1, y2);
    Point p3 = new Point(x2, y1);
    Point p4 = new Point(x2, y2);
    if (area != (x2 - x1) * (y2 - y1)) return false;
    return set.size() == 4 && set.contains(p1) && set.contains(p2) && set.contains(p3) && set.contains(p4);
}




