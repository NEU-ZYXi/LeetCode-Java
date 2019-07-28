
/*

Given an array of integers A, return the largest integer that only occurs once.
If no integer occurs once, return -1.

Example 1:
Input: [5,7,3,9,4,9,8,3,1]
Output: 8
Explanation: 
The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it's the answer.

Example 2:
Input: [9,9,8,8]
Output: -1
Explanation: 
There is no number that occurs only once.

*/

/*

O(n),O(n)

*/

public int largestUniqueNumber(int[] A) {
    int max = 0, ans = 0;
    for (int a : A) {
        max = Math.max(max, a);
    }
    int[] buckets = new int[max + 1];
    for (int a : A) {
        buckets[a]++;
    }
    for (int i = max; i >= 0; --i) {
        if (buckets[i] == 1) {
            return i;
        }
    }
    return -1;
}



