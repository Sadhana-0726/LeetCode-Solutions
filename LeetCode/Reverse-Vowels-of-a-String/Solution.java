1class Solution {
2    public String reverseVowels(String s) {
3        char[] chars = s.toCharArray();
4        int left = 0;
5        int right = chars.length - 1;
6        
7        while (left < right) {
8            while (left < right && !isVowel(chars[left])) {
9                left++;
10            }
11            while (left < right && !isVowel(chars[right])) {
12                right--;
13            }
14            
15            if (left < right) {
16                char temp = chars[left];
17                chars[left] = chars[right];
18                chars[right] = temp;
19                left++;
20                right--;
21            }
22        }
23        
24        return new String(chars);
25    }
26
27    private boolean isVowel(char c) {
28        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
29               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
30    }
31}