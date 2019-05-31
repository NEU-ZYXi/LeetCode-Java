
/*

There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. 
The bricks have the same height but different width. 
You want to draw a vertical line from the top to the bottom and cross the least bricks.
The brick wall is represented by a list of rows. 
Each row is a list of integers representing the width of each brick in this row from left to right.
If your line go through the edge of a brick, then the brick is not considered as crossed. 
You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

*/

/*

O(nm),O(n)

*/

public int leastBricks(List<List<Integer>> wall) {
    int cnt = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (List<Integer> level : wall) {
        int pos = 0;
        for (int i = 0; i < level.size() - 1; ++i) {
            pos += level.get(i);
            map.put(pos, map.getOrDefault(pos, 0) + 1);
        }
    }
    for (int pos : map.keySet()) {
        cnt = Math.max(cnt, map.get(pos));
    }
    return wall.size() - cnt;
}





