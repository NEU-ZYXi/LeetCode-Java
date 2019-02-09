
/*

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Note: The algorithm should run in linear time and in O(1) space.

Example 1:
Input: [3,2,3]
Output: [3]

Example 2:
Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

*/

/*

Solution: Boyer-Moore algorithm, 多数投票算法, candidate和cnt来表示当前出现次数最多的元素
          cand1和cand2则为数组中出现次数最多的2个元素，因为次数超过3/n的元素最多只有2个
          check the count of cand1 and cand2 to see if they are larger than 3/n
O(n),O(1)          

*/

public List<Integer> majorityElement(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    if (nums.length == 0) return ans;
    int cand1 = nums[0], cand2 = nums[0], cnt1 = 1, cnt2 = 0;
    for (int num : nums) {
        if (num == cand1) cnt1++;
        else if (num == cand2) cnt2++;
        else if (cnt1 == 0) {
            cand1 = num;
            cnt1 = 1;
        } else if (cnt2 == 0) {
            cand2 = num;
            cnt2 = 1;
        } else {
            cnt1--;
            cnt2--;
        }
    }
    cnt1 = 0;
    cnt2 = 0;
    for (int num : nums) {
        if (num == cand1) cnt1++;
        else if (num == cand2) cnt2++;
    }
    if (cnt1 > nums.length / 3) ans.add(cand1);
    if (cnt2 > nums.length / 3) ans.add(cand2);
    return ans;
}




