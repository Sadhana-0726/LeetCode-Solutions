1class Solution {
2    public int countSegments(String s) {
3        int count = 0;
4        for (int i = 0; i < s.length(); i++) {
5            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
6                count++;
7            }
8        }
9        return count;
10    }
11}