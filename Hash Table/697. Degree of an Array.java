
/*

Given a non-empty array of non-negative integers nums, 
the degree of this array is defined as the maximum frequency of any one of its elements.
Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.

Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6

*/

/*

O(n),O(n)

*/

class Tuple {
    private int cnt;
    private int start;
    private int end;

    public Tuple(int cnt, int start, int end) {
        this.cnt = cnt;
        this.start = start;
        this.end = end;
    }
}

public int findShortestSubArray(int[] nums) {
    int n = nums.length, max = 0, ans = Integer.MAX_VALUE;
    Map<Integer, Tuple> map = new HashMap<>();
    for (int i = 0; i < n; ++i) {
        Tuple cur = map.getOrDefault(nums[i], new Tuple(0, i, i));
        cur.end = i;
        cur.cnt++;
        map.put(nums[i], cur);
    }
    for (int num : map.keySet()) {
        Tuple cur = map.get(num);
        if (cur.cnt > max) {
            max = cur.cnt;
            ans = cur.end - cur.start + 1;
        } else if (cur.cnt == max) {
            ans = Math.min(ans, cur.end - cur.start + 1);
        }
    }
    return ans;
}




