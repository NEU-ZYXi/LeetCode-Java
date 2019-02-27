
/*

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like with the following restrictions:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:
Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]

*/

/*

Solution: F_ik0 means the maximum profit in ith day with k transaction and 0 means no stock in hand
          F_ik1 means the maximum profit in ith day with k transaction and 1 means stock in hand
          F_ik0_prev tracks the prev state of F_ik0
          F_ik0=max(F_ik0,F_ik1+price) means sell it on ith day
          F_ik1=max(F_ik1,F_ik0_prev-price) means buy it on ith day since we need one day for cool down
O(n),O(1)

*/

public int maxProfit(int[] prices) {
    int F_ik0 = 0, F_ik1 = Integer.MIN_VALUE, F_ik0_prev = 0;
    for (int price : prices) {
        int tmp = F_ik0;
        F_ik0 = Math.max(F_ik0, F_ik1 + price);
        F_ik1 = Math.max(F_ik1, F_ik0_prev - price);
        F_ik0_prev = tmp;
    }
    return F_ik0;
}




