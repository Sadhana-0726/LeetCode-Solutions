1import java.util.HashSet;
2import java.util.Set;
3
4class Solution {
5    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
6        int sumA = 0;
7        int sumB = 0;
8        Set<Integer> setB = new HashSet<>();
9
10        for (int x : aliceSizes) {
11            sumA += x;
12        }
13        for (int y : bobSizes) {
14            sumB += y;
15            setB.add(y);
16        }
17
18        int delta = (sumB - sumA) / 2;
19
20        for (int x : aliceSizes) {
21            if (setB.contains(x + delta)) {
22                return new int[]{x, x + delta};
23            }
24        }
25
26        return new int[0];
27    }
28}