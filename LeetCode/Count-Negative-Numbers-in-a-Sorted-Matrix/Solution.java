1class Solution {
2    public int countNegatives(int[][] grid) {
3        int rows = grid.length;
4        int cols = grid[0].length;
5        int count = 0;
6
7        int row = rows - 1;
8        int col = 0;
9
10        while (row >= 0 && col < cols) {
11            if (grid[row][col] < 0) {
12                count += cols - col;
13                row--;
14            } else {
15                col++;
16            }
17        }
18
19        return count;
20    }
21}