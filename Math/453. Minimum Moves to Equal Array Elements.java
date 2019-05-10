
/*

Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, 
where a move is incrementing n - 1 elements by 1.

Example:
Input:
[1,2,3]
Output:
3
Explanation:
Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

*/

/*

Solution: assume use k moves to get the array element equals to x, which is sum+(n-1)*k=n*x
          and the minimum element needs to be incremented in each move, which is x=k+min
          then sum+(n-1)*k=n*(k+min), which is k=sum-n*min
O(n),O(1)          

*/

public int minMoves(int[] nums) {
    int sum = 0, min = Integer.MAX_VALUE, n = nums.length;
    for (int i = 0; i < n; ++i) {
        min = Math.min(min, nums[i]);
        sum += nums[i];
    }
    return sum - n * min;
}





