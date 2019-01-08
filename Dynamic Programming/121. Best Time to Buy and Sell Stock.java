
/*

Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.

Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
             
Example 2:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*/

/*

Solution 1: track the minimum price before the current one, and update the (price-min)
O(n),O(1(

*/

public int maxProfit(int[] prices) {
    int ans = 0, min = Integer.MAX_VALUE;
    for (int price : prices) {
        min = Math.min(min, price);
        ans = Math.max(ans, price - min);
    }
    return ans;
}


/*

Solution 2: F_i10 means the maximum profit in ith day with 1 transaction and 0 means no stock in hand
            F_i11 means the maximum profit in ith day with 1 transaction and 1 means stock in hand
            F_i10=max(F_i10,F_i11+price) means sell it in ith day
            F_i11=max(F_i11,F_i00-price) which is max(F_i11,0-price) means buy it in ith day
O(n),O(1)            

*/

public int maxProfit(int[] prices) {
    int F_i10 = 0, F_i11 = Integer.MIN_VALUE;
    for (int price : prices) {
        F_i10 = Math.max(F_i10, F_i11 + price);
        F_i11 = Math.max(F_i11, -price);
    }
    return F_i10;
}



