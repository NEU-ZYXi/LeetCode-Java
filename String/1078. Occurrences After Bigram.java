
/*

Given words first and second, consider occurrences in some text of the form "first second third", 
where second comes immediately after first, and third comes immediately after second.
For each such occurrence, add "third" to the answer, and return the answer.

Example 1:
Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]

Example 2:
Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]

*/

/*

O(n),O(n)

*/

public String[] findOcurrences(String text, String first, String second) {
    String[] words = text.split("\\s+");
    List<String> ans = new ArrayList<>();
    for (int i = 2; i < words.length; ++i) {
        if (first.equals(words[i - 2]) && second.equals(words[i - 1])) {
            ans.add(words[i]);
        }
    }
    return ans.toArray(new String[0]);
}



