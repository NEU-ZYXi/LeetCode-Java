
/*

Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
For numbers which are multiples of both three and five output “FizzBuzz”.

Example:
n = 15,
Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

*/

/*

O(n),O(1)

*/

public List<String> fizzBuzz(int n) {
    List<String> ans = new ArrayList<>();
    for (int i = 1, fizz = 0, buzz = 0; i <= n; ++i) {
        fizz++;
        buzz++;
        if (fizz == 3 && buzz == 5) {
            ans.add("FizzBuzz");
            fizz = 0;
            buzz = 0;
        } else if (fizz == 3) {
            ans.add("Fizz");
            fizz = 0;
        } else if (buzz == 5) {
            ans.add("Buzz");
            buzz = 0;
        } else ans.add(String.valueOf(i));
    }
    return ans;
}




