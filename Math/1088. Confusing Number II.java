
/*

We can rotate digits by 180 degrees to form new digits. 
When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. 
When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.
(Note that the rotated number can be greater than the original number.)
Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.

Example 1:
Input: 20
Output: 6
Explanation: 
The confusing numbers are [6,9,10,16,18,19].
6 converts to 9.
9 converts to 6.
10 converts to 01 which is just 1.
16 converts to 91.
18 converts to 81.
19 converts to 61.

Example 2:
Input: 100
Output: 19
Explanation: 
The confusing numbers are [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].

*/

/*

Solution: for each confusing digit, backtrack to construct a number and check whether it's less than N
O(5^n),O(n)

*/

public int confusingNumberII(int N) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    map.put(1, 1);
    map.put(6, 9);
    map.put(8, 8);
    map.put(9, 6);
    int ans = 0;
    if (N == 1000000000) {
        ans++;
        N--;
    }
    return ans + dfs(map, N, 0, 0);
}

private int dfs(Map<Integer, Integer> map, int N, int cur, int idx) {
    if (idx > 9 || cur > N) {
        return 0;
    }
    int ans = 0;
    if (isConfusing(map, cur)) {
        ans++;
    }
    for (int num : map.keySet()) {
        if (num == 0 && idx == 0) {
            continue;
        }
        ans += dfs(map, N, cur * 10 + num, idx + 1);
    }
    return ans;
}

private boolean isConfusing(Map<Integer, Integer> map, int n) {
    long rot = 0;
    int tmp = n;
    while (n > 0) {
        rot = rot * 10 + map.get(n % 10);
        n /= 10;
    }
    return rot != tmp;
}




