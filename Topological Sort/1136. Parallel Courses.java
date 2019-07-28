
/*

There are N courses, labelled from 1 to N.
We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: 
course X has to be studied before course Y.
In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.
Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses, return -1.

Example 1:
Input: N = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: 
In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.

Example 2:
Input: N = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: 
No course can be studied because they depend on each other.

*/

/*

O(V+E),O(V+E)

*/

public int minimumSemesters(int N, int[][] relations) {
    List<Integer>[] adj = new ArrayList[N + 1];
    int[] indegree = new int[N + 1];
    int ans = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; ++i) {
        adj[i] = new ArrayList<>();
        indegree[i] = 0;
    }
    for (int[] edge : relations) {
        int u = edge[0], v = edge[1];
        adj[u].add(v);
        indegree[v]++;
    }
    for (int i = 1; i <= N; ++i) {
        if (indegree[i] == 0) {
            queue.offer(i);
        }
    }
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            int cur = queue.poll();
            N--;
            for (int next : adj[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        ans++;
    }
    return N == 0 ? ans : -1; 
}




