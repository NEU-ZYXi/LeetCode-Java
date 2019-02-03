
/*

There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, 
for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
             
Example 2:
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

*/

/*

Solution 1: topological sorting, Kahn's algorithm
O(V+E),O(E)

*/

public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] adj = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; ++i) adj[i] = new ArrayList<>();
    int[] indegree = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
        int u = prerequisite[1], v = prerequisite[0];
        adj[u].add(v);
        indegree[v]++;
    }
    int ans = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; ++i) {
        if (indegree[i] == 0) {
            queue.offer(i);
            ans++;
        }
    }
    while (!queue.isEmpty()) {
        int u = queue.poll();
        for (int v : adj[u]) {
            indegree[v]--;
            if (indegree[v] == 0) {
                ans++;
                queue.offer(v);
            }
        }
    }
    return ans == numCourses;
}


/*

Solution 2: three colors DFS, mark each node as visited, checked and unvisited
            vistied[u]=true if we visit u in DFS
            checked[u]=true if all the neighbors of u are not in any cycle
O(V+E),O(E)            

*/

public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] adj = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; ++i) adj[i] = new ArrayList<>();
    for (int[] prerequisite : prerequisites) {
        int u = prerequisite[1], v = prerequisite[0];
        adj[u].add(v);
    }
    boolean[] checked = new boolean[numCourses], visited = new boolean[numCourses];
    for (int i = 0; i < numCourses; ++i) {
        if (dfs(adj, visited, checked, i)) return false;
    }
    return true;
}

private boolean dfs(List<Integer>[] adj, boolean[] visited, boolean[] checked, int u) {
    if (checked[u]) return false;
    else if (visited[u]) return true;
    else visited[u] = true;
    for (int v : adj[u]) {
        if (dfs(adj, visited, checked, v)) return true;
    }
    checked[u] = true;
    return false;
}




