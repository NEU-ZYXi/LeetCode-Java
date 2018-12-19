
/*

Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters 
and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line do not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

Note:
A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

Example 1:
Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:
Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
             
Example 3:
Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

*/

/*

O(n*maxWidth),O(maxWidth)

*/

public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ans = new ArrayList<>();
    int i = 0;
    while (i < words.length) {
        StringBuilder sb = new StringBuilder();
        int j = i + 1, curWidth = words[i].length();
        sb.append(words[i]);
        while (j < words.length) {
            if (curWidth + words[j].length() + 1 > maxWidth) break;
            curWidth += words[j].length() + 1;
            j++;
        }
        int gap = j - i - 1;
        if (gap == 0 || j == words.length) {
            for (int k = i + 1; k < j; ++k) sb.append(" ").append(words[k]);
            while (sb.length() < maxWidth) sb.append(" ");
        } else {
            int space = (maxWidth - curWidth) / gap;
            int remain = (maxWidth - curWidth) % gap;
            for (int k = i + 1; k < j; ++k) {
                for (int s = 0; s < space; ++s) sb.append(" ");
                if (remain > 0) {
                    sb.append(" ");
                    remain--;
                }
                sb.append(" ").append(words[k]);
            }
        }
        i = j;
        ans.add(sb.toString());
    }
    return ans;
}




