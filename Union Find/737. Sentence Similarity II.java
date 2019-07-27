
/*

Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, 
determine if two sentences are similar.
For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar,
if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
Note that the similarity relation is transitive. 
For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.
Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
Also, a word is always similar with itself. 
For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, 
even though there are no specified similar word pairs.
Finally, sentences can only be similar if they have the same number of words.
So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

*/

/*

Solution 1: build the graph, and for each words1[i], DFS to find whether there is a way to words2[i]
O(n^2),O(n)

*/

public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
    int n = words1.length;
    if (words2.length != n) {
        return false;
    }
    Map<String, Set<String>> map = new HashMap<>();
    for (List<String> pair : pairs) {
        String u = pair.get(0), v = pair.get(1);
        map.putIfAbsent(u, new HashSet<>());
        map.putIfAbsent(v, new HashSet<>());
        map.get(u).add(v);
        map.get(v).add(u);
    }
    for (int i = 0; i < n; ++i) {
        if (!words1[i].equals(words2[i])) {
            if (!map.containsKey(words1[i])) {
                return false;
            }
            if (!dfs(map, new HashSet<>(), words1[i], words2[i])) {
                return false;
            }
        }
    }
    return true;
}

private boolean dfs(Map<String, Set<String>> map, Set<String> vis, String start, String end) {
    if (map.get(start).contains(end)) {
        return true;
    }
    if (vis.add(start)) {
        for (String next : map.get(start)) {
            if (!vis.contains(next) && dfs(map, vis, next, end)) {
                return true;
            }
        }
    }
    return false;
}


/*

Solution 2: union find each similar words pair
O(n),O(n)

*/

public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
    int n = words1.length;
    if (words2.length != n) {
        return false;
    }
    Map<String, String> map = new HashMap<>();
    for (List<String> pair : pairs) {
        String u = pair.get(0), v = pair.get(1);
        if (!find(map, u).equals(find(map, v))) {
            union(map, u, v);
        }
    }
    for (int i = 0; i < n; ++i) {
        if (!words1[i].equals(words2[i]) && !find(map, words1[i]).equals(find(map, words2[i]))) {
            return false;
        }
    }
    return true;
}

private String find(Map<String, String> map, String s) {
    if (!map.containsKey(s)) {
        map.put(s, s);
    }
    while (!s.equals(map.get(s))) {
        s = map.get(s);
        map.put(map.get(s), map.get(map.get(s)));
    }
    return s;
}

private void union(Map<String, String> map, String p, String q) {
    String rootP = find(map, p), rootQ = find(map, q);
    map.put(rootQ, rootP);
}


/*

Solution 3: union find using (word,index)
O(n),O(n)

*/

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; ++i) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    public int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
            parent[i] = parent[parent[i]];
        }
        return i;
    }

    public void union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) {
            return;
        } else if (rank[rootP] > rank[rootQ]) {
            rank[rootP] += rank[rootQ];
            parent[rootQ] = parent[rootP];
        } else {
            rank[rootQ] += rank[rootP];
            parent[rootP] = parent[rootQ];
        }
    }
}

public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
    int n = words1.length;
    if (words2.length != n) {
        return false;
    }
    Map<String, Integer> map = new HashMap<>();
    UnionFind uf = new UnionFind(2 * pairs.size());
    for (List<String> pair : pairs) {
        int u = getIndex(map, pair.get(0)), v = getIndex(map, pair.get(1));
        uf.union(u, v);
    }
    for (int i = 0; i < n; ++i) {
        if (!words1[i].equals(words2[i])) {
            if (!map.containsKey(words1[i]) || !map.containsKey(words2[i])) {
                return false;
            }
            int u = getIndex(map, words1[i]), v = getIndex(map, words2[i]);
            if (uf.find(u) != uf.find(v)) {
                return false;
            }
        }
    }
    return true;
}

private int getIndex(Map<String, Integer> map, String s) {
    if (map.containsKey(s)) {
        return map.get(s);
    }
    int idx = map.size();
    map.put(s, idx);
    return idx;
}




