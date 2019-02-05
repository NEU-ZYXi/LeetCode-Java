
/*

A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. 
Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), 
write a program to output the skyline formed by these buildings collectively (Figure B).

Buildings  Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], 
where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. 
It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. 
You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: 
[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] 
that uniquely defines a skyline. 
A key point is the left endpoint of a horizontal line segment. 
Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, 
and always has zero height. 
Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

*/

/*

Solution 1:
O(nlogn),O(n)

*/

class Point {
    private int x, y, flg;

    public Point(int _x, int _y, int _flg) {
        this.x = _x;
        this.y = _y;
        this.flg = _flg;
    }
}

public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> ans = new ArrayList<>();
    List<Point> points = new ArrayList<>();
    for (int[] building : buildings) {
        points.add(new Point(building[0], building[2], 1));
        points.add(new Point(building[1], building[2], -1));
    }
    Collections.sort(points, (a, b) -> a.x - b.x);
    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(0, 1);
    int prev = -1;
    for (int i = 0; i < points.size(); ++i) {
        Point p = points.get(i);
        map.put(p.y, map.getOrDefault(p.y, 0) + p.flg);
        if (map.get(p.y) == 0) map.remove(p.y);
        if (i == points.size() - 1 || points.get(i + 1).x > p.x) {
            int y = map.lastKey();
            if (prev == y) continue;
            ans.add(new int[] {p.x, y});
            prev = y;
        }
    }
    return ans;
}




