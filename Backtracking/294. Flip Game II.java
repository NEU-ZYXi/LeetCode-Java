
/*

You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, 
you and your friend take turns to flip two consecutive "++" into "--". 
The game ends when a person can no longer make a move and therefore the other person will be the winner.
Write a function to determine if the starting player can guarantee a win.

Example:
Input: s = "++++"
Output: true 
Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".

*/

/*

T(n)=(n-2)*T(n-2)=(n-2)*(n-4)*...=O(n!!),O(n^2)

*/

public boolean canWin(String s) {
    Map<String, Boolean> memo = new HashMap<>();
    return dfs(memo, s);
}

private boolean dfs(Map<String, Boolean> memo, String s) {
    if (memo.containsKey(s)) return memo.get(s);
    for (int i = 1; i < s.length(); ++i) {
        if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
            String nxt = s.substring(0, i - 1) + "--" + s.substring(i + 1);
            if (!dfs(memo, nxt)) {
                memo.put(s, true);
                return true;
            }
        }
    }
    memo.put(s, false);
    return false;
}



