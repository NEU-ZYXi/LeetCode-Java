
/*

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/

/*

O(n),O(1)

*/

public void nextPermutation(int[] nums) {
    int i = nums.length - 1, j = nums.length - 1;
    while (i > 0) {
        if (nums[i] > nums[i - 1]) break;
        i--;
    }
    if (i != 0) {
        while (j > 0) {
            if (nums[j] > nums[i - 1]) break;
            j--;
        }
        swap(nums, i - 1, j);
    }
    reverse(nums, i, nums.length - 1);
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}

private void reverse(int[] nums, int i, int j) {
    while (i < j) {
        swap(nums, i, j);
        i++;
        j--;
    }
}




