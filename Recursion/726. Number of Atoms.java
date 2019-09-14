
/*

Given a chemical formula (given as a string), return the count of each atom.
An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
1 or more digits representing the count of that element may follow if the count is greater than 1.
If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.
A formula placed in parentheses, and a count (optionally added) is also a formula. 
For example, (H2O2) and (H2O2)3 are formulas.
Given a formula, output the count of all elements as a string in the following form: 
the first name (in sorted order), followed by its count (if that count is more than 1), 
followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

Example 1:
Input: 
formula = "H2O"
Output: "H2O"
Explanation: 
The count of elements are {'H': 2, 'O': 1}.

Example 2:
Input: 
formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: 
The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.

Example 3:
Input: 
formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation: 
The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.

*/

/*

O(n),O(n)

*/

public String countOfAtoms(String formula) {
    Map<String, Integer> map = count(formula);
    List<String> atoms = new ArrayList<>(map.keySet());
    Collections.sort(atoms);
    StringBuilder ans = new StringBuilder();
    for (String atom : atoms) {
        ans.append(atom).append(map.get(atom) > 1 ? map.get(atom) : "");
    }
    return ans.toString();
}

private Map<String, Integer> count(String s) {
    Map<String, Integer> map = new HashMap<>();
    int i = 0, n = s.length();
    while (i < n) {
        if (s.charAt(i) == '(') {
            int cnt = 1, j = i + 1;
            while (j < n) {
                if (s.charAt(j) == '(') {
                    cnt++;
                } else if (s.charAt(j) == ')') {
                    cnt--;
                }
                if (cnt == 0) {
                    break;
                }
                j++;
            }
            Map<String, Integer> inParentheses = count(s.substring(i + 1, j));
            int digits = 1, k = j + 1;
            while (k < n && Character.isDigit(s.charAt(k))) {
                k++;
            }
            if (k > j + 1) {
                digits = Integer.valueOf(s.substring(j + 1, k));
            }
            for (String atom : inParentheses.keySet()) {
                map.put(atom, inParentheses.get(atom) * digits + map.getOrDefault(atom, 0));
            }
            i = k;
        } else {
            int j = i + 1;
            while (j < n && 'a' <= s.charAt(j) && s.charAt(j) <= 'z') {
                j++;
            }
            int digits = 1, k = j;
            while (k < n && Character.isDigit(s.charAt(k))) {
                k++;
            }
            if (k > j) {
                digits = Integer.valueOf(s.substring(j, k));
            }
            String atom = s.substring(i, j);
            map.put(atom, map.getOrDefault(atom, 0) + digits);
            i = k;
        }
    }
    return map;
}





