
/*

Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number. 
Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].
According to the example above:
equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 

*/

/*

O(m*(V+E)),O(V+E)

*/

public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    int n = equations.size(), m = queries.size();
    double[] ans = new double[m];
    Map<String, Map<String, Double>> adj = new HashMap<>();
    for (int i = 0; i < n; ++i) {
        String u = equations.get(i).get(0), v = equations.get(i).get(1);
        double w = values[i];
        adj.putIfAbsent(u, new HashMap<>());
        adj.putIfAbsent(v, new HashMap<>());
        adj.get(u).put(v, w);
        adj.get(v).put(u, 1 / w);
    }
    for (int i = 0; i < m; ++i) {
        String u = queries.get(i).get(0), v = queries.get(i).get(1);
        if (adj.containsKey(u) && adj.containsKey(v)) {
            if (u.equals(v)) ans[i] = 1.0;
            else {
                Set<String> vis = new HashSet<>();
                vis.add(u);
                double val = dfs(adj, vis, u, v, 1.0);
                ans[i] = val != 0 ? val : -1.0;
            }
        } else ans[i] = -1.0;
    }
    return ans;
}

private double dfs(Map<String, Map<String, Double>> adj, Set<String> vis, String u, String v, double cur) {
    if (adj.get(u).containsKey(v)) return cur * adj.get(u).get(v);
    double ans = 0;
    for (String nxt : adj.get(u).keySet()) {
        if (vis.add(nxt)) {
            ans = dfs(adj, vis, nxt, v, cur * adj.get(u).get(nxt));
            if (ans != 0) break;
        }
    }
    return ans;
}





