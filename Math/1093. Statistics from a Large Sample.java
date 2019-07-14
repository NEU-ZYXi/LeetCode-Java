
/*

We sampled integers between 0 and 255, and stored the results in an array count:  
count[k] is the number of integers we sampled equal to k.
Return the minimum, maximum, mean, median, and mode of the sample respectively, as an array of floating point numbers.  
The mode is guaranteed to be unique.
(Recall that the median of a sample is:
The middle element, if the elements of the sample were sorted and the number of elements is odd;
The average of the middle two elements, if the elements of the sample were sorted and the number of elements is even.)

Example 1:
Input: count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0]
Output: [1.00000,3.00000,2.37500,2.50000,3.00000]

Example 2:
Input: count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0]
Output: [1.00000,4.00000,2.18182,2.00000,1.00000]

*/

/*

O(n),O(1)

*/

public double[] sampleStats(int[] count) {
    int cnt = 0, mode = 0;
    double min = Double.MAX_VALUE, max = Double.MIN_VALUE, median = 0, avg = 0, sum = 0;
    for (int i = 0; i < 256; ++i) {
        if (count[i] != 0) {
            cnt += count[i];
            min = Math.min(min, i);
            max = Math.max(max, i);
            sum += i * count[i];
            if (count[i] > count[mode]) {
                mode = i;
            }
        }
    }
    avg = sum / cnt;
    if (cnt == 1) {
        median = sum;
    }
    int l = (cnt + 1) / 2, r = cnt / 2 + 1, cur = 0;
    for (int i = 0; i < 256; ++i) {
        if (cur < l && cur + count[i] >= l) {
            median += i / 2.0;
        }
        if (cur < r && cur + count[i] >= r) {
            median += i / 2.0;
        }
        cur += count[i];
    }
    return new double[] {min, max, avg, median, mode};
}




