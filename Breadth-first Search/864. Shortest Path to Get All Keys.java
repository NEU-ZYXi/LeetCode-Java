
/*

We are given a 2-dimensional grid.
"." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks.
We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions. 
We cannot walk outside the grid, or walk into a wall. 
If we walk over a key, we pick it up. 
We can't walk over a lock unless we have the corresponding key.
For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the English alphabet in the grid.
This means that there is exactly one key for each lock, and one lock for each key; 
and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
Return the lowest number of moves to acquire all keys. 
If it's impossible, return -1.

Example 1:
Input: ["@.a.#","###.#","b.A.B"]
Output: 8

Example 2:
Input: ["@..aA","..B#.","....b"]
Output: 6

*/

/*

Solution 1: create a node with position and keys, BFS to find the shortest path
O(nm),O(nm)

*/

class Tuple {
    private int x, y;
    private Set<Character> keys;

    public Tuple(int x, int y, Set<Character> keys) {
        this.x = x;
        this.y = y;
        this.keys = keys;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Tuple)) {
            return false;
        }
        Tuple t = (Tuple)o;
        return this.x == t.x && this.y == t.y && this.keys.equals(t.keys);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.x;
        result = 31 * result + this.y;
        result = 31 * result + this.keys.hashCode();
        return result;
    }
}

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

public int shortestPathAllKeys(String[] grid) {
    int n = grid.length, m = grid[0].length(), x = -1, y = -1, ans = 0, cnt = 0;
    Queue<Tuple> queue = new LinkedList<>();
    Set<Tuple> vis = new HashSet<>();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i].charAt(j) == '@') {
                x = i;
                y = j;
            }
            if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                cnt++;
            }
        }
    }
    Tuple start = new Tuple(x, y, new HashSet<>());
    queue.offer(start);
    vis.add(start);
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            Tuple cur = queue.poll();
            if (cur.keys.size() == cnt) {
                return ans;
            }
            for (int[] dir : dirs) {
                int nx = cur.x + dir[0], ny = cur.y + dir[1];
                Set<Character> keys = new HashSet<>(cur.keys);
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    char c = grid[nx].charAt(ny);
                    if (c == '#') {
                        continue;
                    } else if (c >= 'a' && c <= 'f') {
                        keys.add(c);
                    } else if (c >= 'A' && c <= 'F' && !keys.contains(Character.toLowerCase(c))) {
                        continue;
                    }
                    Tuple next = new Tuple(nx, ny, keys);
                    if (vis.add(next)) {
                        queue.offer(next);
                    }
                }
            }
        }
        ans++;
    }
    return -1;
}


/*

Solution 2: use bit mask to represent keys state
O(nm),O(nm)

*/

class Tuple {
    private int x, y, keys;

    public Tuple(int x, int y, int keys) {
        this.x = x;
        this.y = y;
        this.keys = keys;
    }
}

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

public int shortestPathAllKeys(String[] grid) {
    int n = grid.length, m = grid[0].length(), x = -1, y = -1, ans = 0, max = 0;
    Queue<Tuple> queue = new LinkedList<>();
    Set<String> vis = new HashSet<>();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            char c = grid[i].charAt(j);
            if (c == '@') {
                x = i;
                y = j;
            }
            if (c >= 'a' && c <= 'f') {
                max = Math.max(c - 'a' + 1, max);
            }
        }
    }
    Tuple start = new Tuple(x, y, 0);
    queue.offer(start);
    vis.add(x + "," + y + "," + 0);
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            Tuple cur = queue.poll();
            if (cur.keys == (1 << max) - 1) {
                return ans;
            }
            for (int[] dir : dirs) {
                int nx = cur.x + dir[0], ny = cur.y + dir[1], keys = cur.keys;
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    char c = grid[nx].charAt(ny);
                    if (c == '#') {
                        continue;
                    } else if (c >= 'a' && c <= 'f') {
                        keys |= 1 << (c - 'a');
                    } else if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) {
                        continue;
                    }
                    Tuple next = new Tuple(nx, ny, keys);
                    if (vis.add(nx + "," + ny + "," + keys)) {
                        queue.offer(next);
                    }
                }
            }
        }
        ans++;
    }
    return -1;
}




