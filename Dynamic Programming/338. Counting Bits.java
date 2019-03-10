
/*

Given a non negative integer number num. 
For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and 
return them as an array.

Example 1:
Input: 2
Output: [0,1,1]

Example 2:
Input: 5
Output: [0,1,1,2,1,2]

*/

/*

Solution 1: naiive solution, count each number's bits
O(nm),O(1), where m is the average of number of bits for numbers

*/

public int[] countBits(int num) {
    int[] ans = new int[num + 1];
    for (int i = 1; i <= num; ++i) {
        int cnt = 0, cur = i;
        while (cur != 0) {
            cnt++;
            cur &= (cur - 1);
        }
        ans[i] = cnt;
    }
    return ans;
}


/*

Solution 2: i&(i-1) to drop the last set bit
O(n),O(1)

*/

public int[] countBits(int num) {
    int[] ans = new int[num + 1];
    for (int i = 1; i <= num; ++i) ans[i] = ans[i & (i - 1)] + 1;
    return ans;
}




