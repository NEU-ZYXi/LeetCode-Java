
/*

Given two numbers arr1 and arr2 in base -2, return the result of adding them together.
Each number is given in array format:  as an array of 0s and 1s, from most significant bit to least significant bit.  
For example, arr = [1,1,0,1] represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.  
A number arr in array format is also guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.
Return the result of adding arr1 and arr2 in the same format: as an array of 0s and 1s with no leading zeros. 

Example 1:
Input: arr1 = [1,1,1,1,1], arr2 = [1,0,1]
Output: [1,0,0,0,0]
Explanation: arr1 represents 11, arr2 represents 5, the output represents 16.

*/

/*

O(n),O(n)

*/

public int[] addNegabinary(int[] arr1, int[] arr2) {
    List<Integer> digits = new ArrayList<>();
    int i = arr1.length - 1, j = arr2.length - 1, sum = 0;
    while (i >= 0 || j >= 0 || sum != 0) {
        sum = (-1) * (sum >> 1);
        if (i >= 0) {
            sum += arr1[i--];
        }
        if (j >= 0) {
            sum += arr2[j--];
        }
        digits.add(0, sum & 1);
    }
    int idx = 0, n = digits.size();
    while (idx < n && digits.get(idx) == 0) {
        idx++;
    }
    if (idx == n) {
        return new int[] {0};
    }
    int[] ans = new int[n - idx];
    for (int k = 0; k < ans.length; ++k) {
        ans[k] = digits.get(k + idx);
    }
    return ans;
}




