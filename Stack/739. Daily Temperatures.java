
/*

Given a list of daily temperatures T, return a list such that, 
for each day in the input, tells you how many days you would have to wait until a warmer temperature. 
If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

*/

/*

O(n),O(n)

*/

public int[] dailyTemperatures(int[] T) {
    int n = T.length;
    int[] ans = new int[n];
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
        while (!deque.isEmpty() && T[i] > T[deque.peekLast()]) {
            int prev = deque.pollLast();
            ans[prev] = i - prev;
        }
        deque.offerLast(i);
    }
    return ans;
}




