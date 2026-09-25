1class Solution {
2    public String toHex(int num) {
3        if (num == 0) return "0";
4        
5        char[] hexChars = "0123456789abcdef".toCharArray();
6        StringBuilder sb = new StringBuilder();
7        
8        while (num != 0 && sb.length() < 8) {
9            sb.append(hexChars[num & 15]);
10            num >>>= 4;
11        }
12        
13        return sb.reverse().toString();
14    }
15}