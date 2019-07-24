
/*

In a project, you have a list of required skills req_skills, and a list of people. 
The i-th person people[i] contains a list of skills that person has.
Consider a sufficient team: a set of people such that for every required skill in req_skills,
there is at least one person in the team who has that skill. 
We can represent these teams by the index of each person: 
for example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
Return any sufficient team of the smallest possible size, represented by the index of each person.
You may return the answer in any order.  It is guaranteed an answer exists.

Example 1:
Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
Output: [0,2]

Example 2:
Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"], 
people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],
          ["reactjs","csharp"],["csharp","math"],["aws","java"]]
Output: [1,2]

*/

/*

Solution 1: backtrack to try each person for each skill
O(n^m),O(m) where n is number of skills and m is number of people

*/

public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
    int n = people.size();
    Map<String, List<Integer>> map = new HashMap<>();
    Set<Integer> team = new HashSet<>();
    for (int i = 0; i < n; ++i) {
        for (String skill : people.get(i)) {
            map.putIfAbsent(skill, new ArrayList<>());
            map.get(skill).add(i);
        }
        team.add(i);
    }
    dfs(map, req_skills, team, new HashSet<>(), 0);
    return new ArrayList<>(team).stream().mapToInt(Integer::valueOf).toArray();
}

private void dfs(Map<String, List<Integer>> map, String[] skills, Set<Integer> team, Set<Integer> tmp, int idx) {
    if (tmp.size() > team.size()) {
        return;
    }
    if (idx == skills.length) {
        team.clear();
        team.addAll(tmp);
        return;
    }
    for (int person : map.get(skills[idx])) {
        boolean isRemove = !tmp.contains(person);
        tmp.add(person);
        dfs(map, skills, team, tmp, idx + 1);
        if (isRemove) {
            tmp.remove(person);
        }
    }
}


/*

Solution 2: 

*/





