
/*

Given a positive integer, output its complement number. 
The complement strategy is to flip the bits of its binary representation.
Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.

Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

*/

/*

Solution 1: O(1),O(1)

*/

public int findComplement(int num) {
    int i = 0, j = 0;
    while (i < num) {
        i += (1 << j);
        j++;
    }
    return i - num;
}


/*

Solution 2: find the highest one bit as the bit mask
            mark half of num as '1' each time until all 32 bits are '1', then num-(num>>>1) to get the highest one bit
O(1),O(1)            

*/

public int findComplement(int num) {
    int mask = highestOneBit(num) - 1;
    return mask & (~num);
}

private int highestOneBit(int num) {
    num |= (num >> 1);
    num |= (num >> 2);
    num |= (num >> 4);
    num |= (num >> 8);
    num |= (num >> 16);
    return num - (num >>> 1);
}




