
/*

Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j]. 
The width of such a ramp is j - i.
Find the maximum width of a ramp in A.  If one doesn't exist, return 0.

Example 1:
Input: [6,0,8,2,1,5]
Output: 4
Explanation: 
The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.

Example 2:
Input: [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation: 
The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.

*/

/*

Solution 1: create arrays for min left element and max right element for i index
            use two pointers to expand the (i,j) where minL[i]<=maxR[j]
O(n),O(n)            

*/

public int maxWidthRamp(int[] A) {
    int n = A.length, ans = 0;
    int[] minL = new int[n], maxR = new int[n];
    minL[0] = A[0];
    maxR[n - 1] = A[n - 1];
    for (int i = 1; i < n; ++i) {
        minL[i] = Math.min(A[i], minL[i - 1]);
    }
    for (int i = n - 2; i >= 0; --i) {
        maxR[i] = Math.max(A[i], maxR[i + 1]);
    }
    int i = 0, j = 0;
    while (i < n && j < n) {
        if (minL[i] <= maxR[j]) {
            ans = Math.max(ans, j - i);
            j++;
        } else {
            i++;
        }
    }
    return ans;
}


/*

Solution 2: maintain a decreasing stack, and for each element from the end, find the furthest element in the stack
O(n),O(n)

*/

public int maxWidthRamp(int[] A) {
    int ans = 0, n = A.length;
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
        if (deque.isEmpty() || A[deque.peekLast()] > A[i]) {
            deque.offerLast(i);
        }
    }
    for (int i = n - 1; i > ans; --i) {
        while (!deque.isEmpty() && A[deque.peekLast()] <= A[i]) {
            ans = Math.max(ans, i - deque.pollLast());
        }
    }
    return ans;
}



