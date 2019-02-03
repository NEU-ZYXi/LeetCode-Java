
/*

There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, 
for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, 
return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. 
If it is impossible to finish all courses, return an empty array.

Example 1:
Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
             
Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

*/

/*

Solution 1: Kahn's algorithm for topological sort
O(V+E),O(E)

*/

public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer>[] adj = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; ++i) adj[i] = new ArrayList<>();
    int[] indegree = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
        int u = prerequisite[1], v = prerequisite[0];
        adj[u].add(v);
        indegree[v]++;
    }
    int[] ans = new int[numCourses];
    int idx = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; ++i) {
        if (indegree[i] == 0) {
            queue.offer(i);
            ans[idx++] = i;
        }
    }
    while (!queue.isEmpty()) {
        int u = queue.poll();
        for (int v : adj[u]) {
            indegree[v]--;
            if (indegree[v] == 0) {
                queue.offer(v);
                ans[idx++] = v;
            }
        }
    }
    if (idx != numCourses) return new int[0];
    else return ans;
}


/*

Solution 2: DFS for topological sort, note that the topological order is reversed in DFS part
O(V+E),O(E)

*/

public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer>[] adj = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; ++i) adj[i] = new ArrayList<>();
    for (int[] prerequisite : prerequisites) {
        int u = prerequisite[1], v = prerequisite[0];
        adj[u].add(v);
    }
    boolean[] checked = new boolean[numCourses], visited = new boolean[numCourses];
    List<Integer> ans = new LinkedList<>();
    for (int i = 0; i < numCourses; ++i) {
        if (dfs(adj, ans, checked, visited, i)) return new int[0];
    }
    int[] ret = new int[numCourses];
    for (int i = 0; i < numCourses; ++i) ret[i] = ans.get(i);
    return ret;
}

private boolean dfs(List<Integer>[] adj, List<Integer> ans, boolean[] checked, boolean[] visited, int u) {
    if (checked[u]) return false;
    else if (visited[u]) return true;
    else visited[u] = true;
    for (int v : adj[u]) {
        if (dfs(adj, ans, checked, visited, v)) return true;
    }
    checked[u] = true;
    ans.add(0, u);
    return false;
}
    
    



