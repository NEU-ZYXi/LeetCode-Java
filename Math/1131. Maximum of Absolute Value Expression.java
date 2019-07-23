
/*

Given two arrays of integers with equal lengths, return the maximum value of:
|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
where the maximum is taken over all 0 <= i, j < arr1.length.

Example 1:
Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
Output: 13

Example 2:
Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
Output: 20

*/

/*

Solution: |arr1[i]-arr1[j]|+|arr2[i]-arr2[j]|+|i-j| has four cases
          1. (arr1[i]+arr2[i]+i)-(arr1[j]+arr2[j]+j)
          2. (arr1[i]-arr2[i]+i)-(arr1[j]-arr2[j]+j)
          3. (-arr1[i]+arr2[i]+i)-(-arr1[j]+arr2[j]+j)
          4. (-arr1[i]-arr2[i]+i)-(-arr1[j]-arr2[j]+j)
          to find max, make sure the right part is min
O(n),O(1)          

*/

public int maxAbsValExpr(int[] arr1, int[] arr2) {
    int ans = 0;
    int min1 = arr1[0] + arr2[0];
    int min2 = arr1[0] - arr2[0];
    int min3 = -arr1[0] + arr2[0];
    int min4 = -arr1[0] - arr2[0];
    for (int i = 1; i < arr1.length; ++i) {
        int cur1 = arr1[i] + arr2[i] + i;
        int cur2 = arr1[i] - arr2[i] + i;
        int cur3 = -arr1[i] + arr2[i] + i;
        int cur4 = -arr1[i] - arr2[i] + i;
        ans = Math.max(ans, cur1 - min1);
        ans = Math.max(ans, cur2 - min2);
        ans = Math.max(ans, cur3 - min3);
        ans = Math.max(ans, cur4 - min4);
        min1 = Math.min(min1, cur1);
        min2 = Math.min(min2, cur2);
        min3 = Math.min(min3, cur3);
        min4 = Math.min(min4, cur4);
    }
    return ans;
}



