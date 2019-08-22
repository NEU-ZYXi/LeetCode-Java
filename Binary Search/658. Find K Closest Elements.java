
/*

Given a sorted array, two integers k and x, find the k closest elements to x in the array. 
The result should also be sorted in ascending order. 
If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]

Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]

*/

/*

Solution 1: O(nlogn),O(n)

/*

public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> ans = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();
    for (int num : arr) {
        nums.add(num);
    }
    Collections.sort(nums, new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return Math.abs(a - x) - Math.abs(b - x);
        }
    });
    for (int i = 0; i < k; ++i) {
        ans.add(nums.get(i));
    }
    Collections.sort(ans);
    return ans;
}


/*

Solution 2: use binary search to find the start index of the k elements
            if leftmost element arr[mid] is further than rightmost element arr[mid+k], find in the right part
            otherwise, find in the left part
O(logn+k),O(1)            

*/

public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> ans = new ArrayList<>();
    int n = arr.length, l = 0, r = n - k;
    while (l < r) {
        int mid = (l + r) / 2;
        if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x)) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    for (int i = l; i < l + k; ++i) {
        ans.add(arr[i]);
    }
    return ans;
}




