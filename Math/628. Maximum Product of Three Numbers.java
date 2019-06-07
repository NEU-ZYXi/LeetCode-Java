
/*

Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
 
Example 2:
Input: [1,2,3,4]
Output: 24

*/

/*

O(n),O(1)

*/

public int maximumProduct(int[] nums) {
    if (nums.length < 3) {
        return 0;
    }
    int min1 = 0, min2 = 0, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
    for (int num : nums) {
        if (num <= min1) {
            min2 = min1;
            min1 = num;
        } else if (num <= min2) {
            min2 = num;
        }
        if (num >= max1) {
            max3 = max2;
            max2 = max1;
            max1 = num;
        } else if (num >= max2) {
            max3 = max2;
            max2 = num;
        } else if (num >= max3) {
            max3 = num;
        }
    }
    return Math.max(max1 * min1 * min2, max1 * max2 * max3);
}



