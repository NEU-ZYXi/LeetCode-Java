
/*

You are given a series of video clips from a sporting event that lasted T seconds. 
These video clips can be overlapping with each other and have varied lengths.
Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1]. 
We can cut these clips into segments freely: for example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event
([0, T]).  If the task is impossible, return -1.

Example 1:
Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
Output: 3
Explanation: 
We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
Then, we can reconstruct the sporting event as follows:
We cut [1,9] into segments [1,2] + [2,8] + [8,9].
Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].

Example 2:
Input: clips = [[0,1],[1,2]], T = 5
Output: -1
Explanation: 
We can't cover [0,5] with only [0,1] and [0,2].

Example 3:
Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
Output: 3
Explanation: 
We can take clips [0,4], [4,7], and [6,9].

Example 4:
Input: clips = [[0,4],[2,8]], T = 5
Output: 2
Explanation: 
Notice you can have extra video after the event ends.

*/

/*

Solution 1: sort the array by start, greedily choose the one with max end and has overlap with the previous one
O(nlogn),O(1)

*/

public int videoStitching(int[][] clips, int T) {
    Arrays.sort(clips, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    });
    int ans = 0, start = 0, end = 0, i = 0;
    while (start <= end) {
        ans++;
        int newStart = end + 1, newEnd = end;
        while (i < clips.length && clips[i][0] >= start && clips[i][0] <= end) {
            newEnd = Math.max(newEnd, clips[i][1]);
            if (newEnd >= T) {
                return ans;
            }
            i++;
        }
        start = newStart;
        end = newEnd;
    }
    return -1;
}


/*

Solution 2: dp[i] means the min number of clips we need to cover T
            for each T, for each clip, dp[i]=min(dp[clip[0]]+1) which means from the clip[0] to expand
O(nT),O(T)            

*/

public int videoStitching(int[][] clips, int T) {
    int[] dp = new int[T + 1];
    Arrays.fill(dp, T + 1);
    dp[0] = 0;
    for (int i = 1; i <= T; ++i) {
        for (int[] clip : clips) {
            if (i >= clip[0] && i <= clip[1]) {
                dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
            }
        }
        if (dp[i] == T + 1) {
            return -1;
        }
    }
    return dp[T];
}




