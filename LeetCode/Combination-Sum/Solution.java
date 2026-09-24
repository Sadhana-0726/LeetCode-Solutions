1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<List<Integer>> result = new ArrayList<>();
4        backtrack(candidates, target, 0, new ArrayList<>(), result);
5        return result;
6    }
7
8    private void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> result) {
9        if (remain == 0) {
10            result.add(new ArrayList<>(current));
11            return;
12        }
13
14        for (int i = start; i < candidates.length; i++) {
15            if (candidates[i] <= remain) {
16                current.add(candidates[i]);
17                backtrack(candidates, remain - candidates[i], i, current, result);
18                current.remove(current.size() - 1);
19            }
20        }
21    }
22} 