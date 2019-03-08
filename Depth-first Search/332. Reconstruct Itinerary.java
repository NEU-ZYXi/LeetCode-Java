
/*

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
reconstruct the itinerary in order. 
All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order 
when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.

Example 1:
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:
Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.

*/

/*

Solution: traverse every edge which forms an Eulerian path, use Hierholzer's algo
          two cases: 1. do not have a cycle, then traverse all edges
                     2. find a cycle and start from the vertices has another outgoing edge, find another cycle
          use priority queue to get the path with smallest lexical order
O(ElogE+E)
O(V+E)

*/

public List<String> findItinerary(String[][] tickets) {
    List<String> ans = new ArrayList<>();
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    for (String[] ticket : tickets) {
        String u = ticket[0], v = ticket[1];
        adj.putIfAbsent(u, new PriorityQueue<String>());
        adj.get(u).offer(v);
    }
    dfs(ans, adj, "JFK");
    return ans;
}

private void dfs(List<String> ans, Map<String, PriorityQueue<String>> adj, String u) {
    PriorityQueue<String> nxt = adj.get(u);
    while (nxt != null && !nxt.isEmpty()) dfs(ans, adj, nxt.poll());
    ans.add(0, u);
}




