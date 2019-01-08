
/*

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(i.e., buy one and sell one share of the stock multiple times).
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:
Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
             
Example 2:
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
             
Example 3:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*/

/*

Solution 1: if prices[i+1]>prices[i], hold the stock and accumulate the profit, otherwise, sell the stock
O(n),O(1)

*/

public int maxProfit(int[] prices) {
    int ans = 0;
    for (int i = 0; i < prices.length - 1; ++i) ans += (prices[i + 1] > prices[i]) ? prices[i + 1] - prices[i] : 0;
    return ans;
}


/*

Solution 2: F_ik0 means the maximum profit in ith day with k transaction and 0 means no stock in hand
            F_ik1 means the maximum profit in ith day with k transaction and 1 means stock in hand
            F_ik0=max(F_ik0,F_ik1+price) means sell it in ith day
            F_ik1=max(F_ik1,F_i(k-1)0-price) means buy it in ith day, use a tmp to track F_i(k-1)0 as F_ik0
O(n),O(1)            

*/

public int maxProfit(int[] prices) {
    int F_ik0 = 0, F_ik1 = Integer.MIN_VALUE;
    for (int price : prices) {
        int tmp = F_ik0;
        F_ik0 = Math.max(F_ik0, F_ik1 + price);
        F_ik1 = Math.max(F_ik1, tmp - price);
    }
    return F_ik0;
}



