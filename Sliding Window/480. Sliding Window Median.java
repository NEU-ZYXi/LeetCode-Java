
/*

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position. 
Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

*/

/*

Solution: use maxHeap as the left part and minHeap as the right part
          for each number, go through the heap with more elements and go into the other one to keep the whole sorted
O(nlogn),O(n)          

*/

public double[] medianSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    double[] ans = new double[n - k + 1];
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < n; ++i) {
        if (maxHeap.size() <= minHeap.size()) {
            minHeap.offer(nums[i]);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(nums[i]);
            minHeap.offer(maxHeap.poll());
        }
        if (maxHeap.size() + minHeap.size() == k) {
            double median = 0;
            if (maxHeap.size() == minHeap.size()) {
                median = ((long)maxHeap.peek() + (long)minHeap.peek()) / 2.0;
            } else {
                median = (double)maxHeap.peek();
            }
            int idx = i - k + 1;
            ans[idx] = median;
            if (!maxHeap.remove(nums[idx])) {
                minHeap.remove(nums[idx]);
            }
        }
    }
    return ans;
}





