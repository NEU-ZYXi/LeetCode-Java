
/*

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,3,2]
Output: 3

Example 2:
Input: [0,1,0,1,0,1,99]
Output: 99

*/

/*

Solution: first to track the number appeared once, second to track the number appeared twice
          first^num means first is the number at its once, &(~second) means the number only equal to first when second is 0
O(n),O(1)

*/

public int singleNumber(int[] nums) {
    int first = 0, second = 0;
    for (int num : nums) {
        first = (first ^ num) & (~second);
        second = (second ^ num) & (~first);
    }
    return first;
}



