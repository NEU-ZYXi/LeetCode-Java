
/*

Given a binary array data, 
return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.

Example 1:
Input: [1,0,1,0,1]
Output: 1
Explanation: 
There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1.

Example 2:
Input: [0,0,0,1,0]
Output: 0
Explanation: 
Since there is only one 1 in the array, no swaps needed.

Example 3:1151. Minimum Swaps to Group All 1's Together
Input: [1,0,1,0,1,0,0,1,1,0,1]
Output: 3
Explanation: 
One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].

*/

/*

Solution: find the sliding window with max number of '1'
O(n),O(1)

*/

public int minSwaps(int[] data) {
    int n = data.length, width = 0, max = 0, cnt = 0;
    for (int num : data) {
        width += num;
    }
    for (int i = 0, j = 0; j < n; ++j) {
        cnt += data[j];
        while (j - i + 1 > width) {
            cnt -= data[i++];
        }
        max = Math.max(max, cnt);
    }
    return width - max;
}




