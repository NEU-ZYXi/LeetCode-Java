
/*

Suppose LeetCode will start its IPO soon. 
In order to sell a good price of its shares to Venture Capital, 
LeetCode would like to work on some projects to increase its capital before the IPO. 
Since it has limited resources, it can only finish at most k distinct projects before the IPO. 
Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
You are given several projects. For each project i, 
it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. 
Initially, you have W capital. When you finish a project, 
you will obtain its pure profit and the profit will be added to your total capital.
To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, 
and output your final maximized capital.

Example 1:
Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
Output: 4
Explanation: Since your initial capital is 0, you can only start the project indexed 0.
             After finishing it you will obtain profit 1 and your capital becomes 1.
             With capital 1, you can either start the project indexed 1 or the project indexed 2.
             Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
             Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.

*/

/*

Solution: greedily choose the one with least capital and largest profit
O(nlogn),O(n)

*/

public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    int n = Profits.length;
    int[][] projects = new int[n][2];
    for (int i = 0; i < n; ++i) {
        projects[i][0] = Profits[i];
        projects[i][1] = Capital[i];
    }
    PriorityQueue<int[]> pqPro = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return b[0] - a[0];
        }
    });
    PriorityQueue<int[]> pqCap = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    });
    for (int[] project : projects) {
        pqCap.offer(project);
    }
    for (int i = 0; i < k; ++i) {
        while (!pqCap.isEmpty() && pqCap.peek()[1] <= W) {
            pqPro.offer(pqCap.poll());
        }
        if (pqPro.isEmpty()) {
            break;
        }
        W += pqPro.poll()[0];
    }
    return W;
}




