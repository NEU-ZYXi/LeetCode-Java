
/*

A sorted list A contains 1, plus some number of primes. 
Then, for every p < q in the list, we consider the fraction p/q.
What is the K-th smallest fraction considered? 
Return your answer as an array of ints, where answer[0] = p and answer[1] = q.

Examples:
Input: A = [1, 2, 3, 5], K = 3
Output: [2, 5]
Explanation:
The fractions to be considered in sorted order are:
1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
The third fraction is 2/5.
Input: A = [1, 7], K = 1
Output: [1, 7]

*/

/*

Solution 1: use a priority queue to store all fractions in acsending order
            add all fractions A[0...n-2]/A[n-1] into the priority queue
            pop each one as A[a]/A[b] and then add A[a]/A[b-1] into priority queue since it's the next smallest fraction
O(klogk),O(k)            

*/

public int[] kthSmallestPrimeFraction(int[] A, int K) {
    int n = A.length;
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return A[a[0]] * A[b[1]] - A[a[1]] * A[b[0]];
        }
    });
    for (int i = 0; i < n - 1; ++i) {
        if (i == K) {
            break;
        }
        pq.offer(new int[] {i, n - 1});
    }
    while (!pq.isEmpty()) {
        if (--K == 0) {
            break;
        }
        int[] cur = pq.poll();
        cur[1]--;
        if (cur[1] > cur[0]) {
            pq.offer(new int[] {cur[0], cur[1]});
        }
    }
    return new int[] {A[pq.peek()[0]], A[pq.peek()[1]]};
}


/*

Solution 2:

*/





