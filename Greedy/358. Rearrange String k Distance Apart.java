
/*

Given a string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:
Input: s = "aabbcc", k = 3
Output: "abcabc" 
Explanation: The same letters are at least distance 3 from each other.

Example 2:
Input: s = "aaabc", k = 3
Output: "" 
Explanation: It is not possible to rearrange the string.

Example 3:
Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least distance 2 from each other.

*/

/*

Solution 1: use buckets to count each character, 
            use priority queue to arrange characters based on greedy that we should arrange the most character first, 
            use queue for k distance apart, when the size is k, we can reuse the first character in the queue
O(nlog26),O(k+26)          

*/

public String rearrangeString(String s, int k) {
    int[] buckets = new int[128];
    for (char c : s.toCharArray()) buckets[c]++;
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return b[1] - a[1];
        }
    });
    for (char c = 'a'; c <= 'z'; ++c) {
        if (buckets[c] > 0) pq.offer(new int[] {c, buckets[c]});
    }
    StringBuilder ans = new StringBuilder();
    Queue<int[]> queue = new LinkedList<>();
    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        ans.append((char)cur[0]);
        cur[1]--;
        queue.offer(cur);
        if (queue.size() >= k) {
            if (queue.peek()[1] > 0) pq.offer(queue.poll());
            else queue.poll();
        }
    }
    return ans.length() == s.length() ? ans.toString() : "";
}


/*

Solution 2: same intuition, use an array to indicate next valid position
O(26n),O(26)

*/

public String rearrangeString(String s, int k) {
    int n = s.length();
    int[] buckets = new int[128];
    int[] valid = new int[128];
    StringBuilder ans = new StringBuilder();
    for (char c : s.toCharArray()) buckets[c]++;
    for (int i = 0; i < n; ++i) {
        int cur = find(buckets, valid, i);
        if (cur == -1) return "";
        ans.append((char)cur);
        buckets[cur]--;
        valid[cur] = i + k;
    }
    return ans.toString();
}

private int find(int[] buckets, int[] valid, int i) {
    int max = Integer.MIN_VALUE, ans = -1;
    for (int j = 0; j < buckets.length; ++j) {
        if (buckets[j] > 0 && buckets[j] > max && valid[j] <= i) {
            max = buckets[j];
            ans = j;
        }
    }
    return ans;
}




