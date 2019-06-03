
/*

Design an in-memory file system to simulate the following functions:
ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. 
If it is a directory path, return the list of file and directory names in this directory. 
Your output (file and directory names together) should in lexicographic order.
mkdir: Given a directory path that does not exist, you should make a new directory according to the path. 
If the middle directories in the path don't exist either, you should create them as well. This function has void return type.
addContentToFile: Given a file path and file content in string format. 
If the file doesn't exist, you need to create that file containing given content. 
If the file already exists, you need to append given content to original content. This function has void return type.
readContentFromFile: Given a file path, return its content in string format.

Example:
Input: 
["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
Output:
[null,[],null,null,["a"],"hello"]

*/

/*

Solution: use trie to represent the path, go through the path and then mkdir, addContentToFile or readContentFromFile
O(n),O(n) where n is number of dirs in the path

*/

class FileSystem {
    class TrieNode {
        private Map<String, TrieNode> children;
        private String file;
        
        public TrieNode() {
            this.children = new HashMap<>();
            this.file = "";
        }
    }
    
    private TrieNode root;

    public FileSystem() {
        this.root = new TrieNode();
    }
    
    public List<String> ls(String path) {
        String[] dirs = path.split("/");
        List<String> ans = new ArrayList<>();
        TrieNode cur = root;
        String tmp = "";
        for (String dir : dirs) {
            if (dir.length() != 0) {
                if (!cur.children.containsKey(dir)) {
                    return ans;
                }
                cur = cur.children.get(dir);
                tmp = dir;
            }
        }
        if (cur.file.length() > 0) {
            ans.add(tmp);
        } else {
            for (String dir : cur.children.keySet()) {
                ans.add(dir);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    
    public void mkdir(String path) {
        String[] dirs = path.split("/");
        TrieNode cur = root;
        for (String dir : dirs) {
            if (dir.length() != 0) {
                if (!cur.children.containsKey(dir)) {
                    cur.children.put(dir, new TrieNode());
                }
                cur = cur.children.get(dir);
            }
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] dirs = filePath.split("/");
        TrieNode cur = root;
        for (String dir : dirs) {
            if (dir.length() != 0) {
                if (!cur.children.containsKey(dir)) {
                    cur.children.put(dir, new TrieNode());
                }
                cur = cur.children.get(dir);
            }
        }
        cur.file += content;
    }
    
    public String readContentFromFile(String filePath) {
        String[] dirs = filePath.split("/");
        TrieNode cur = root;
        for (String dir : dirs) {
            if (dir.length() != 0) {
                cur = cur.children.get(dir);
            }
        }
        return cur.file;
    }
}






