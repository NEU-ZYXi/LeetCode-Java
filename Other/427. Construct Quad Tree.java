
/*

We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. 
The root node represents the whole grid. For each node, 
it will be subdivided into four children nodes until the values in the region it represents are all the same.
Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. 
The val attribute for a leaf node contains the value of the region it represents.
Your task is to use a quad tree to represent a given grid. 
For the non-leaf nodes, val can be arbitrary, so it is represented as *.

*/

/*

O(nmlog(nm)),O(nm)

*/

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return dfs(grid, 0, 0, n - 1, n - 1);
    }
    
    private Node dfs(int[][] grid, int r1, int c1, int r2, int c2) {
        boolean isLeaf = true;
        int val = grid[r1][c1];
        for (int i = r1; i <= r2; ++i) {
            for (int j = c1; j <= c2; ++j) {
                if (grid[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
        }
        if (isLeaf) return new Node(val == 1, true, null, null, null, null);
        int x = (r1 + r2) / 2, y = (c1 + c2) / 2;
        return new Node(false, false, dfs(grid, r1, c1, x, y), 
                                      dfs(grid, r1, y + 1, x, c2), 
                                      dfs(grid, x + 1, c1, r2, y), 
                                      dfs(grid, x + 1, y + 1, r2, c2));
    }
}





