
/*

There are 2N people a company is planning to interview. 
The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

Example 1:
Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.
The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

*/

/*

Solution: sort the array by its difference of cost[0] and cost[1] which is A-B
          greedily get the first half as the cities to A because A is smaller than B
O(nlogn),O(1)          

*/

public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - a[1] - (b[0] - b[1]);
        }
    });
    int ans = 0;
    for (int i = 0; i < costs.length / 2; ++i) {
        ans += costs[i][0] + costs[i + costs.length / 2][1];
    }
    return ans;
}




