1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        int n = seq.length();
4        int[] res = new int[n];
5        for (int i = 0; i < n; i++) {
6            res[i] = (seq.charAt(i) == '(') ? (i & 1) : ((i & 1) ^ 1);
7        }
8        return res;
9    }
10}