
/*

Under a grammar given below, strings can represent a set of lowercase words.  
Let's use R(expr) to denote the set of words the expression represents.
Grammar can best be understood through simple examples:
Single letters represent a singleton set containing that word.
R("a") = {"a"}
R("w") = {"w"}
When we take a comma delimited list of 2 or more expressions, we take the union of possibilities.
R("{a,b,c}") = {"a","b","c"}
R("{{a,b},{b,c}}") = {"a","b","c"} (notice the final set only contains each word at most once)
When we concatenate two expressions, we take the set of possible concatenations between two words 
where the first word comes from the first expression and the second word comes from the second expression.
R("{a,b}{c,d}") = {"ac","ad","bc","bd"}
R("a{b,c}{d,e}f{g,h}") = {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"}

Formally, the 3 rules for our grammar:
For every lowercase letter x, we have R(x) = {x}
For expressions e_1, e_2, ... , e_k with k >= 2, we have R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
For expressions e_1 and e_2, we have R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}, where + denotes concatenation, 
and × denotes the cartesian product.
Given an expression representing a set of words under the given grammar, 
return the sorted list of words that the expression represents.

Example 1:
Input: "{a,b}{c,{d,e}}"
Output: ["ac","ad","ae","bc","bd","be"]

Example 2:
Input: "{{a,z},a{b,c},{ab,z}}"
Output: ["a","ab","ac","z"]
Explanation: Each distinct word is written only once in the final answer.

*/

/*

Solution: recursively solve the substring in each {} pair, and make each single character as a single element list
          for ...,{{...},...},..., we need 3 nested lists
          then merge the lists inside to get distinct words
O(n^2),O(n)          

*/

public List<String> braceExpansionII(String expression) {
    List<List<List<String>>> groups = new ArrayList<>();
    groups.add(new ArrayList<>());
    int depth = 0, start = 0;
    for (int i = 0; i < expression.length(); ++i) {
        char c = expression.charAt(i);
        if (c == '{') {
            if (depth == 0) {
                start = i + 1;
            }
            depth++;
        } else if (c == '}') {
            depth--;
            if (depth == 0) {
                List<String> tmp = braceExpansionII(expression.substring(start, i));
                groups.get(groups.size() - 1).add(tmp);
            }
        } else if (depth == 0 && c == ',') {
            groups.add(new ArrayList<>());
        } else if (depth == 0) {
            groups.get(groups.size() - 1).add(Arrays.asList(String.valueOf(c)));
        }
    }
    Set<String> set = new HashSet<>();
    for (List<List<String>> group : groups) {
        List<String> prev = new ArrayList<>();
        prev.add("");
        for (List<String> words : group) {
            List<String> cur = new ArrayList<>();
            for (String p : prev) {
                for (String s : words) {
                    cur.add(p + s);
                }
            }
            prev = cur;
        }
        set.addAll(prev);
    }
    List<String> ans = new ArrayList<>(set);
    Collections.sort(ans);
    return ans;
}



