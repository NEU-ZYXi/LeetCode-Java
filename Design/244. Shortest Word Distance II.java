
/*

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2
and return the shortest distance between these two words in the list. 
Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3

Input: word1 = "makes", word2 = "coding"
Output: 1

*/

/*

O(n),O(n)

*/

class WordDistance {
    
    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        this.map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int ans = Integer.MAX_VALUE, i = 0, j = 0;
        while (i < map.get(word1).size() && j < map.get(word2).size()) {
            int idx1 = map.get(word1).get(i), idx2 = map.get(word2).get(j);
            ans = Math.min(ans, Math.abs(idx1 - idx2));
            if (idx1 < idx2) i++;
            else j++;
        }
        return ans;
    }
}




