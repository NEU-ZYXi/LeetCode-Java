
/*

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
Your algorithm should run in O(n) complexity.

Example:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

*/

/*

Solution 1. sort and count the consecutive sequence, find the longest one
O(nlogn),O(1)

*/

public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;
    int ans = 0, cnt = 1;
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; ++i) {
        if (nums[i] == nums[i - 1]) continue;
        else if (nums[i] == nums[i - 1] + 1) cnt++;
        else {
            ans = Math.max(ans, cnt);
            cnt = 1;
        }
    }
    ans = Math.max(ans, cnt);
    return ans;
}


/*

Solution 2. for each element, remove the consecutive ones before and after it
O(n),O(n)

*/

public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);
    int ans = 0;
    for (int i = 0; i < nums.length; ++i) {
        int cur = nums[i], cnt = 1;
        while (set.contains(cur - 1)) {
            set.remove(cur - 1);
            cur--;
            cnt++;
        }
        cur = nums[i];
        while (set.contains(cur + 1)) {
            set.remove(cur + 1);
            cur++;
            cnt++;
        }
        ans = Math.max(ans, cnt);
    }
    return ans;
}




