1class Solution {
2    public boolean isSubsequence(String s, String t) {
3        int i = 0;
4        int j = 0;
5
6        while (i < s.length() && j < t.length()) {
7            if (s.charAt(i) == t.charAt(j)) {
8                i++;
9            }
10            j++;
11        }
12
13        return i == s.length();
14    }
15}