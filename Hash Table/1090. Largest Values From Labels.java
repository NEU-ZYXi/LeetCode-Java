
/*

We have a set of items: the i-th item has value values[i] and label labels[i].
Then, we choose a subset S of these items, such that:
|S| <= num_wanted
For every label L, the number of items in S with label L is <= use_limit.
Return the largest possible sum of the subset S.

Example 1:
Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
Output: 9
Explanation: The subset chosen is the first, third, and fifth item.

Example 2:
Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
Output: 12
Explanation: The subset chosen is the first, second, and third item.

Example 3:
Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
Output: 16
Explanation: The subset chosen is the first and fourth item.

Example 4:
Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
Output: 24
Explanation: The subset chosen is the first, second, and fourth item.

*/

/*

O(nlogn),O(n)

*/

public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = values.length, ans = 0;
    int[][] nums = new int[n][2];
    for (int i = 0; i < n; ++i) {
        nums[i][0] = labels[i];
        nums[i][1] = values[i];
    }
    Arrays.sort(nums, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return b[1] - a[1];
        }
    });
    for (int i = 0; i < n; ++i) {
        int label = nums[i][0], value = nums[i][1];
        if (num_wanted > 0 && map.getOrDefault(label, 0) < use_limit) {
            num_wanted--;
            map.put(label, map.getOrDefault(label, 0) + 1);
            ans += value;
        }
    }
    return ans;
}



