
/*

You are given three arrays username, timestamp and website of the same length N 
where the ith tuple means that the user with name username[i] visited the website website[i] at time timestamp[i].
A 3-sequence is a list of not necessarily different websites of length 3 sorted in ascending order by the time of their visits.
Find the 3-sequence visited at least once by the largest number of users. 
If there is more than one solution, return the lexicographically minimum solution.
A 3-sequence X is lexicographically smaller than a 3-sequence Y 
if X[0] < Y[0] or X[0] == Y[0] and (X[1] < Y[1] or X[1] == Y[1] and X[2] < Y[2]). 
It is guaranteed that there is at least one user who visited at least 3 websites.
No user visits two websites at the same time.

Example 1:
Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], 
       timestamp = [1,2,3,4,5,6,7,8,9,10], 
       website = ["home","about","career","home","cart","maps","home","home","about","career"]
Output: ["home","about","career"]
Explanation: 
The tuples in this example are:
["joe", 1, "home"]
["joe", 2, "about"]
["joe", 3, "career"]
["james", 4, "home"]
["james", 5, "cart"]
["james", 6, "maps"]
["james", 7, "home"]
["mary", 8, "home"]
["mary", 9, "about"]
["mary", 10, "career"]
The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.

*/

/*

O(n^3),O(n)

*/

public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    int n = username.length;
    TreeMap<Integer, String[]> timeMap = new TreeMap<>();
    for (int i = 0; i < n; ++i) {
        timeMap.put(timestamp[i], new String[] {username[i], website[i]});
    }
    Map<String, List<String>> map = new HashMap<>();
    Map<String, Integer> cnt = new HashMap<>();
    for (int time : timeMap.keySet()) {
        String user = timeMap.get(time)[0], site = timeMap.get(time)[1];
        map.putIfAbsent(user, new ArrayList<>());
        map.get(user).add(site);
    }
    int max = 0;
    String ans = "";
    for (String user : map.keySet()) {
        Set<String> set = new HashSet<>();
        List<String> websites = map.get(user);
        int size = websites.size();
        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size; ++j) {
                for (int k = j + 1; k < size; ++k) {
                    set.add(websites.get(i) + "," + websites.get(j) + "," + websites.get(k));
                }
            }
        }
        for (String s : set) {
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            if (max < cnt.get(s) || (max == cnt.get(s) && s.compareTo(ans) < 0)) {
                max = cnt.get(s);
                ans = s;
            }
        }
    }
    return Arrays.asList(ans.split(","));
}




