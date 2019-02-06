
/*

Given an array of integers, find out whether there are two distinct indices i and j in the array such that 
the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false

*/

/*

Solution 1: use buckets with size of t+1 to group all elements
            1. if two elements are in the same bucket, duplicate
            2. if two elements are in the adjacent buckets, and their distance is less than t+1, duplicate
            to get the bucket id, if element is positive or 0, num/(t+1), [0...t],[t+1...2t+1],....
                                  otherwise, (num+1)/(t+1)-1, [-1...-t-1],[-t-2...-2t-2],...
O(n),O(n)

*/

public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (t < 0) return false;
    long sz = (long)t + 1;
    Map<Long, Long> map = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
        long bucket = getBucket(nums[i], sz);
        if (map.containsKey(bucket)) return true;
        if (map.containsKey(bucket + 1) && Math.abs(nums[i] - map.get(bucket + 1)) < sz) return true;
        if (map.containsKey(bucket - 1) && Math.abs(nums[i] - map.get(bucket - 1)) < sz) return true;
        map.put(bucket, (long)nums[i]);
        if (i >= k) map.remove(getBucket(nums[i - k], sz));
    }
    return false;
}

private long getBucket(int num, long sz) {
    return num >= 0 ? num / sz : (num + 1) / sz - 1;
}


/*

Solution 2: use TreeSet to store k elements, for each element, get its floor and ceiling elements and check the distance
O(nlogk),O(k)

*/

public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (t < 0) return false;
    TreeSet<Long> set = new TreeSet<>();
    for (int i = 0; i < nums.length; ++i) {
        long num = (long)nums[i];
        Long floor = set.floor(num), ceiling = set.ceiling(num);
        if (floor != null && num - floor <= t || ceiling != null && ceiling - num <= t) return true;
        set.add(num);
        if (i >= k) set.remove((long)nums[i - k]);
    }
    return false;
}




