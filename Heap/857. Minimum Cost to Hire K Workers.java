
/*

There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].
Now we want to hire exactly K workers to form a paid group. 
When hiring a group of K workers, we must pay them according to the following rules:
Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Return the least amount of money needed to form a paid group satisfying the above conditions.

Example 1:
Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.

Example 2:
Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately. 

*/

/*

Solution: for workers in the result group, they should have same ratio which is wage/quality because w[i]/w[j]=q[i]/q[j]
          to get min total cost, sort workers by ratio in ascending order
          use a priority queue for K workers and sort by quality in descending order which means remove the one has largest cost
O(nlogn),O(n)          

*/

public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
    int n = quality.length;
    double ans = Double.MAX_VALUE, sum = 0;
    double[][] workers = new double[n][2];
    for (int i = 0; i < n; ++i) {
        workers[i] = new double[] {(double)quality[i], (double)wage[i] / quality[i]};
    }
    Arrays.sort(workers, new Comparator<double[]>() {
        @Override
        public int compare(double[] a, double[] b) {
            return Double.compare(a[1], b[1]);
        }
    });
    PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
        @Override
        public int compare(double[] a, double[] b) {
            return Double.compare(b[0], a[0]);
        }
    });
    for (double[] worker : workers) {
        sum += worker[0];
        pq.offer(worker);
        if (pq.size() > K) {
            sum -= pq.poll()[0];
        }
        if (pq.size() == K) {
            ans = Math.min(ans, sum * worker[1]);
        }
    }
    return ans;
}




