
/*

Given a non-decreasing array of positive integers nums and an integer K, 
find out if this array can be divided into one or more disjoint increasing subsequences of length at least K. 

Example 1:
Input: nums = [1,2,2,3,3,4,4], K = 3
Output: true
Explanation: 
The array can be divided into the two subsequences [1,2,3,4] and [2,3,4] with lengths at least 3 each.

Example 2:
Input: nums = [5,6,6,7,8], K = 3
Output: false
Explanation: 
There is no way to divide the array using the conditions required.

*/

/*

Solution: the max number of same values is the number of different groups we need
          then we could distribute other values inside these groups only when K*(number of groups)<=(number of elements)
O(n),O(n)          

*/

public boolean canDivideIntoSubsequences(int[] nums, int K) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxFreq = 0;
    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        maxFreq = Math.max(maxFreq, map.get(num));
    }
    return nums.length / maxFreq >= K;
}


public boolean canDivideIntoSubsequences(int[] nums, int K) {
    int cnt = 1, maxFreq = 0, n = nums.length;
    for (int i = 1; i < n; ++i) {
        cnt = nums[i] > nums[i - 1] ? 1 : cnt + 1;
        maxFreq = Math.max(maxFreq, cnt);
    }
    return n / maxFreq >= K;
}



