
/*

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.

*/

/*

O(n),O(1)

*/

public int findMaxConsecutiveOnes(int[] nums) {
    int ans = 0, cnt = 0;
    for (int num : nums) {
        if (num == 1) {
            cnt++;
        } else {
            cnt = 0;
        }
        ans = Math.max(ans, cnt);
    }
    return ans;
}




