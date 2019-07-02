
/*

Given an array of prices [p1,p2...,pn] and a target, round each price pi to Roundi(pi) so that the rounded array [Round1(p1),
Round2(p2)...,Roundn(pn)] sums to the given target. Each operation Roundi(pi) could be either Floor(pi) or Ceil(pi).
Return the string "-1" if the rounded array is impossible to sum to target.
Otherwise, return the smallest rounding error, which is defined as Σ |Roundi(pi) - (pi)| for i from 1 to n,
as a string with three places after the decimal.

Example 1:
Input: prices = ["0.700","2.800","4.900"], target = 8
Output: "1.000"
Explanation: 
Use Floor, Ceil and Ceil operations to get (0.7 - 0) + (3 - 2.8) + (5 - 4.9) = 0.7 + 0.2 + 0.1 = 1.0 .

Example 2:
Input: prices = ["1.500","2.500","3.500"], target = 10
Output: "-1"
Explanation: 
It is impossible to meet the target.

*/

/*

Solution 1: dp[i][j] means the min error to get value j with prices[0...i]
            dp[i][j]=min(dp[i-1][j-floor],dp[i-1][j-ceil])
O(n^2),O(n^2)            

*/

public String minimizeError(String[] prices, int target) {
    int n = prices.length;
    Map<Integer, Double>[] dp = new HashMap[n + 1];
    dp[0] = new HashMap<>();
    dp[0].put(0, 0.0);
    for (int i = 1; i <= n; ++i) {
        double price = Double.valueOf(prices[i - 1]);
        int floor = (int)Math.floor(price);
        int ceil = (int)Math.ceil(price);
        double lower = price - floor;
        double upper = ceil - price;
        dp[i] = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : dp[i - 1].entrySet()) {
            int floorKey = entry.getKey() + floor;
            int ceilKey = entry.getKey() + ceil;
            dp[i].put(floorKey, Math.min(dp[i].getOrDefault(floorKey, Double.MAX_VALUE), entry.getValue() + lower));
            dp[i].put(ceilKey, Math.min(dp[i].getOrDefault(ceilKey, Double.MAX_VALUE), entry.getValue() + upper));
        }
    }
    return dp[n].containsKey(target) ? String.format("%.3f", dp[n].get(target)) : "-1" ;
}


/*

Solution 2: first use all floors, use a priority queue to track min error
            keep changing one to use ceil, and update target until we get target
O(nlogn),O(n)            

*/

class Tuple implements Comparable<Tuple> {
    private int price;
    private double diff;

    Tuple(int price, double diff) {
        this.price = price;
        this.diff = diff;
    }

    @Override
    public int compareTo(Tuple t) {
        return (int)((t.diff - this.diff) * 1000);
    }
}

public String minimizeError(String[] prices, int target) {
    PriorityQueue<Tuple> pq = new PriorityQueue<>();
    for (String price : prices) {
        Double p = Double.valueOf(price);
        int floor = (int)Math.floor(p);
        pq.offer(new Tuple(floor, p % 1));
        target -= floor;
    }
    if (target < 0 || target > pq.size()) {
        return "-1";
    }
    double diff = 0;
    while (!pq.isEmpty()) {
        Tuple cur = pq.poll();
        if (target != 0 && cur.diff != 0) {
            target--;
            diff += 1 - cur.diff;
        } else {
            diff += cur.diff;
        }
    }
    if (target > 0) {
        return "-1";
    }
    return String.format("%.3f", diff);
}



