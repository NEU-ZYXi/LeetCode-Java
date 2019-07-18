
/*

Return the result of evaluating a given boolean expression, represented as a string.
An expression can either be:
"t", evaluating to True;
"f", evaluating to False;
"!(expr)", evaluating to the logical NOT of the inner expression expr;
"&(expr1,expr2,...)", evaluating to the logical AND of 2 or more inner expressions expr1, expr2, ...;
"|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner expressions expr1, expr2, ...
 
Example 1:
Input: expression = "!(f)"
Output: true

Example 2:
Input: expression = "|(f,t)"
Output: true

Example 3:
Input: expression = "&(t,f)"
Output: false

Example 4:
Input: expression = "|(&(t,f,t),!(t))"
Output: false

*/

/*

O(n),O(n)

*/

public boolean parseBoolExpr(String expression) {
    Deque<Character> deque = new ArrayDeque<>();
    for (int i = 0; i < expression.length(); ++i) {
        char c = expression.charAt(i);
        if (c == ')') {
            Set<Character> bools = new HashSet<>();
            while (!deque.isEmpty() && deque.peekLast() != '(') {
                bools.add(deque.pollLast());
            }
            deque.pollLast();
            char op = deque.pollLast();
            if (op == '&') {
                deque.offerLast(bools.contains('f') ? 'f' : 't');
            } else if (op == '|') {
                deque.offerLast(bools.contains('t') ? 't' : 'f');
            } else if (op == '!') {
                deque.offerLast(bools.contains('t') ? 'f' : 't');
            }
        } else if (c != ',') {
            deque.offerLast(c);
        }
    }
    return deque.peekLast() == 't';
}



