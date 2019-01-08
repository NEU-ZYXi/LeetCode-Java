
/*

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:
Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
             
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

Solution: F_i10 means the maximum profit in ith day with 1 transaction and 0 means no stock in hand
          F_i11 means the maximum profit in ith day with 1 transaction and 1 means stock in hand
          F_i20 means the maximum profit in ith day with 2 transactions and 0 means no stock in hand
          F_i21 means the maximum profit in ith day with 2 transactions and 1 means stock in hand
        
          F_i10=max(F_i10,F_i11+price) means sell it in ith day
          F_i11=max(F_i11,F_i00-price)=max(F_i11,-price) means buy it in ith day
          F_i20=max(F_i20,F_i21+price) means sell it second time in ith day
          F_i21=max(F_i21,F_i10-price) means buy it second time in ith day
O(n),O(1)          
*/

public int maxProfit(int[] prices) {
    int F_i10 = 0, F_i11 = Integer.MIN_VALUE, F_i20 = 0, F_i21 = Integer.MIN_VALUE;
    for (int price : prices) {
        F_i10 = Math.max(F_i10, F_i11 + price);
        F_i11 = Math.max(F_i11, -price);
        F_i20 = Math.max(F_i20, F_i21 + price);
        F_i21 = Math.max(F_i21, F_i10 - price);
    }
    return F_i20;
}



