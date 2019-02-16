
/*

There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.

Example 1:
Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
Output: "wertf"

Example 2:
Input:
[
  "z",
  "x"
]
Output: "zx"

Example 3:
Input:
[
  "z",
  "x",
  "z"
] 
Output: "" 
Explanation: The order is invalid, so return "".

*/

/*

O(V+E),O(E)

*/

public String alienOrder(String[] words) {
    Map<Character, Set<Character>> adj = new HashMap<>();
    Map<Character, Integer> indegree = new HashMap<>();
    for (String word : words) {
        for (char c : word.toCharArray()) indegree.put(c, 0);
    }
    for (int i = 1; i < words.length; ++i) {
        String prev = words[i - 1], cur = words[i];
        for (int j = 0; j < Math.min(prev.length(), cur.length()); ++j) {
            char u = prev.charAt(j), v = cur.charAt(j);
            if (u != v) {
                adj.putIfAbsent(u, new HashSet<>());
                if (adj.get(u).add(v)) indegree.put(v, indegree.get(v) + 1);
                break;
            }
        }
    }
    Queue<Character> queue = new LinkedList<>();
    String ans = "";
    for (char c : indegree.keySet()) {
        if (indegree.get(c) == 0) {
            queue.offer(c);
            ans += c;
        }
    }
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            char u = queue.poll();
            if (adj.containsKey(u)) {
                for (char v : adj.get(u)) {
                    indegree.put(v, indegree.get(v) - 1);
                    if (indegree.get(v) == 0) {
                        queue.offer(v);
                        ans += v;
                    }
                }
            }
        }
    }
    if (ans.length() != indegree.size()) return "";
    return ans;
}




