
/*

Given an array arr of positive integers, consider all binary trees such that:
Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  
(Recall that a node is a leaf if and only if it has 0 children.)
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. 
It is guaranteed this sum fits into a 32-bit integer.

Example 1:
Input: arr = [6,2,4]
Output: 32
Explanation:
There are two possible trees. 
The first has non-leaf node sum 36, and the second has non-leaf node sum 32.
    24            24
   /  \          /  \
  12   4        6    8
 /  \               / \
6    2             2   4

*/

/*

Solution 1: dp[i][j] means the minimum cost for tree of a[i...j]
            for a[i...k] and a[k+1...j], find the min of the cost which is dp[i][k]+dp[k+1][j]+max(a[i...k])*max(a[k+1...j])
            preprocess the max array for each (i,j) for arr
O(n^3),O(n^2)

*/

public int mctFromLeafValues(int[] arr) {
    int n = arr.length;
    int[][] dp = new int[n][n];
    int[][] max = new int[n][n];
    for (int i = 0; i < n; ++i) {
        int cur = 0;
        for (int j = i; j < n; ++j) {
            cur = Math.max(cur, arr[j]);
            max[i][j] = cur;
        }
    }
    for (int len = 1; len < n; ++len) {
        for (int i = 0; i + len < n; ++i) {
            int j = i + len;
            dp[i][j] = Integer.MAX_VALUE;
            if (len == 1) {
                dp[i][j] = arr[i] * arr[j];
            } else {
                for (int k = i; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                }
            }
        }
    }
    return dp[0][n - 1];
}


/*

Solution 2: since a node can only multiply with its left or right neighbor, greedily multiply with min(left,right)
            use a deque to track the (left,cur,right), and for decreasing value nodes, accumulate each two pairs from end
O(n),O(n)            

*/

public int mctFromLeafValues(int[] arr) {
    int ans = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    for (int val : arr) {
        while (!deque.isEmpty() && deque.peekLast() <= val) {
            int cur = deque.pollLast();
            if (!deque.isEmpty()) {
                ans += cur * Math.min(deque.peekLast(), val);
            } else {
                ans += cur * val;
            }
        }
        deque.offerLast(val);
    }
    while (deque.size() >= 2) {
        ans += deque.pollLast() * deque.peekLast();
    }
    return ans;
}




