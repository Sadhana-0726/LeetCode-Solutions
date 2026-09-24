1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
7        List<List<Integer>> result = new ArrayList<>();
8        Arrays.sort(candidates);
9        backtrack(candidates, target, 0, new ArrayList<>(), result);
10        return result;
11    }
12
13    private void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> result) {
14        if (remain == 0) {
15            result.add(new ArrayList<>(current));
16            return;
17        }
18
19        for (int i = start; i < candidates.length; i++) {
20            if (i > start && candidates[i] == candidates[i - 1]) {
21                continue;
22            }
23
24            if (candidates[i] > remain) {
25                break;
26            }
27
28            current.add(candidates[i]);
29            backtrack(candidates, remain - candidates[i], i + 1, current, result);
30            current.remove(current.size() - 1);
31        }
32    }
33}