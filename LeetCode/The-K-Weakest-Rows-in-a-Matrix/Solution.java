1import java.util.Arrays;
2
3class Solution {
4    public int[] kWeakestRows(int[][] mat, int k) {
5        int m = mat.length;
6        int[][] rowStrengths = new int[m][2];
7
8        for (int i = 0; i < m; i++) {
9            rowStrengths[i][0] = countSoldiers(mat[i]);
10            rowStrengths[i][1] = i;
11        }
12
13        Arrays.sort(rowStrengths, (a, b) -> {
14            if (a[0] != b[0]) {
15                return Integer.compare(a[0], b[0]);
16            }
17            return Integer.compare(a[1], b[1]);
18        });
19
20        int[] result = new int[k];
21        for (int i = 0; i < k; i++) {
22            result[i] = rowStrengths[i][1];
23        }
24
25        return result;
26    }
27
28    private int countSoldiers(int[] row) {
29        int left = 0;
30        int right = row.length - 1;
31
32        while (left <= right) {
33            int mid = left + (right - left) / 2;
34            if (row[mid] == 1) {
35                left = mid + 1;
36            } else {
37                right = mid - 1;
38            }
39        }
40
41        return left;
42    }
43}