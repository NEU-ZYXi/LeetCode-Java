
/*

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

*/

/*

Solution 1: O(nlogn),O(k)

*/

public int[][] kClosest(int[][] points, int K) {
    Arrays.sort(points, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
        }
    });
    int[][] ans = new int[K][2];
    for (int i = 0; i < K; ++i) {
        ans[i] = points[i];
    }
    return ans;
}


/*

Solution 2: O(nlogk),O(k)

*/

public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1];
        }
    });
    for (int[] point : points) {
        pq.offer(point);
        if (pq.size() > K) {
            pq.poll();
        }
    }
    int[][] ans = new int[K][2];
    for (int i = 0; i < K; ++i) {
        ans[i] = pq.poll();
    }
    return ans;
}


/*

Solution 3: O(n),O(n)

*/

public int[][] kClosest(int[][] points, int K) {
    int l = 0, r = points.length - 1;
    while (l < r) {
        int pivot = partition(points, l, r);
        if (pivot == K) {
            break;
        } else if (pivot > K) {
            r = pivot - 1;
        } else {
            l = pivot + 1;
        }
    }
    int[][] ans = new int[K][2];
    for (int i = 0; i < K; ++i) {
        ans[i] = points[i];
    }
    return ans;
}

private int partition(int[][] points, int l, int r) {
    int pivot = l;
    while (l <= r) {
        while (l <= r && compare(points[l], points[pivot]) <= 0) {
            l++;
        }
        while (l <= r && compare(points[pivot], points[r]) <= 0) {
            r--;
        }
        if (l > r) {
            break;
        }
        swap(points, l, r);
    }
    swap(points, pivot, r);
    return r;
}

private int compare(int[] a, int[] b) {
    return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
}

private void swap(int[][] points, int i, int j) {
    int[] tmp = points[i];
    points[i] = points[j];
    points[j] = tmp;
}




