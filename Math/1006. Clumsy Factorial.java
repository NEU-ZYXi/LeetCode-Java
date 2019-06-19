
/*

Normally, the factorial of a positive integer n is the product of all positive integers less than or equal to n.  
For example, factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1.
We instead make a clumsy factorial: using the integers in decreasing order, 
we swap out the multiply operations for a fixed rotation of operations: 
multiply (*), divide (/), add (+) and subtract (-) in this order.
For example, clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1.  
However, these operations are still applied using the usual order of operations of arithmetic: 
we do all multiplication and division steps before any addition or subtraction steps, 
and multiplication and division steps are processed left to right.
Additionally, the division that we use is floor division such that 10 * 9 / 8 equals 11.  
This guarantees the result is an integer.
Implement the clumsy function as defined above: given an integer N, it returns the clumsy factorial of N.

Example 1:
Input: 4
Output: 7
Explanation: 7 = 4 * 3 / 2 + 1

Example 2:
Input: 10
Output: 12
Explanation: 12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1

*/

/*

Solution 1: use a deque to simulate the process
O(n),O(n)

*/

public int clumsy(int N) {
    Deque<Integer> deque = new ArrayDeque<>();
    char[] ops = new char[] {'*', '/', '+', '-'};
    int ans = 0, idx = 0;
    deque.offerLast(N--);
    while (N > 0) {
        if (ops[idx] == '*') {
            deque.offerLast(deque.pollLast() * N--);
        } else if (ops[idx] == '/') {
            deque.offerLast(deque.pollLast() / N--);
        } else if (ops[idx] == '+') {
            deque.offerLast(N--);
        } else if (ops[idx] == '-') {
            deque.offerLast(-1 * N--);
        }
        idx = (idx + 1) % 4;
    } 
    while (!deque.isEmpty()) {
        ans += deque.pollLast();
    }
    return ans;
}


/*

Solution 2: separate into two parts, (a*b/c)+(d-e...) and for second part, (a-b*c/d)+(e-f...)
            recursively solve each second parts
O(n),O(1)            

*/

public int clumsy(int N) {
    if (N == 0) {
        return 0;
    } else if (N == 1) {
        return 1;
    } else if (N == 2) {
        return 2;
    } else if (N == 3) {
        return 6;
    }
    return N * (N - 1) / (N - 2) + solve(N - 3);
}

private int solve(int N) {
    if (N == 0) {
        return 0;
    } else if (N == 1) {
        return 1;
    } else if (N == 2) {
        return 1;
    } else if (N == 3) {
        return 1;
    }
    return N - (N - 1) * (N - 2) / (N - 3) + solve(N - 4);
}



