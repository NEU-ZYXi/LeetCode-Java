
/*

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:
Input: [2,1,5,6,2,3]
Output: 10

*/

/*

Solution 1. left[i] means the index that heights[left[i]]<heights[i], which is the left border of rectangle with heights[i]
            right[i] means the index that heights[right[i]]<heights[i], which is the right border of rectangle with heights[i]
O(n),O(n)

*/

public int largestRectangleArea(int[] heights) {
    int ans = 0, n = heights.length;
    if (n == 0) return ans;
    int[] left = new int[n];
    int[] right = new int[n];
    left[0] = -1;
    right[n - 1] = n;
    for (int i = 1; i < n; ++i) {
        int j = i - 1;
        while (j > -1 && heights[j] >= heights[i]) j = left[j];
        left[i] = j;
    }
    for (int i = n - 2; i >= 0; --i) {
        int j = i + 1;
        while (j < n && heights[j] >= heights[i]) j = right[j];
        right[i] = j;
    }
    for (int i = 0; i < n; ++i) ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
    return ans;
}


/*

Solution 2. use a stack to implement the same above, when we hit a right border, roll back in the stack to find left border
O(n),O(n)

*/

public int largestRectangleArea(int[] heights) {
    int ans = 0, n = heights.length, i = 0;
    if (n == 0) return ans;
    Deque<Integer> deque = new ArrayDeque<>();
    while (i <= n) {
        int height = i == n ? 0 : heights[i];
        if (deque.isEmpty() || height >= heights[deque.peekLast()]) {
            deque.offerLast(i);
            i++;
        } else {
            int j = deque.pollLast();
            int len = deque.isEmpty() ? i : i - deque.peekLast() - 1;
            ans = Math.max(ans, heights[j] * len);
        }
    }
    return ans;
}





