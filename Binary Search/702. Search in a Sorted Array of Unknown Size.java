
/*

Given an integer array sorted in ascending order, write a function to search target in nums. 
If target exists, then return its index, otherwise return -1. However, the array size is unknown to you.
You may only access the array using an ArrayReader interface, 
where ArrayReader.get(k) returns the element of the array at index k (0-indexed).
You may assume all integers in the array are less than 10000, and if you access the array out of bounds,
ArrayReader.get will return 2147483647.

Example 1:
Input: array = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: array = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

*/

/*

O(logn),O(1)

*/

public int search(ArrayReader reader, int target) {
    int l = 0, r = 20000;
    while (l < r) {
        int mid = (l + r) / 2;
        int val = reader.get(mid);
        if (val == target) {
            return mid;
        } else if (val == Integer.MAX_VALUE || val > target) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return reader.get(l) == target ? l : -1;
}




