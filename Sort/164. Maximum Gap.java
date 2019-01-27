
/*

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Return 0 if the array contains less than 2 elements.

Example 1:
Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
             
Example 2:
Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

*/

/*

Solution: 1. get the max and min element of the array, maximum gap is at least Math.ceil((max-min)/(n-1))
          2. use Buckets to group elements, the size of Buckets is the gap above,
             which means the gap among the elements in the same Buckets is always smaller than the gap above
          3. use minBucket and maxBucket to track the min and max in the same Buckets, index is (nums[i]-min)/gap above
          4. compare the gap between two consecutive Buckets which is minBucket[i]-maxBucket[i-1], find the maximum gap
O(n),O(n)          

*/

public int maximumGap(int[] nums) {
    int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    if (n < 2) return 0;
    for (int num : nums) {
        max = Math.max(max, num);
        min = Math.min(min, num);
    }
    if (max == min) return 0;
    int ans = (int)Math.ceil((double)(max - min) / (n - 1));
    int[] minBucket = new int[n];
    int[] maxBucket = new int[n];
    Arrays.fill(minBucket, Integer.MAX_VALUE);
    Arrays.fill(maxBucket, Integer.MIN_VALUE);
    for (int num : nums) {
        int idx = (num - min) / ans;
        minBucket[idx] = Math.min(minBucket[idx], num);
        maxBucket[idx] = Math.max(maxBucket[idx], num);
    }
    for (int i = 0; i < n; ++i) {
        if (minBucket[i] != Integer.MAX_VALUE) {
            ans = Math.max(ans, minBucket[i] - min);
            min = maxBucket[i];
        }
    }
    return ans;
}




