
/*

Design a search autocomplete system for a search engine.
Users may input a sentence (at least one word and end with a special character '#'). 
For each character they type except '#', you need to return the top 3 historical hot sentences
that have prefix the same as the part of sentence already typed. 
Here are the specific rules:
The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). 
If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, then just return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Your job is to implement the following functions:
The constructor function:
AutocompleteSystem(String[] sentences, int[] times): This is the constructor.
The input is historical data. 
Sentences is a string array consists of previously typed sentences. 
Times is the corresponding times a sentence has been typed. 
Your system should record these historical data.
Now, the user wants to input a new sentence. 
The following function will provide the next character the user types:
List<String> input(char c): The input c is the next character typed by the user. 
The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#').
Also, the previously typed sentence should be recorded in your system. 
The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.

Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
The system have already tracked down the following sentences and their corresponding times:
"i love you" : 5 times
"island" : 3 times
"ironman" : 2 times
"i love leetcode" : 2 times

Now, the user begins another search:
Operation: input('i')
Output: ["i love you", "island","i love leetcode"]
Explanation:
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. 
Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". 
Also we only need to output top 3 hot sentences, so "ironman" will be ignored.

Operation: input(' ')
Output: ["i love you","i love leetcode"]
Explanation:
There are only two sentences that have prefix "i ".

Operation: input('a')
Output: []
Explanation:
There are no sentences that have prefix "i a".

Operation: input('#')
Output: []
Explanation:
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. 
And the following input will be counted as a new search.

*/

/*

O(nm+nlogn),O(nm) where n is length of sentences array and m is average length of words

*/

class AutocompleteSystem {
    class TrieNode {
        private Map<Character, TrieNode> children;
        private Map<String, Integer> cnt;
        
        public TrieNode() {
            this.children = new HashMap<>();
            this.cnt = new HashMap<>();
        }
    }
    
    private TrieNode root;
    private String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.root = new TrieNode();
        this.prefix = "";
        for (int i = 0; i < sentences.length; ++i) {
            build(sentences[i], times[i]);
        }
    }
    
    private void build(String s, int time) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            TrieNode child = cur.children.get(c);
            if (child == null) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
            cur.cnt.put(s, cur.cnt.getOrDefault(s, 0) + time);
        }
    }
    
    public List<String> input(char c) {
        List<String> ans = new ArrayList<>();
        if (c == '#') {
            build(prefix, 1);
            prefix = "";
            return ans;
        }
        prefix += c;
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode child = cur.children.get(ch);
            if (child == null) {
                return ans;
            }
            cur = child;
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue();
            } 
        });
        for (Map.Entry<String, Integer> entry : cur.cnt.entrySet()) {
            pq.offer(entry);
        }
        while (!pq.isEmpty() && ans.size() < 3) {
            ans.add(pq.poll().getKey());
        }
        return ans;
    }
}





