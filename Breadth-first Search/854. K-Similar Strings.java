
/*

Strings A and B are K-similar (for some non-negative integer K) 
if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.
Given two anagrams A and B, return the smallest K for which A and B are K-similar.

Example 1:
Input: A = "ab", B = "ba"
Output: 1

Example 2:
Input: A = "abc", B = "bca"
Output: 2

Example 3:
Input: A = "abac", B = "baca"
Output: 2

Example 4:
Input: A = "aabc", B = "abca"
Output: 2

*/

/*

Solution: find the first mismatch character and swap it to right position, BFS to get the shortest path
          each swap can make at least one character into right position, greedily make swaps every time can get the shortest
O(n^2),O(n)          

*/

public int kSimilarity(String A, String B) {
    if (A.equals(B)) {
        return 0;
    }
    Queue<String> queue = new LinkedList<>();
    Set<String> vis = new HashSet<>();
    queue.offer(A);
    vis.add(A);
    int ans = 0, n = A.length();
    while (!queue.isEmpty()) {
        ans++;
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            String cur = queue.poll();
            int j = 0;
            while (cur.charAt(j) == B.charAt(j)) {
                j++;
            }
            for (int k = j + 1; k < n; ++k) {
                if (cur.charAt(k) == B.charAt(k) || cur.charAt(j) != B.charAt(k)) {
                    continue;
                }
                String next = swap(cur, j, k);
                if (next.equals(B)) {
                    return ans;
                }
                if (vis.add(next)) {
                    queue.offer(next);
                }
            }
        }
    }
    return 0;
}

private String swap(String s, int i, int j) {
    char[] chars = s.toCharArray();
    char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
    return new String(chars);
}




