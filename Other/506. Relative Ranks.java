
/*

Given scores of N athletes, find their relative ranks and the people with the top three highest scores, 
who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, 
so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.

*/

/*

Solution 1: start from max score to get the highest three scores
O(m),O(n) where m is the max number

*/

public String[] findRelativeRanks(int[] nums) {
    int n = nums.length, max = 0, rank = 1;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
        max = Math.max(max, num);
    }
    for (int i = 0; i < n; ++i) {
        map.put(nums[i], i);
    }
    String[] ans = new String[n];
    for (int i = max; i >= 0; --i) {
        if (map.containsKey(i)) {
            int idx = map.get(i);
            String value = "";
            if (rank == 1) {
                value = "Gold Medal";
            } else if (rank == 2) {
                value = "Silver Medal";
            } else if (rank == 3) {
                value = "Bronze Medal";
            } else {
                value = String.valueOf(rank);
            }
            ans[idx] = value;
            rank++;
        }
    }
    return ans;
}


/*

Solution 2: sort the array to get the highest three
O(nlogn),O(n)

*/

public String[] findRelativeRanks(int[] nums) {
    int n = nums.length;
    int[] tmp = Arrays.copyOf(nums, n);
    Map<Integer, String> map = new HashMap<>();
    Arrays.sort(tmp);
    for (int i = n - 1; i >= 0; --i) {
        if (i == n - 1) {
            map.put(tmp[i], "Gold Medal");
        } else if (i == n - 2) {
            map.put(tmp[i], "Silver Medal");
        } else if (i == n - 3) {
            map.put(tmp[i], "Bronze Medal");
        } else {
            map.put(tmp[i], String.valueOf(n - i));
        }
    }
    String[] ans = new String[n];
    for (int i = 0; i < n; ++i) {
        ans[i] = map.get(nums[i]);
    }
    return ans;
}





