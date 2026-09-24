1class Solution {
2    public int jump(int[] nums) {
3        int jumps = 0;
4        int currentEnd = 0;
5        int farthest = 0;
6
7        for (int i = 0; i < nums.length - 1; i++) {
8            farthest = Math.max(farthest, i + nums[i]);
9
10            if (i == currentEnd) {
11                jumps++;
12                currentEnd = farthest;
13            }
14        }
15
16        return jumps;
17    }
18}