1class Solution {
2    public int arrangeCoins(int n) {
3        long left = 0;
4        long right = n;
5
6        while (left <= right) {
7            long mid = left + (right - left) / 2;
8            long coinsUsed = mid * (mid + 1) / 2;
9
10            if (coinsUsed == n) {
11                return (int) mid;
12            } else if (coinsUsed < n) {
13                left = mid + 1;
14            } else {
15                right = mid - 1;
16            }
17        }
18
19        return (int) right;
20    }
21}