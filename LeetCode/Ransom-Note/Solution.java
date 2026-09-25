1class Solution {
2    public boolean canConstruct(String ransomNote, String magazine) {
3        if (ransomNote.length() > magazine.length()) {
4            return false;
5        }
6
7        int[] count = new int[26];
8
9        for (char c : magazine.toCharArray()) {
10            count[c - 'a']++;
11        }
12
13        for (char c : ransomNote.toCharArray()) {
14            if (count[c - 'a'] == 0) {
15                return false;
16            }
17            count[c - 'a']--;
18        }
19
20        return true;
21    }
22}