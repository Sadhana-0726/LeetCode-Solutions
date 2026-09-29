1class Solution {
2    private Boolean[][][] memo;
3
4    public boolean hasValidPath(char[][] grid) {
5        int m = grid.length;
6        int n = grid[0].length;
7
8        if ((m + n - 1) % 2 != 0) {
9            return false;
10        }
11
12        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
13            return false;
14        }
15
16        memo = new Boolean[m][n][(m + n) / 2 + 1];
17        return dfs(grid, 0, 0, 0);
18    }
19
20    private boolean dfs(char[][] grid, int r, int c, int open) {
21        if (grid[r][c] == '(') {
22            open++;
23        } else {
24            open--;
25        }
26
27        if (open < 0) {
28            return false;
29        }
30
31        int m = grid.length;
32        int n = grid[0].length;
33
34        if (open > (m + n - 1) / 2) {
35            return false;
36        }
37
38        if (r == m - 1 && c == n - 1) {
39            return open == 0;
40        }
41
42        if (memo[r][c][open] != null) {
43            return memo[r][c][open];
44        }
45
46        boolean res = false;
47
48        if (r + 1 < m) {
49            res = res || dfs(grid, r + 1, c, open);
50        }
51
52        if (c + 1 < n) {
53            res = res || dfs(grid, r, c + 1, open);
54        }
55
56        return memo[r][c][open] = res;
57    }
58}