
/*

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

*/

/*

O(31n),O(1)

*/

public int totalHammingDistance(int[] nums) {
    int ans = 0, n = nums.length;
    for (int i = 0; i < 31; ++i) {
        int cnt = 0;
        for (int j = 0; j < n; ++j) {
            cnt += nums[j] & 1;
            nums[j] >>= 1;
        }
        ans += cnt * (n - cnt);
    }
    return ans;
}




