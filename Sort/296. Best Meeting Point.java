
/*

A group of two or more people wants to meet and minimize the total travel distance. 
You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

Example:
Input: 
1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
Output: 6 
Explanation: Given three people living at (0,0), (0,4), and (2,2):
             The point (0,2) is an ideal meeting point, as the total travel distance 
             of 2+2+2=6 is minimal. So return 6.

*/

/*

Solution: for Manhattan Distance, separate points by their x and y axis
          for all x values, xj-xi is the sum of ith and jth point to best meeting point, sort x values and sum distance
          for all y values, yj-yi is the sum of ith and jth point to best meeting point, sort y values and sum distance
O(nm),O(n+m)          

*/

public int minTotalDistance(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    List<Integer> x = new ArrayList<>(), y = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 1) {
                x.add(i);
                y.add(j);
            }
        }
    }
    Collections.sort(x);
    Collections.sort(y);
    return getDistance(x) + getDistance(y);
}

private int getDistance(List<Integer> nums) {
    int i = 0, j = nums.size() - 1, ans = 0;
    while (i < j) {
        ans += nums.get(j) - nums.get(i);
        i++;
        j--;
    }
    return ans;
}




