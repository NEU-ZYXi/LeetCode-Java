
/*

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. 
Assume that there is only one duplicate number, find the duplicate one.

Example 1:
Input: [1,3,4,2,2]
Output: 2

Example 2:
Input: [3,1,3,4,2]
Output: 3

*/

/*

Solution 1: take num as index and the array becomes a linked list, find the only duplicate is to find the linked list cycle
O(n),O(1)

*/

public int findDuplicate(int[] nums) {
    if (nums.length <= 1) {
        return -1;
    }
    int fast = nums[nums[0]], slow = nums[0], start = 0;
    while (fast != slow) {
        fast = nums[nums[fast]];
        slow = nums[slow];
    }
    while (start != slow) {
        start = nums[start];
        slow = nums[slow];
    }
    return start;
}


/*

Solution 2: O(n),O(n)

*/

public int findDuplicate(int[] nums) {
    int n = nums.length;
    int[] buckets = new int[n];
    for (int num : nums) {
        buckets[num]++;
    }
    for (int i = 0; i < n; ++i) {
        if (buckets[i] >= 2) {
            return i;
        }
    }
    return 0;
}


/*

Solution 3: O(nlogn),O(1)

*/

public int findDuplicate(int[] nums) {
    int l = 1, r = nums.length - 1;
    while (l <= r) {
        int mid = (l + r) / 2;
        int cnt = 0;
        for (int num : nums) {
            if (num <= mid) {
                cnt++;
            }
        }
        if (cnt <= mid) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    return l;
}




