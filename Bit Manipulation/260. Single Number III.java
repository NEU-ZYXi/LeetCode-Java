
/*

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
Find the two elements that appear only once.

Example:
Input:  [1,2,1,3,2,5]
Output: [3,5]

*/

/*

Solution: 1. diff^=num to get the XOR two single numbers
          2. diff&=(~(diff-1)) to get the last set bit, for 010100, (diff-1) gets 010011, ~(diff-1) gets 101100, & gets 000100
          3. by diff, group all the numbers into two groups, the two single numbers are in each group
O(n),O(1)          
 
*/

public int[] singleNumber(int[] nums) {
    int[] ans = new int[2];
    int diff = 0;
    for (int num : nums) diff ^= num;
    diff &= ~(diff - 1);
    for (int num : nums) {
        if ((num & diff) == 0) ans[0] ^= num;
        else ans[1] ^= num;
    }
    return ans;
}




