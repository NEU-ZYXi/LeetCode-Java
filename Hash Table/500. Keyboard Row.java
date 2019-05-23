
/*

Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard.
 
Example:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]

*/

/*

O(nm),O(n) where n is the length of words array and m is average length of words

*/

public String[] findWords(String[] words) {
    String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    List<String> ans = new ArrayList<>();
    int[] buckets = new int[128];
    for (int i = 0; i < 3; ++i) {
        for (char c : rows[i].toCharArray()) {
            buckets[c] = i;
        }
    }
    for (String word : words) {
        int row = buckets[word.toLowerCase().charAt(0)];
        for (char c : word.toLowerCase().toCharArray()) {
            if (buckets[c] != row) {
                row = -1;
                break;
            }
        }
        if (row != -1) {
            ans.add(word);
        }
    }
    return ans.toArray(new String[0]);
}





