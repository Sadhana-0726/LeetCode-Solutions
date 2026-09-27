1class Solution {
2    public String reverseParentheses(String s) {
3        Stack<Integer> stack = new Stack<>();
4        StringBuilder sb = new StringBuilder();
5
6        for (char c : s.toCharArray()) {
7            if (c == '(') {
8                stack.push(sb.length());
9            } else if (c == ')') {
10                int start = stack.pop();
11                reverse(sb, start, sb.length() - 1);
12            } else {
13                sb.append(c);
14            }
15        }
16
17        return sb.toString();
18    }
19
20    private void reverse(StringBuilder sb, int left, int right) {
21        while (left < right) {
22            char temp = sb.charAt(left);
23            sb.setCharAt(left, sb.charAt(right));
24            sb.setCharAt(right, temp);
25            left++;
26            right--;
27        }
28    }
29}