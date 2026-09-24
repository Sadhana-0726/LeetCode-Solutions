1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n = nums.length;
4        
5        for (int i = 0; i < n; i++) {
6            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
7                int correctIdx = nums[i] - 1;
8                int temp = nums[i];
9                nums[i] = nums[correctIdx];
10                nums[correctIdx] = temp;
11            }
12        }
13        
14        for (int i = 0; i < n; i++) {
15            if (nums[i] != i + 1) {
16                return i + 1;
17            }
18        }
19        
20        return n + 1;
21    }
22}