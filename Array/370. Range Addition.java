
/*

Assume you have an array of length n initialized with all 0's and are given k update operations.
Each operation is represented as a triplet: [startIndex, endIndex, inc] 
which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
Return the modified array after all k operations were executed.

Example:
Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
Output: [-2,0,3,5,3]
Explanation:

Initial state:
[0,0,0,0,0]

After applying operation [1,3,2]:
[0,2,2,2,0]

After applying operation [2,4,3]:
[0,2,5,5,3]

After applying operation [0,2,-2]:
[-2,0,3,5,3]

*/

/*

Solution: ans[l]+=inc,ans[r+1]-=inc so that ans[l...r]+=inc using prefix sum to arrange values
O(n),O(1)

*/

public int[] getModifiedArray(int length, int[][] updates) {
    int[] ans = new int[length];
    int sum = 0;
    for (int[] update : updates) {
        int l = update[0], r = update[1], inc = update[2];
        ans[l] += inc;
        if (r < length - 1) ans[r + 1] -= inc;
    }
    for (int i = 0; i < length; ++i) {
        sum += ans[i];
        ans[i] = sum;
    }
    return ans;
}





