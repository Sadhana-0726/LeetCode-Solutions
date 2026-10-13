1import java.util.Arrays;
2
3class Solution {
4    public long maxAlternatingSum(int[] nums) {
5        int n = nums.length;
6        long[] sq = new long[n];
7        for (int i = 0; i < n; i++) {
8            sq[i] = (long) nums[i] * nums[i];
9        }
10        Arrays.sort(sq);
11        
12        long sum = 0;
13        int half = n / 2;
14        for (int i = 0; i < half; i++) {
15            sum -= sq[i];
16        }
17        for (int i = half; i < n; i++) {
18            sum += sq[i];
19        }
20        return sum;
21    }
22}