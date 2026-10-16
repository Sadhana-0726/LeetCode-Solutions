1import java.util.*;
2
3class Solution {
4    private static final int MOD = 1_000_000_007;
5
6    private class SegmentTree {
7        int n;
8        long[] tree;
9        long[] lazy;
10        long[] squareSum;
11
12        public SegmentTree(int n) {
13            this.n = n;
14            this.tree = new long[4 * n];
15            this.lazy = new long[4 * n];
16            this.squareSum = new long[4 * n];
17        }
18
19        private void pushDown(int node, int start, int end) {
20            if (lazy[node] == 0) return;
21            long v = lazy[node];
22            lazy[node] = 0;
23
24            int mid = start + (end - start) / 2;
25            int leftChild = 2 * node + 1;
26            int rightChild = 2 * node + 2;
27
28            apply(leftChild, start, mid, v);
29            apply(rightChild, mid + 1, end, v);
30        }
31
32        private void apply(int node, int start, int end, long v) {
33            long len = end - start + 1;
34            squareSum[node] = (squareSum[node] + 2 * v % MOD * tree[node] % MOD + v * v % MOD * len % MOD) % MOD;
35            tree[node] = (tree[node] + v * len) % MOD;
36            lazy[node] = (lazy[node] + v) % MOD;
37        }
38
39        public void update(int node, int start, int end, int l, int r, long val) {
40            if (r < start || end < l) return;
41            if (l <= start && end <= r) {
42                apply(node, start, end, val);
43                return;
44            }
45            pushDown(node, start, end);
46            int mid = start + (end - start) / 2;
47            update(2 * node + 1, start, mid, l, r, val);
48            update(2 * node + 2, mid + 1, end, l, r, val);
49            tree[node] = (tree[2 * node + 1] + tree[2 * node + 2]) % MOD;
50            squareSum[node] = (squareSum[2 * node + 1] + squareSum[2 * node + 2]) % MOD;
51        }
52
53        public long getSquareSum() {
54            return squareSum[0];
55        }
56    }
57
58    public int sumCounts(int[] nums) {
59        int n = nums.length;
60        Map<Integer, Integer> lastPos = new HashMap<>();
61        SegmentTree st = new SegmentTree(n);
62        long totalSum = 0;
63
64        for (int i = 0; i < n; i++) {
65            int prevIdx = lastPos.getOrDefault(nums[i], -1);
66            st.update(0, 0, n - 1, prevIdx + 1, i, 1);
67            totalSum = (totalSum + st.getSquareSum()) % MOD;
68            lastPos.put(nums[i], i);
69        }
70
71        return (int) totalSum;
72    }
73}