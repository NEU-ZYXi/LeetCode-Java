
/*

Given two strings representing two complex numbers.
You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.

Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.

*/

/*

O(1),O(1)

*/

public String complexNumberMultiply(String a, String b) {
    String[] A = a.split("\\+|i");
    String[] B = b.split("\\+|i");
    int realA = Integer.valueOf(A[0]);
    int imgA = Integer.valueOf(A[1]);
    int realB = Integer.valueOf(B[0]);
    int imgB = Integer.valueOf(B[1]);
    return (realA * realB - imgA * imgB) + "+" + (realA * imgB + realB * imgA) + "i";
}




