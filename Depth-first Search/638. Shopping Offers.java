
/*

In LeetCode Store, there are some kinds of items to sell. Each item has a price.
However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.
You are given the each item's price, a set of special offers, and the number we need to buy for each item. 
The job is to output the lowest price you have to pay for exactly certain items as given, 
where you could make optimal use of the special offers.
Each special offer is represented in the form of an array, 
the last number represents the price you need to pay for this special offer, 
other numbers represents how many specific items you could get if you buy this offer.
You could use any of special offers as many times as you want.

Example 1:
Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
Output: 14
Explanation: 
There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.

Example 2:
Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
Output: 11
Explanation: 
The price of A is $2, and $3 for B, $4 for C. 
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C. 
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C. 
You cannot add more items, though only $9 for 2A ,2B and 1C.

*/

/*

O(nm),O(nm)

*/

public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    Map<List<Integer>, Integer> memo = new HashMap<>();
    return dfs(price, special, needs, memo);
}

private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
    if (memo.containsKey(needs)) {
        return memo.get(needs);
    }
    int ans = noSpecial(price, needs);
    for (int i = 0; i < special.size(); ++i) {
        List<Integer> offer = special.get(i);
        if (isValid(offer, needs)) {
            List<Integer> next = new ArrayList<>();
            for (int j = 0; j < needs.size(); ++j) {
                next.add(needs.get(j) - offer.get(j));
            }
            ans = Math.min(ans, dfs(price, special, next, memo) + offer.get(offer.size() - 1));
        }
    }
    memo.put(needs, ans);
    return ans;
}

private int noSpecial(List<Integer> price, List<Integer> needs) {
    int ans = 0;
    for (int i = 0; i < price.size(); ++i) {
        ans += needs.get(i) * price.get(i);
    }
    return ans;
}

private boolean isValid(List<Integer> offer, List<Integer> needs) {
    for (int i = 0; i < needs.size(); ++i) {
        if (offer.get(i) > needs.get(i)) {
            return false;
        }
    }
    return true;
}




