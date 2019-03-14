
/*

Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

*/

/*

O(n),O(n)

*/

public List<Integer> topKFrequent(int[] nums, int k) {
    int n = nums.length;
    List<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
    List<Integer>[] buckets = new ArrayList[n + 1];
    for (int num : map.keySet()) {
        int freq = map.get(num);
        if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
        buckets[freq].add(num);
    }
    for (int i = n; i > 0; --i) {
        if (buckets[i] != null) {
            for (int num : buckets[i]) {
                ans.add(num);
                k--;
                if (k == 0) return ans;
            }
        }
    }
    return ans;
}




