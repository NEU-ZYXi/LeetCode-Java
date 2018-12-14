
/*

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

*/

/*

Solution: 从左向右遍历，记录当前maxLeft，如果遇到一个更小的height，则两者之间可以trap water，从右往左同理
          从height[l]和height[r]中较小的开始累计，则另一边相当于当前trap water的另一边界
O(n),O(1)     

*/

public int trap(int[] height) {
    int l = 0, r = height.length - 1, maxLeft = 0, maxRight = 0, ans = 0;
    while (l < r) {
        if (height[l] < height[r]) {
            if (height[l] < maxLeft) ans += maxLeft - height[l];
            else maxLeft = height[l];
            l++;
        } else {
            if (height[r] < maxRight) ans += maxRight - height[r];
            else maxRight = height[r];
            r--;
        }
    }
    return ans;
}




