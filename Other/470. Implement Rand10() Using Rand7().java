
/*

Given a function rand7 which generates a uniform random integer in the range 1 to 7, 
write a function rand10 which generates a uniform random integer in the range 1 to 10.
Do NOT use system's Math.random().

Example 1:
Input: 1
Output: [7]

Example 2:
Input: 2
Output: [8,4]

Example 3:
Input: 3
Output: [8,1,10]

*/

/*

Solution: rand7 => rand49 => rand40 => rand10
          P(rand49()=k,0<=k<40)=1/49+(9/49)*(1/49)+(9/49)^2(1/49)+...
                               =(1/49)*[1+(9/49)+(9/49)^2+...]
                               =(1/49)*[1/(1-9/49)]
                               =1/49*49/40;
                               =1/40
O(1),O(1)

*/

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int ans = 40;
        while (ans >= 40) {
            ans = 7 * (rand7() - 1) + (rand7() - 1);
        }
        return ans % 10 + 1;
    }
}




