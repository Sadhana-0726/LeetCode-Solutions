1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> permuteUnique(int[] nums) {
7        List<List<Integer>> result = new ArrayList<>();
8        Arrays.sort(nums);
9        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
10        return result;
11    }
12
13    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
14        if (current.size() == nums.length) {
15            result.add(new ArrayList<>(current));
16            return;
17        }
18
19        for (int i = 0; i < nums.length; i++) {
20            if (used[i]) continue;
21            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
22
23            used[i] = true;
24            current.add(nums[i]);
25            backtrack(result, current, nums, used);
26            used[i] = false;
27            current.remove(current.size() - 1);
28        }
29    }
30}