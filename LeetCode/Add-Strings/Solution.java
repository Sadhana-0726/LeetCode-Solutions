1class Solution {
2    public String addStrings(String num1, String num2) {
3        StringBuilder sb = new StringBuilder();
4        int i = num1.length() - 1;
5        int j = num2.length() - 1;
6        int carry = 0;
7
8        while (i >= 0 || j >= 0 || carry > 0) {
9            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
10            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
11
12            int sum = digit1 + digit2 + carry;
13            sb.append(sum % 10);
14            carry = sum / 10;
15
16            i--;
17            j--;
18        }
19
20        return sb.reverse().toString();
21    }
22}