
/*

Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; 
and a non-negative integer fee representing a transaction fee.
You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. 
You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

*/

/*

Solution: F_ik0 means the maximum profit in ith day with k transaction and 0 means no stock in hand
          F_ik1 means the maximum profit in ith day with k transaction and 1 means stock in hand
          F_ik0=max(F_ik0,F_ik1+price-fee) means sell it in ith day with extra fee
          F_ik1=max(F_ik1,F_i(k-1)0-price) means buy it in ith day, use a tmp to track F_i(k-1)0 as F_ik0

*/

public int maxProfit(int[] prices, int fee) {
    long F_ik0 = 0, F_ik1 = Integer.MIN_VALUE;
    for (int price : prices) {
        long tmp = F_ik0;
        F_ik0 = Math.max(F_ik0, F_ik1 + price - fee);
        F_ik1 = Math.max(F_ik1, tmp - price);
    }
    return (int)F_ik0;
}




