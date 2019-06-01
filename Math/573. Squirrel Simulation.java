
/*

There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. 
Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one. 
The squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right, to the adjacent cell. 
The distance is represented by the number of moves.

Example 1:
Input: 
Height : 5
Width : 7
Tree position : [2,2]
Squirrel : [4,4]
Nuts : [[3,0], [2,5]]
Output: 12

*/

/*

Solution: assume squirrel is at tree position originally, sum of distance is 2*distance of nut to tree
          find min of distance of nut to squirrel to get the min overall distance
          sum-(nutToTree-min(nutToSquirrel))=sum-max(nutToTree-nutToSquirrel)
O(n),O(1)          

*/

public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
    int sum = 0, max = Integer.MIN_VALUE;
    for (int[] nut : nuts) {
        int nutToTree = Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1]);
        int nutToSq = Math.abs(nut[0] - squirrel[0]) + Math.abs(nut[1] - squirrel[1]);
        sum += nutToTree * 2;
        max = Math.max(max, nutToTree - nutToSq);
    }
    return sum - max;
}




