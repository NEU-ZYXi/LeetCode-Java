
/*

Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

*/

/*

Solution 1: sort
O(nlogn),O(1)

*/

public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
}


/*

Solution 2: use priority queue to store the first k smallest elements
O(nlogn),O(k)

*/

public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < nums.length; ++i) {
        pq.offer(nums[i]);
        if (pq.size() > k) pq.poll();
    }
    return pq.peek();
}


/*

Solution 3: quick select using partition function of quick sort
O(n),O(k)

*/

public int findKthLargest(int[] nums, int k) {
    int l = 0, r = nums.length - 1, target = nums.length - k;
    while (l < r) {
        int pivot = partition(nums, l, r);
        if (pivot == target) return nums[pivot];
        else if (pivot > target) r = pivot - 1;
        else l = pivot + 1;
    }
    return nums[l];
}

private int partition(int[] nums, int l, int r) {
    int pivot = l;
    while (l <= r) {
        while (l <= r && nums[l] <= nums[pivot]) l++;
        while (l <= r && nums[pivot] <= nums[r]) r--;
        if (l > r) break;
        swap(nums, l, r);
    }
    swap(nums, pivot, r);
    return r;
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}




