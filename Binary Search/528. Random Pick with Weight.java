
/*

Given an array w of positive integers, where w[i] describes the weight of index i, 
write a function pickIndex which randomly picks an index in proportion to its weight.

Example 1:
Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]

Example 2:
Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]

*/

/*

Solution: sum up weights, randomly pick one value and use binary search to find which weight it locates
O(logn),O(n)

*/

class Solution {  
    private int[] sum;
    private Random rand;

    public Solution(int[] w) {
        int n = w.length;
        this.sum = new int[n];
        sum[0] = w[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + w[i];
        }
        this.rand = new Random();
    }
    
    public int pickIndex() {
        int n = sum.length;
        int randInt = rand.nextInt(sum[n - 1]) + 1;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (sum[mid] == randInt) {
                return mid;
            } else if (sum[mid] > randInt) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}




