1class Solution {
2    public boolean isPerfectSquare(int num) {
3        long left = 1;
4        long right = num;
5
6        while (left <= right) {
7            long mid = left + (right - left) / 2;
8            long square = mid * mid;
9
10            if (square == num) {
11                return true;
12            } else if (square < num) {
13                left = mid + 1;
14            } else {
15                right = mid - 1;
16            }
17        }
18
19        return false;
20    }
21}