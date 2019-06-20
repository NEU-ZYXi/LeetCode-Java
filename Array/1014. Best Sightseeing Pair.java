
/*

Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, 
and two sightseeing spots i and j have distance j - i between them.
The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : 
the sum of the values of the sightseeing spots, minus the distance between them.
Return the maximum score of a pair of sightseeing spots.

Example 1:
Input: [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11

*/

/*

Solution: use max to track the current max number in A[0...i]
          ans=max(ans,max+A[i]) if we don't consider j-i, with j-i which means max should decrease by 1 for each step
O(n),O(1)          

*/

public int maxScoreSightseeingPair(int[] A) {
    int ans = 0, max = 0;
    for (int a : A) {
        ans = Math.max(ans, max + a);
        max = Math.max(max, a) - 1;
    }
    return ans;
}




