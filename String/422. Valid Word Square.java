
/*

Given a sequence of words, check whether it forms a valid word square.
A sequence of words forms a valid word square if the kth row and column read the exact same string, 
where 0 ≤ k < max(numRows, numColumns).

Example 1:
Input:
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]
Output:
true
Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crmy".
The fourth row and fourth column both read "dtye".
Therefore, it is a valid word square.

*/

/*

O(nm),O(1)

*/

public boolean validWordSquare(List<String> words) {
    int n = words.size();
    for (int i = 0; i < n; ++i) {
        String word = words.get(i);
        for (int j = 0; j < word.length(); ++j) {
            if (j >= words.size() || i >= words.get(j).length()) return false;
            if (word.charAt(j) != words.get(j).charAt(i)) return false;
        }
    }
    return true;
}





