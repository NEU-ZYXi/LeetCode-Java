
/*

Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, 
then reverse the order of the first k elements of A.  
We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.
Return the k-values corresponding to a sequence of pancake flips that sort A.  
Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

Example 1:
Input: [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. 

Example 2:
Input: [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.

*/

/*

Solution: keep finding the index of current max number, reverse twice to move it to the end
O(n^2),O(n)

*/

public List<Integer> pancakeSort(int[] A) {
    List<Integer> ans = new ArrayList<>();
    int n = A.length, max = n;
    for (int i = 0; i < n; ++i) {
        int idx = find(A, max);
        reverse(A, idx);
        reverse(A, max - 1);
        ans.add(idx + 1);
        ans.add(max);
        max--;
    }
    return ans;
}

private int find(int[] A, int num) {
    for (int i = 0; i < A.length; ++i) {
        if (A[i] == num) {
            return i;
        } 
    }
    return -1;
}

private void reverse(int[] A, int idx) {
    int i = 0, j = idx;
    while (i < j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
        i++;
        j--;
    }
}




