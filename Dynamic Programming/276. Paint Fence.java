
/*

There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.
Note:
n and k are non-negative integers.

Example:
Input: n = 3, k = 2
Output: 6
Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:
            post1  post2  post3      
 -----      -----  -----  -----       
   1         c1     c1     c2 
   2         c1     c2     c1 
   3         c1     c2     c2 
   4         c2     c1     c1  
   5         c2     c1     c2
   6         c2     c2     c1

*/

/*

Solution: same means the number of ways that the most adjacent two colors are the same
          diff means the number of ways that the most adjacent two colors are different
          same=diff since at most two colors can be adjacent, (i-1)th cannot have the same to match this case
          diff=(diff+same)*(k-1) since for ith, (i-1)th has (same+diff) ways in total, we have (k-1) different choices for ith
O(n),O(1)          

*/

public int numWays(int n, int k) {
    if (n == 0) return 0;
    if (n == 1) return k;
    int same = k, diff = k * (k - 1);
    for (int i = 2; i < n; ++i) {
        int tmp = diff;
        diff = (k - 1) * (diff + same);
        same = tmp;
    }
    return same + diff;
}



