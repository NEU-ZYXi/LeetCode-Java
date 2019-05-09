
/*

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[5,6]

*/

/*

O(n),O(1)

*/

public List<Integer> findDisappearedNumbers(int[] nums) {
    int n = nums.length;
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
        int idx = Math.abs(nums[i]) - 1;
        if (nums[idx] > 0) nums[idx] = -nums[idx];
    }
    for (int i = 0; i < n; ++i) {
        if (nums[i] > 0) ans.add(i + 1);
    }
    return ans;
}




