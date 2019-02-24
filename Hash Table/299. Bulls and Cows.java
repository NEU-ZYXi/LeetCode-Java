
/*

You are playing the following Bulls and Cows game with your friend: 
You write down a number and ask your friend to guess what the number is. 
Each time your friend makes a guess, you provide a hint that indicates 
how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and 
how many digits match the secret number but locate in the wrong position (called "cows"). 
Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, 
use A to indicate the bulls and B to indicate the cows. 
Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

Example 2:
Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.

*/

/*

O(n),O(10)

*/

public String getHint(String secret, String guess) {
    int[] nums1 = new int[10], nums2 = new int[10];
    int bull = 0, cow = 0;
    for (int i = 0; i < secret.length(); ++i) {
        if (secret.charAt(i) == guess.charAt(i)) bull++;
        else {
            nums1[secret.charAt(i) - '0']++;
            nums2[guess.charAt(i) - '0']++;
        }
    }
    for (int i = 0; i < 10; ++i) cow += Math.min(nums1[i], nums2[i]);
    return bull + "A" + cow + "B";
}


/*

Solution: one pass, positive count secret and negative count guess
O(n),O(10)

*/

public String getHint(String secret, String guess) {
    int[] nums = new int[10];
    int bull = 0, cow = 0;
    for (int i = 0; i < secret.length(); ++i) {
        char s = secret.charAt(i), g = guess.charAt(i);
        if (s == g) bull++;
        else {
            if (nums[s - '0'] < 0) cow++;
            if (nums[g - '0'] > 0) cow++;
            nums[s - '0']++;
            nums[g - '0']--;
        }
    }
    return bull + "A" + cow + "B";
}



