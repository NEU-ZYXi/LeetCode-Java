
/*

On an infinite number line, the position of the i-th stone is given by stones[i]. 
Call a stone an endpoint stone if it has the smallest or largest position.
Each turn, you pick up an endpoint stone and move it to an unoccupied position so that it is no longer an endpoint stone.
In particular, if the stones are at say, stones = [1,2,5], you cannot move the endpoint stone at position 5, 
since moving it to any position (such as 0, or 3) will still keep that stone as an endpoint stone.
The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.
When the game ends, what is the minimum and maximum number of moves that you could have made?  
Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]

Example 1:
Input: [7,4,9]
Output: [1,2]
Explanation: 
We can move 4 -> 8 for one move to finish the game.
Or, we can move 9 -> 5, 4 -> 6 for two moves to finish the game.

Example 2:
Input: [6,5,4,3,10]
Output: [2,3]
We can move 3 -> 8 then 10 -> 7 to finish the game.
Or, we can move 3 -> 7, 4 -> 8, 5 -> 9 to finish the game.
Notice we cannot move 10 -> 2 to finish the game, because that would be an illegal move.

Example 3:
Input: [100,101,104,102,103]
Output: [0,0]

*/

/*

Solution: 1. for max, either move all stones to left or right, which means fill all the plots of A[0]+(n-1) or A[n-1]-(n-1)
             then we need move of A[n-2]-(A[0]+(n-1))+1 or A[n-1]-(n-1)-A[1]+1 because A[n-1] or A[0] can only move once
          2. for min, maintain a window of distance N, for each window, the elements outside should be moved inside
             for corner case which is A[0...n-2] consecutive and A[n-1] outside, we can have 2 move min
O(nlogn),O(1)             

*/

public int[] numMovesStonesII(int[] stones) {
    Arrays.sort(stones);
    int n = stones.length, low = Integer.MAX_VALUE, high = 0;
    high = Math.max(stones[n - 1] - (n - 1) - stones[1] + 1, stones[n - 2] - (stones[0] + (n - 1)) + 1);
    for (int i = 0, j = 0; j < n; ++j) {
        while (stones[j] - stones[i] >= n) {
            i++;
        }
        if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2) {
            low = Math.min(low, 2);
        } else {
            low = Math.min(low, n - (j - i + 1));
        }
    }
    return new int[] {low, high};
}



