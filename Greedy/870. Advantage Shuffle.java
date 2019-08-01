
/*

Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
Return any permutation of A that maximizes its advantage with respect to B.

Example 1:
Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]

Example 2:
Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]

*/

/*

Solution: greedily use largest elements in A to fit largest elements in B
          use a priority queue to store elements in B in desending order, and sort A in ascending order
          for each element in priority queue, find a possible large element in A to fit it
O(nlogn),O(n)          

*/

public int[] advantageCount(int[] A, int[] B) {
    int n = A.length;
    int[] ans = new int[n];
    Arrays.sort(A);
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return b[0] - a[0];
        }
    });
    for (int i = 0; i < n; ++i) {
        pq.offer(new int[] {B[i], i});
    }
    int l = 0, r = n - 1;
    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int val = cur[0], idx = cur[1];
        if (A[r] > val) {
            ans[idx] = A[r];
            r--;
        } else {
            ans[idx] = A[l];
            l++;
        }
    }
    return ans;
}



