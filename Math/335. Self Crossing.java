
/*

You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, 
then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. 
In other words, after each move your direction changes counter-clockwise.
Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.

Example 1:
┌───┐
│   │
└───┼──>
    │
Input: [2,1,1,2]
Output: true

Example 2:
┌──────┐
│      │
│
│
└────────────>
Input: [1,2,3,4]
Output: false 

Example 3:
┌───┐
│   │
└───┼>
Input: [1,1,1,1]
Output: true 

*/

/*

Solution: three cases of self crossing
          1.     i-2
             i-1┌─┐
                └─┼─>i
                 i-3
                 
          2.      i-2
             i-1 ┌────┐
                 └─══>┘i-3  where i overlap i-4
                 i  i-4   
          
          3.   i-4
               ┌──┐ 
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2
*/

public boolean isSelfCrossing(int[] x) {
    for (int i = 3; i < x.length; ++i) {
        if (x[i - 3] >= x[i - 1] && x[i] >= x[i - 2]) return true;
        else if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) return true;
        else if (i >= 5 && x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2]
                && x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3]) return true;
    }
    return false;
}




