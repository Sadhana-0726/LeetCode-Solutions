1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3        int[] result = new int[]{-1, -1};
4        result[0] = findBound(nums, target, true);
5        
6        if (result[0] != -1) {
7            result[1] = findBound(nums, target, false);
8        }
9        
10        return result;
11    }
12
13    private int findBound(int[] nums, int target, boolean isFirst) {
14        int left = 0;
15        int right = nums.length - 1;
16        int bound = -1;
17
18        while (left <= right) {
19            int mid = left + (right - left) / 2;
20
21            if (nums[mid] == target) {
22                bound = mid;
23                if (isFirst) {
24                    right = mid - 1; // Search left half for the first position
25                } else {
26                    left = mid + 1;  // Search right half for the last position
27                }
28            } else if (nums[mid] < target) {
29                left = mid + 1;
30            } else {
31                right = mid - 1;
32            }
33        }
34
35        return bound;
36    }
37}