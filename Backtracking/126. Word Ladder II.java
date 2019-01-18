
/*

Given two words (beginWord and endWord), and a dictionary's word list, 
find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

*/

/*

Solution: BFS
O(26mn^2) where m is the average length of words and n is the length of word list

*/

public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> ans = new ArrayList<>();
    Set<String> dict = new HashSet<>(wordList);
    if (!dict.contains(endWord)) return ans;
    Map<String, List<String>> map = new HashMap<>();
    bfs(map, dict, beginWord, endWord);
    List<String> tmp = new ArrayList<>();
    tmp.add(beginWord);
    dfs(map, ans, tmp, beginWord, endWord);
    return ans;
}

private void bfs(Map<String, List<String>> map, Set<String> dict, String begin, String end) {
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    Set<String> toVisit = new HashSet<>();
    queue.offer(begin);
    toVisit.add(begin);
    while (!queue.isEmpty()) {
        int sz = queue.size();
        visited.addAll(toVisit);
        toVisit.clear();
        for (int i = 0; i < sz; ++i) {
            String cur = queue.poll();
            for (int j = 0; j < cur.length(); ++j) {
                char[] chars = cur.toCharArray();
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (chars[j] == c) continue;
                    chars[j] = c;
                    String nxt = new String(chars);
                    if (!visited.contains(nxt)) {
                        map.putIfAbsent(cur, new ArrayList<>());
                        map.get(cur).add(nxt);
                        if (!toVisit.contains(nxt) && dict.contains(nxt)) {
                            toVisit.add(nxt);
                            queue.offer(nxt);
                        }
                    }
                }
            }
        }
    }
}

private void dfs(Map<String, List<String>> map, List<List<String>> ans, List<String> tmp, String begin, String end) {
    if (begin.equals(end)) {
        ans.add(new ArrayList<>(tmp));
        return;
    }
    if (!map.containsKey(begin)) return;
    for (String nxt : map.get(begin)) {
        tmp.add(nxt);
        dfs(map, ans, tmp, nxt, end);
        tmp.remove(tmp.size() - 1);
    }
}


/*

Solution: bi-BFS

*/

public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> ans = new ArrayList<>();
    Set<String> dict = new HashSet<>(wordList);
    if (!dict.contains(endWord)) return ans;
    Map<String, List<String>> map = new HashMap<>();
    Set<String> begin = new HashSet<>();
    Set<String> end = new HashSet<>();
    begin.add(beginWord);
    end.add(endWord);
    bfs(map, dict, begin, end);
    List<String> tmp = new ArrayList<>();
    tmp.add(beginWord);
    dfs(map, ans, tmp, beginWord, endWord);
    return ans;
}

private void bfs(Map<String, List<String>> map, Set<String> dict, Set<String> begin, Set<String> end) {
    boolean flg = true;
    boolean rev = false;
    while (begin.size() > 0 && flg) {
        dict.removeAll(begin);
        dict.removeAll(end);
        if (begin.size() > end.size()) {
            Set<String> tmp = begin;
            begin = end;
            end = tmp;
            rev = !rev;
        }
        Set<String> set = new HashSet<>();
        for (String cur : begin) {
            for (int i = 0; i < cur.length(); ++i) {
                char[] chars = cur.toCharArray();
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (chars[i] == c) continue;
                    chars[i] = c;
                    String nxt = new String(chars);
                    if (end.contains(nxt)) {
                        flg = false;
                        List<String> list = map.getOrDefault(rev ? nxt : cur, new ArrayList<>());
                        list.add(rev ? cur : nxt);
                        map.put(rev ? nxt : cur, list);
                    }
                    if (dict.contains(nxt)) {
                        set.add(nxt);
                        List<String> list = map.getOrDefault(rev ? nxt : cur, new ArrayList<>());
                        list.add(rev ? cur : nxt);
                        map.put(rev ? nxt : cur, list);
                    }
                }
            }
        }
        begin = set;
    }
}

private void dfs(Map<String, List<String>> map, List<List<String>> ans, List<String> tmp, String begin, String end) {
    if (begin.equals(end)) {
        ans.add(new ArrayList<>(tmp));
        return;
    }
    if (!map.containsKey(begin)) return;
    for (String nxt : map.get(begin)) {
        tmp.add(nxt);
        dfs(map, ans, tmp, nxt, end);
        tmp.remove(tmp.size() - 1);
    }
}


