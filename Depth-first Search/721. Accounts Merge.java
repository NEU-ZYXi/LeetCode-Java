
/*

Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, 
and the rest of the elements are emails representing emails of the account.
Now, we would like to merge these accounts. 
Two accounts definitely belong to the same person if there is some email that is common to both accounts. 
Note that even if two accounts have the same name, they may belong to different people as people could have the same name.
A person can have any number of accounts initially, but all of their accounts definitely have the same name.
After merging the accounts, return the accounts in the following format: the first element of each account is the name, 
and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], 
            ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'], 
         ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.

*/

/*

O(n),O(n)

*/

public List<List<String>> accountsMerge(List<List<String>> accounts) {
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> adj = new HashMap<>();
    Map<String, String> map = new HashMap<>();
    for (List<String> account : accounts) {
        String name = account.get(0);
        for (int i = 1; i < account.size(); ++i) {
            String cur = account.get(i);
            map.put(cur, name);
            adj.putIfAbsent(cur, new ArrayList<>());
            if (i == 1) {
                continue;
            }
            String prev = account.get(i - 1);
            adj.get(prev).add(cur);
            adj.get(cur).add(prev);
        }
    }
    Set<String> vis = new HashSet<>();
    for (String cur : map.keySet()) {
        if (vis.add(cur)) {
            List<String> tmp = new LinkedList<>();
            dfs(adj, tmp, vis, cur);
            Collections.sort(tmp);
            tmp.add(0, map.get(cur));
            ans.add(tmp);
        }
    }
    return ans;
}

private void dfs(Map<String, List<String>> adj, List<String> tmp, Set<String> vis, String cur) {
    tmp.add(cur);
    for (String next : adj.get(cur)) {
        if (vis.add(next)) {
            dfs(adj, tmp, vis, next);
        }
    }
}





