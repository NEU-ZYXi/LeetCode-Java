
/*

Given the coordinates of four points in 2D space, return whether the four points could construct a square.
The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True

*/

/*

O(1),O(1)

*/

public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p2, p4, p3);
}

private boolean check(int[] tl, int[] tr, int[] br, int[] bl) {
    int d1 = dist(tl, tr), d2 = dist(tr, br), d3 = dist(br, bl), d4 = dist(bl, tl);
    return d1 > 0 && d1 == d2 && d2 == d3 && d3 == d4 && dist(tl, br) == dist(tr, bl);
}

private int dist(int[] a, int[] b) {
    return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
}




