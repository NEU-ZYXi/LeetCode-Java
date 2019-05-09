
/*

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[2,3]

*/

/*

Solution: use number as index, mark the number of that index negative, whenever we meet a negative number again, it's duplicate
O(n),O(1)

*/

public List<Integer> findDuplicates(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
        int idx = Math.abs(nums[i]) - 1;
        if (nums[idx] < 0) ans.add(idx + 1);
        nums[idx] = -nums[idx];
    }
    return ans;
}




