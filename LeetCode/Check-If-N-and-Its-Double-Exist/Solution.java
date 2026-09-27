1import java.util.HashSet;
2import java.util.Set;
3
4class Solution {
5    public boolean checkIfExist(int[] arr) {
6        Set<Integer> seen = new HashSet<>();
7
8        for (int num : arr) {
9            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
10                return true;
11            }
12            seen.add(num);
13        }
14
15        return false;
16    }
17}