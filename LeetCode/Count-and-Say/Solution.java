1class Solution {
2    public String countAndSay(int n) {
3        if (n <= 0) return "";
4        
5        String result = "1";
6        
7        for (int i = 1; i < n; i++) {
8            StringBuilder current = new StringBuilder();
9            int count = 1;
10            
11            for (int j = 0; j < result.length(); j++) {
12                if (j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
13                    count++;
14                } else {
15                    current.append(count).append(result.charAt(j));
16                    count = 1;
17                }
18            }
19            
20            result = current.toString();
21        }
22        
23        return result;
24    }
25}