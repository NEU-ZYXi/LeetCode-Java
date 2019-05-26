
/*

You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
For each move, you could choose any m (1 ≤ m ≤ n) washing machines, 
and pass one dress of each washing machine to one of its adjacent washing machines at the same time .
Given an integer array representing the number of dresses in each washing machine from left to right on the line, 
you should find the minimum number of moves to make all the washing machines have the same number of dresses. 
If it is not possible to do it, return -1.

Example1
Input: [1,0,5]
Output: 3
Explanation: 
1st move:    1     0 <-- 5    =>    1     1     4
2nd move:    1 <-- 1 <-- 4    =>    2     1     3    
3rd move:    2     1 <-- 3    =>    2     2     2   

Example2
Input: [0,3,0]
Output: 2
Explanation: 
1st move:    0 <-- 3     0    =>    1     2     0    
2nd move:    1     2 --> 0    =>    1     1     1     

Example3
Input: [0,2,0]
Output: -1
Explanation: 
It's impossible to make all the three washing machines have the same number of dresses.

*/

/*

Solution: use toLeft and toRight to represent the throughput passing to left and right sides
          ans=max(toLeft+toRight,toLeft,toRight)
          for the next element, toLeft is the previous -toRight
O(n),O(1)          

*/

public int findMinMoves(int[] machines) {
    int sum = 0, n = machines.length;
    for (int machine : machines) {
        sum += machine;
    }
    if (sum % n != 0) {
        return -1;
    }
    int avg = sum / n, toLeft = 0, ans = 0;
    for (int i = 0; i < n; ++i) {
        int toRight = machines[i] - avg - toLeft;
        ans = Math.max(ans, Math.max(toLeft + toRight, Math.max(toLeft, toRight)));
        toLeft = -toRight;
    }
    return ans;
}





