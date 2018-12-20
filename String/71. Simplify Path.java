
/*

Given an absolute path for a file (Unix-style), simplify it. 

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
path = "/a/../../b/../c//.//", => "/c"
path = "/a//b////c/d//././/..", => "/a/b/c"
In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. 
Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. 

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

*/

/*

O(n),O(n)

*/

public String simplifyPath(String path) {
    Deque<String> deque = new ArrayDeque<>();
    StringBuilder ans = new StringBuilder();
    String[] dirs = path.split("\\/");
    for (int i = 0; i < dirs.length; ++i) {
        if (dirs[i].equals("/") || dirs[i].equals(".") || dirs[i].length() == 0) continue;
        if (dirs[i].equals("..")) deque.pollLast();
        else deque.offerLast(dirs[i]);
    }
    while (!deque.isEmpty()) {
        ans.append("/");
        ans.append(deque.pollFirst());
    }
    return ans.length() == 0 ? "/" : ans.toString();
}





