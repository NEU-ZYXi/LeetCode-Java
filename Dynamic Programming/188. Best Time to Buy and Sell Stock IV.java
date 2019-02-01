
/*

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:
Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:
Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

*/

/*

Solution: when k>n/2 which means we could do as many transactions as possible, solve it separately
          F_ik0[j] means the maximum profit in ith day with j transaction and 0 means no stock in hand
          F_ik1[j] means the maximum profit in ith day with j transaction and 1 means stock in hand
          F_ik0[j]=max(F_ik0[j],F_ik1[j]+price) means sell it in ith day
          F_ik1[j]=max(F_ik1[j],F_ik0[j-1]-price) means buy it in ith day with j-1 transactions before
O(kn),O(k)          

*/

public int maxProfit(int k, int[] prices) {
    if (k > prices.length / 2) return maxProfit(prices);
    int[] F_ik0 = new int[k + 1];
    int[] F_ik1 = new int[k + 1];
    Arrays.fill(F_ik1, Integer.MIN_VALUE);
    for (int price : prices) {
        for (int i = 1; i <= k; ++i) {
            F_ik0[i] = Math.max(F_ik0[i], F_ik1[i] + price);
            F_ik1[i] = Math.max(F_ik1[i], F_ik0[i - 1]-price);
        }
    }
    return F_ik0[k];
}

private int maxProfit(int[] prices) {
    int F_ik0 = 0, F_ik1 = Integer.MIN_VALUE;
    for (int price : prices) {
        F_ik0 = Math.max(F_ik0, F_ik1 + price);
        F_ik1 = Math.max(F_ik1, F_ik0 - price);
    }
    return F_ik0;
}




