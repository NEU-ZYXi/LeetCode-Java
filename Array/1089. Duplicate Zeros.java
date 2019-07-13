
/*

Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
Note that elements beyond the length of the original array are not written.
Do the above modifications to the input array in place, do not return anything from your function.

Example 1:
Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

Example 2:
Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]

*/

/*

O(n),O(1)

*/

public void duplicateZeros(int[] arr) {
    int cnt = 0, n = arr.length;
    for (int a : arr) {
        if (a == 0) {
            cnt++;
        }
    }
    for (int i = n - 1, j = n + cnt - 1; i < j; --i, --j) {
        if (arr[i] != 0) {
            if (j < n) {
                arr[j] = arr[i];
            }
        } else {
            if (j < n) {
                arr[j] = arr[i];
            }
            j--;
            if (j < n) {
                arr[j] = arr[i];
            }
        }
    }
}



