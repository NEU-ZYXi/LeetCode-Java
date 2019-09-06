
/*

Given a non-empty list of words, return the k most frequent elements.
Your answer should be sorted by frequency from highest to lowest.
If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words. 
             Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, 
             with the number of occurrence being 4, 3, 2 and 1 respectively.

*/

/*

O(nlogk),O(n)

*/

List<String> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (String s : words) {
        map.put(s, map.getOrDefault(s, 0) + 1);
    }
    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            return a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue();
        }
    });
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        pq.offer(entry);
    }
    for (int i = 0; i < k; ++i) {
        ans.add(pq.poll().getKey());
    }
    return ans;
}




