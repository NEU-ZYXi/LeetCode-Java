
/*

Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.
However, you can add any number of parenthesis at any position to change the priority of operations. 
You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. 
Your expression should NOT contain redundant parenthesis.

Example:
Input: [1000,100,10,2]
Output: "1000/(100/10/2)"
Explanation:
1000/(100/10/2) = 1000/((100/10)/2) = 200
However, the bold parenthesis in "1000/((100/10)/2)" are redundant, 
since they don't influence the operation priority. So you should return "1000/(100/10/2)". 
Other cases:
1000/(100/10)/2 = 50
1000/(100/(10/2)) = 50
1000/100/10/2 = 0.5
1000/100/(10/2) = 2

*/

/*

Solution: for a/b/c/d/...=a/b*X, to maximize, make X largest which means X=c*d*...
O(n),O(1)

*/

public String optimalDivision(int[] nums) {
    int n = nums.length;
    if (n == 1) {
        return String.valueOf(nums[0]);
    }
    if (n == 2) {
        return nums[0] + "/" + nums[1];
    }
    StringBuilder ans = new StringBuilder(nums[0] + "/(" + nums[1]);
    for (int i = 2; i < n; ++i) {
        ans.append("/").append(nums[i]);
    }
    ans.append(")");
    return ans.toString();
}




