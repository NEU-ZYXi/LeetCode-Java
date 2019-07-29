
/*

On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1],
where N = stations.length.
Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.
Return the smallest possible value of D.

Example:
Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000

*/

/*

Solution: binary search in [0,max(distance)] range
          for each candidate mid, count the number of extra gaps we need to get the max distance as mid
          then shrink the search range
O(nlogn),O(1)          

*/

public double minmaxGasDist(int[] stations, int K) {
    int n = stations.length;
    double low = 0, high = stations[n - 1] - stations[0];
    while (low < high - 1e-6) {
        double mid = (low + high) / 2;
        int cnt = 0;
        for (int i = 1; i < n; ++i) {
            cnt += Math.ceil((stations[i] - stations[i - 1]) / mid) - 1;
        }
        if (cnt > K) {
            low = mid;
        } else {
            high = mid;
        }
    }
    return low;
}



