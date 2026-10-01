1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> st = new Stack<>();
4
5        for (char c : s.toCharArray()) {
6            if (c == '(') st.push(')');
7            else if (c == '{') st.push('}');
8            else if (c == '[') st.push(']');
9            else {
10                if (st.isEmpty() || st.pop() != c) return false;
11            }
12        }
13        return st.isEmpty();
14    }
15}
16 // bro, make sure the parenthesis matches if yes true, if not false