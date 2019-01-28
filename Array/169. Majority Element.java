
/*

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2

*/

/*

Solution 1: sort the array and get the element occupying half the array
O(nlogn),O(1)

*/

public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
}


/*

Solution 2: use hashmap to count each elements
O(n),O(n)

*/

public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
    for (int num : map.keySet()) {
        if (map.get(num) > nums.length / 2) return num;
    }
    return -1;
}


/*

Solution 3: 多数投票算法(Boyer-Moore voting algorithm), 
            for any candidate, its count always become 0 at some index, select a new candidate, the remained one is majority
            the reason is that only the majority number will remained >0 in the end
O(n),O(1)            

*/

public int majorityElement(int[] nums) {
    int ans = nums[0], cnt = 0;
    for (int num : nums) {
        if (cnt == 0) ans = num;
        if (num != ans) cnt--;
        else cnt++;
    }
    return ans;
}


/*

Solution 4: bit manipulation, use 32 bits to store each element, if any bit is larger than n/2, it belongs to the majority
O(32n),O(32)

*/

public int majorityElement(int[] nums) {
    int[] bit = new int[32];
    for (int num : nums) {
        for (int i = 0; i < 32; ++i) bit[i] += (num >> i) & 1;
    }
    int ans = 0;
    for (int i = 0; i < 32; ++i) {
        bit[i] = (bit[i] > nums.length / 2) ? 1 : 0;
        ans += bit[i] << i;
    }
    return ans;
}




