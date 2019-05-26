
/*

You are given the number of rows n_rows and number of columns n_cols of a 2D binary matrix where all values are initially 0. 
Write a function flip which chooses a 0 value uniformly at random, changes it to 1, 
and then returns the position [row.id, col.id] of that value. 
Also, write a function reset which sets all values back to 0. 
Try to minimize the number of calls to system's Math.random() and optimize the time and space complexity.

Note:
1 <= n_rows, n_cols <= 10000
0 <= row.id < n_rows and 0 <= col.id < n_cols
flip will not be called when the matrix has no 0 values left.
the total number of calls to flip and reset will not exceed 1000.

Example 1:
Input: 
["Solution","flip","flip","flip","flip"]
[[2,3],[],[],[],[]]
Output: [null,[0,1],[1,2],[1,0],[1,1]]

Example 2:
Input: 
["Solution","flip","flip","reset","flip"]
[[1,2],[],[],[],[]]
Output: [null,[0,0],[0,1],null,[0,0]]

*/

/*

Solution: flatten 2d to 1d, and choose a random index, swap it with the last index and store in a map
          next time when we get a same index, retrieve the one in the map to promise the uniform
O(1),O(n)          

*/

class Solution {
    private int n, m, total;
    private Random rand;
    private Map<Integer, Integer> map;

    public Solution(int n_rows, int n_cols) {
        this.n = n_rows;
        this.m = n_cols;
        this.total = n * m;
        this.rand = new Random();
        this.map = new HashMap<>();
    }
    
    public int[] flip() {
        int randInt = rand.nextInt(total--);
        int idx = map.getOrDefault(randInt, randInt);
        map.put(randInt, map.getOrDefault(total, total));
        return new int[] {idx / m, idx % m};
    }
    
    public void reset() {
        map.clear();
        total = n * m;
    }
}




