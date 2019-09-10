
/*

Given a blacklist B containing unique integers from [0, N), 
write a function to return a uniform random integer from [0, N) which is NOT in B.
Optimize it such that it minimizes the call to system’s Math.random().
Note:
1 <= N <= 1000000000
0 <= B.length < min(100000, N)
[0, N) does NOT include N. See interval notation.

Example 1:
Input: 
["Solution","pick","pick","pick"]
[[1,[]],[],[],[]]
Output: [null,0,0,0]

Example 2:
Input: 
["Solution","pick","pick","pick"]
[[2,[]],[],[],[]]
Output: [null,1,1,1]

Example 3:
Input: 
["Solution","pick","pick","pick"]
[[3,[1]],[],[],[]]
Output: [null,0,0,2]

Example 4:
Input: 
["Solution","pick","pick","pick"]
[[4,[2]],[],[],[]]
Output: [null,1,3,1]

*/

/*

Solution: swap the elements in the blacklist with the current last valid element
O(n),O(n)

*/

class Solution {
    private Map<Integer, Integer> map;
    private Random rand;
    private int size;

    public Solution(int N, int[] blacklist) {
        this.map = new HashMap<>();
        this.rand = new Random();
        for (int num : blacklist) {
            map.put(num, -1);
        }
        this.size = N - map.size();
        for (int num : blacklist) {
            if (num < size) {
                while (map.containsKey(N - 1)) {
                    N--;
                }
                map.put(num, N - 1);
                N--;
            }
        }
    }
    
    public int pick() {
        int ans = rand.nextInt(size);
        if (map.containsKey(ans)) {
            return map.get(ans);
        }
        return ans;
    }
}




