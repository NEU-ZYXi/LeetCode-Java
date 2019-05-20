
/*

Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Follow up:
What if the input numbers come in one by one as an infinite stream? 
In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. 
Could you solve it efficiently?

Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
             After flipping, the maximum number of consecutive 1s is 4.             

*/

/*

Solution 1: O(n),O(1)

*/

public int findMaxConsecutiveOnes(int[] nums) {
    int ans = 0, prev = -1;
    for (int i = 0, j = 0; j < nums.length; ++j) {
        if (nums[j] == 0) {
            i = prev + 1;
            prev = j;
        }
        ans = Math.max(ans, j - i + 1);
    }
    return ans;
}


/*

Solution 2: for follow up, use a queue to simulate the stream
O(n),O(n)

*/

public int findMaxConsecutiveOnes(int[] nums) {
    int ans = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0, j = 0; j < nums.length; ++j) {
        if (nums[j] == 0) {
            queue.offer(j);
        }
        if (queue.size() > 1) {
            i = queue.poll() + 1;
        }
        ans = Math.max(ans, j - i + 1);
    }
    return ans;
}


/*

Solution 3: for k valid flips, maintain the sliding window with k '0' inside
O(n),O(1)

*/

public int findMaxConsecutiveOnes(int[] nums) {
    int ans = 0, zero = 0;
    for (int i = 0, j = 0; j < nums.length; ++j) {
        if (nums[j] == 0) {
            zero++;
        }
        while (zero > 1) {
            if (nums[i] == 0) {
                zero--;
            }
            i++;
        }
        ans = Math.max(ans, j - i + 1);
    }
    return ans;
}




