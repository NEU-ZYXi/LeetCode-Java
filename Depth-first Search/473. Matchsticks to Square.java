
/*

Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, 
please find out a way you can make one square by using up all those matchsticks. 
You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
Your input will be several matchsticks the girl has, represented with their stick length. 
Your output will represent whether you could make one square using all the matchsticks the little match girl has.

Example 1:
Input: [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.

Example 2:
Input: [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.

*/

/*
 
O(4^n),O(n)

*/

public boolean makesquare(int[] nums) {
    int n = nums.length, sum = 0;
    if (n < 4) {
        return false;
    }
    for (int num : nums) {
        sum += num;
    }
    if (sum % 4 != 0) {
        return false;
    }
    sum /= 4;
    Arrays.sort(nums);
    int[] sides = new int[] {sum, sum, sum, sum};
    return dfs(nums, sides, n - 1);
}

private boolean dfs(int[] nums, int[] sides, int idx) {
    if (idx < 0) {
        return sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0;
    }
    for (int i = 0; i < 4; ++i) {
        if (nums[idx] <= sides[i]) {
            sides[i] -= nums[idx];
            if (dfs(nums, sides, idx - 1)) {
                return true;
            }
            sides[i] += nums[idx];
        }
    }
    return false;
}




