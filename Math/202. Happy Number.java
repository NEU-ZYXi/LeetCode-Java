
/*

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 
Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

*/

/*

O(n),O(n)

*/

public boolean isHappy(int n) {
    Set<Integer> visited = new HashSet<>();
    while (visited.add(n)) {
        int sum = 0;
        while (n != 0) {
            int remain = n % 10;
            sum += remain * remain;
            n /= 10;
        }
        if (sum == 1) return true;
        n = sum;
    }
    return false;
}




