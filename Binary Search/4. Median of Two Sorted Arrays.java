
/*

There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5

*/

/*

Solution: Assume nums1[0...i]+nums2[0...j]=sortedArray[0...half], half=(n+m+1)/2, so j=half-i
          since 0<=i<=n, then (m-n+1)/2<=j<=(n+m+1)/2, so to promise j>=0, m>=n
          use binary search to find i,j, then get the maxLeft(nums1[i-1] or nums2[j-1]) and minRight(nums1[i] or nums2[j])
O(log(min(n,m)),O(1)          

*/
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length;
    if (n > m) return findMedianSortedArrays(nums2, nums1);
    int i = 0, j = 0, imin = 0, imax = n, half = (n + m + 1) / 2, maxLeft = 0, minRight = 0;
    while (imin <= imax) {
        i = (imin + imax) / 2;
        j = half - i;
        if (i > 0 && j < m && nums1[i - 1] > nums2[j]) 
            imax = i - 1;
        else if (i < n && j > 0 && nums1[i] < nums2[j - 1])
            imin = i + 1;
        else {
            if (i == 0) maxLeft = nums2[j - 1];
            else if (j == 0) maxLeft = nums1[i - 1];
            else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
            break;
        }
    }
    if ((n + m) % 2 == 1) return maxLeft * 1.0;
    if (i == n) minRight = nums2[j];
    else if (j == m) minRight = nums1[i];
    else minRight = Math.min(nums1[i], nums2[j]);
    return (maxLeft + minRight) / 2.0;
}




