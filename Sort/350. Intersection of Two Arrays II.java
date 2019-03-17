
/*

Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

*/

/*

O(n+m),O(max(n,m))

*/

public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> nums = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
    for (int num : nums2) {
        if (map.containsKey(num) && map.get(num) > 0) {
            nums.add(num);
            map.put(num, map.get(num) - 1);
        }
    }
    int[] ans = new int[nums.size()];
    int i = 0;
    for (int num : nums) ans[i++] = num;
    return ans;
}


/*

O(nlogn+nlogm),O(1)

*/

public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> nums = new ArrayList<>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0;
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) i++;
        else if (nums1[i] > nums2[j]) j++;
        else {
            nums.add(nums1[i]);
            i++;
            j++;
        }
    }
    int[] ans = new int[nums.size()];
    int k = 0;
    for (int num : nums) ans[k++] = num;
    return ans;
}





