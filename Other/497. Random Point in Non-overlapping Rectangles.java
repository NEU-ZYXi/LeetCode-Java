
/*

Given a list of non-overlapping axis-aligned rectangles rects, 
write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.

Note:
An integer point is a point that has integer coordinates. 
A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, 
and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.

Example 1:
Input: 
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output: 
[null,[4,1],[4,1],[3,3]]

Example 2:
Input: 
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output: 
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]

*/

/*

O(n),O(n)

*/

class Solution {
    
    private int[][] rects;
    private TreeMap<Integer, Integer> map;
    private int area;
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.map = new TreeMap<>();
        this.area = 0;
        this.rand = new Random();
        for (int i = 0; i < rects.length; ++i) {
            area += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            map.put(area, i);
        }
    }
    
    public int[] pick() {
        int randInt = rand.nextInt(area);
        int key = map.higherKey(randInt);
        int[] rect = rects[map.get(key)];
        int x = rect[0] + (key - randInt - 1) % (rect[2] - rect[0] + 1);
        int y = rect[1] + (key - randInt - 1) / (rect[2] - rect[0] + 1);
        return new int[] {x, y};
    }
}





