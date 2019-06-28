
/*

Students are asked to stand in non-decreasing order of heights for an annual photo.
Return the minimum number of students not standing in the right positions.  
(This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)

Example 1:
Input: [1,1,4,2,1,3]
Output: 3
Explanation: 
Students with heights 4, 3 and the last 1 are not standing in the right positions.

*/

/*

O(nlogn),O(n)

*/

public int heightChecker(int[] heights) {
    int n = heights.length, ans = 0;
    int[] sorted = Arrays.copyOf(heights, n);
    Arrays.sort(sorted);
    for (int i = 0; i < n; ++i) {
        if (heights[i] != sorted[i]) {
            ans++;
        }
    }
    return ans;
}



