
/*

Given a char array representing tasks CPU need to do. 
It contains capital letters A to Z where different letters represent different tasks. 
Tasks could be done without original order. 
Each task could be done in one interval. 
For each interval, CPU could finish one task or just be idle.
However, there is a non-negative cooling interval n that means between two same tasks, 
there must be at least n intervals that CPU are doing different tasks or just be idle.
You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

*/

/*

Solution: sort buckets to find max frequency and calculate minimum idles we need
          greedily subtract other buckets to fill idle, if buckets[i]=max which means idle will be filled with max-1
O(n),O(1)          

*/

public int leastInterval(char[] tasks, int n) {
    int[] buckets = new int[26];
    for (char c : tasks) {
        buckets[c - 'A']++;
    }
    Arrays.sort(buckets);
    int max = buckets[25], idle = (max - 1) * n;
    for (int i = 0; i < 25; ++i) {
        if (buckets[i] != 0) {
            idle -= Math.min(buckets[i], max - 1);
        }
    }
    return idle > 0 ? idle + tasks.length : tasks.length;
}




