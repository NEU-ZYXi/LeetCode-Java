
/*

Given a rows x cols screen and a sentence represented by a list of non-empty words, 
find how many times the given sentence can be fitted on the screen.

Example 1:
Input:
rows = 2, cols = 8, sentence = ["hello", "world"]
Output: 
1
Explanation:
hello---
world---
The character '-' signifies an empty space on the screen.

Example 2:
Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
Output: 
2
Explanation:
a-bcd- 
e-a---
bcd-e-
The character '-' signifies an empty space on the screen.

Example 3:
Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
Output: 
1
Explanation:
I-had
apple
pie-I
had--
The character '-' signifies an empty space on the screen.

*/

/*

O(n),O(1)

*/

public int wordsTyping(String[] sentence, int rows, int cols) {
    String s = String.join(" ", sentence) + " ";
    int cur = 0, n = s.length();
    for (int i = 0; i < rows; ++i) {
        cur += cols;
        if (s.charAt(cur % n) == ' ') cur++;
        else {
            while (cur > 0 && s.charAt((cur - 1) % n) != ' ') cur--;
        }
    }
    return cur / n;
}




