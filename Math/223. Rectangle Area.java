
/*

Find the total area covered by two rectilinear rectangles in a 2D plane.
Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Example:
Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45

*/

/*

O(1),O(1)

*/

public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int area1 = (C - A) * (D - B), area2 = (G - E) * (H - F);
    int l = Math.max(A, E), r = Math.min(C, G), t = Math.min(D, H), b = Math.max(B, F);
    int overlap = 0;
    if (r > l && t > b) overlap = (r - l) * (t - b);
    return area1 + area2 - overlap;
}




