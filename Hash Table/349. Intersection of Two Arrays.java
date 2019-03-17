
/*

Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

*/

/*

Solution 1: O(n),O(n)

*/

public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> nums = new HashSet<>();
    Set<Integer> vis = new HashSet<>();
    for (int num : nums1) nums.add(num);
    for (int num : nums2) {
        if (nums.contains(num)) vis.add(num);
    }
    int[] ans = new int[vis.size()];
    int i = 0;
    for (int num : vis) ans[i++] = num;
    return ans;
}


/*

Solution 2: O(max(nlgon,mlogm)),O(1)

*/

public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> vis = new HashSet<>();
    Arrays.sort(nums2);
    for (int num : nums1) {
        if (binarySearch(num, nums2)) vis.add(num);
    }
    int[] ans = new int[vis.size()];
    int i = 0;
    for (int num : vis) ans[i++] = num;
    return ans;
}

private boolean binarySearch(int target, int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (nums[mid] == target) return true;
        else if (nums[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
    return false;
}


/*

Solution 3: O(nlogn+mlogm),O(1)

*/

public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    Set<Integer> vis = new HashSet<>();
    int i = 0, j = 0;
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) i++;
        else if (nums1[i] > nums2[j]) j++;
        else {
            vis.add(nums1[i]);
            i++;
            j++;
        }
    }
    int[] ans = new int[vis.size()];
    int k = 0;
    for (int num : vis) ans[k++] = num;
    return ans;
}




