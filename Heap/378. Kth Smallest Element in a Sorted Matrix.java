
/*

Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
return 13.

*/

/*

Solution 1: use binary search, count the numbers where num<=mid then find the target in either left or right part
O(nlog(max-min)),O(1)

*/

public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int l = matrix[0][0], r = matrix[n - 1][n - 1];
    while (l < r) {
        int mid = (l + r) / 2;
        int cnt = count(matrix, mid);
        if (cnt < k) l = mid + 1;
        else r = mid;
    }
    return l;
}

private int count(int[][] matrix, int num) {
    int ans = 0, n = matrix.length, j = n - 1;
    for (int i = 0; i < n; ++i) {
        while (j >= 0 && matrix[i][j] > num) j--;
        ans += j + 1;
    }
    return ans;
}


/*

Solution 2: use priority queue, put first element inside and put next k elements
O(klogk),O(k)

*/

class Tuple implements Comparable<Tuple> {
    private int x, y, val;

    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    public int compareTo(Tuple t) {
        return this.val - t.val;
    }
}

public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    PriorityQueue<Tuple> pq = new PriorityQueue<>();
    pq.offer(new Tuple(0, 0, matrix[0][0]));
    for (int i = 1; i < k; ++i) {
        Tuple tuple = pq.poll();
        if (tuple.x + 1 < n) pq.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
        if (tuple.x == 0 && tuple.y + 1 < n) pq.offer(new Tuple(tuple.x, tuple.y + 1, matrix[tuple.x][tuple.y + 1]));
    }
    return pq.poll().val;
}




