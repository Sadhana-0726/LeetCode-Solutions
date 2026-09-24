1class Solution {
2    public int search(int[] nums, int target) {
3        int left = 0;
4        int right = nums.length - 1;
5
6        while (left <= right) {
7            int mid = left + (right - left) / 2;
8
9            if (nums[mid] == target) {
10                return mid;
11            }
12
13            if (nums[left] <= nums[mid]) {
14                if (nums[left] <= target && target < nums[mid]) {
15                    right = mid - 1;
16                } else {
17                    left = mid + 1;
18                }
19            } else {
20                if (nums[mid] < target && target <= nums[right]) {
21                    left = mid + 1;
22                } else {
23                    right = mid - 1;
24                }
25            }
26        }
27
28        return -1;
29    }
30}