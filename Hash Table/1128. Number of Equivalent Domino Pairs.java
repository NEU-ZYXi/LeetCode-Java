
/*

Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] 
if and only if either (a==c and b==d), or (a==d and b==c) 
that is, one domino can be rotated to be equal to another domino.
Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

Example 1:
Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1

*/

/*

O(n),O(n)

*/

public int numEquivDominoPairs(int[][] dominoes) {
    Map<String, Integer> map = new HashMap<>();
    int ans = 0;
    for (int[] domino : dominoes) {
        String s1 = domino[0] + "," + domino[1];
        String s2 = domino[1] + "," + domino[0];
        if (map.containsKey(s1)) {
            ans += map.get(s1);
            map.put(s1, map.get(s1) + 1);
            continue;
        } 
        if (map.containsKey(s2)) {
            ans += map.get(s2);
            map.put(s2, map.get(s2) + 1);
            continue;
        }
        map.put(s1, 1);
    }
    return ans;
}



