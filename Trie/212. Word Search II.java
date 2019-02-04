
/*

Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

Example:
Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Output: ["eat","oath"]

*/

/*

O(kl+nmkl),O(26kl), where k is the length of word list, l is the average length of words

*/

class TrieNode {
    private String word;
    private TrieNode[] children;

    public TrieNode() {
        this.word = null;
        this.children = new TrieNode[26];
    }
}

private int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
private TrieNode root;

public List<String> findWords(char[][] board, String[] words) {
    this.root = new TrieNode();
    List<String> ans = new ArrayList<>();
    for (String word : words) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }
    for (int i = 0; i < board.length; ++i) {
        for (int j = 0; j < board[0].length; ++j) {
            if (root.children[board[i][j] - 'a'] != null) {
                TrieNode cur = root.children[board[i][j] - 'a'];
                dfs(ans, cur, board, i, j);
            }
        }
    }
    return ans;
}

private void dfs(List<String> ans, TrieNode cur, char[][] board, int x, int y) {
    int n = board.length, m = board[0].length;
    if (cur.word != null) {
        ans.add(cur.word);
        cur.word = null;
    }
    char c = board[x][y];
    board[x][y] = '#';
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == '#' || cur.children[board[nx][ny] - 'a'] == null) continue;
        dfs(ans, cur.children[board[nx][ny] - 'a'], board, nx, ny);
    }
    board[x][y] = c;
}



