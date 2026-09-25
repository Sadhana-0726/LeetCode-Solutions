1import java.util.*;
2
3class Solution {
4    public List<String> braceExpansionII(String expression) {
5        Stack<Set<String>> operandStack = new Stack<>();
6        Stack<Character> operatorStack = new Stack<>();
7        
8        int i = 0;
9        int n = expression.length();
10        
11        while (i < n) {
12            char ch = expression.charAt(i);
13            
14            if (ch == '{') {
15                if (i > 0 && (Character.isLetter(expression.charAt(i - 1)) || expression.charAt(i - 1) == '}')) {
16                    while (!operatorStack.isEmpty() && operatorStack.peek() == '*') {
17                        evaluate(operandStack, operatorStack);
18                    }
19                    operatorStack.push('*');
20                }
21                operatorStack.push('{');
22                i++;
23            } else if (ch == '}') {
24                while (!operatorStack.isEmpty() && operatorStack.peek() != '{') {
25                    evaluate(operandStack, operatorStack);
26                }
27                operatorStack.pop();
28                i++;
29            } else if (ch == ',') {
30                while (!operatorStack.isEmpty() && operatorStack.peek() != '{') {
31                    evaluate(operandStack, operatorStack);
32                }
33                operatorStack.push(',');
34                i++;
35            } else {
36                if (i > 0 && (Character.isLetter(expression.charAt(i - 1)) || expression.charAt(i - 1) == '}')) {
37                    while (!operatorStack.isEmpty() && operatorStack.peek() == '*') {
38                        evaluate(operandStack, operatorStack);
39                    }
40                    operatorStack.push('*');
41                }
42                
43                StringBuilder sb = new StringBuilder();
44                while (i < n && Character.isLetter(expression.charAt(i))) {
45                    sb.append(expression.charAt(i));
46                    i++;
47                }
48                
49                Set<String> set = new HashSet<>();
50                set.add(sb.toString());
51                operandStack.push(set);
52            }
53        }
54        
55        while (!operatorStack.isEmpty()) {
56            evaluate(operandStack, operatorStack);
57        }
58        
59        List<String> result = new ArrayList<>(operandStack.pop());
60        Collections.sort(result);
61        return result;
62    }
63    
64    private void evaluate(Stack<Set<String>> operandStack, Stack<Character> operatorStack) {
65        char op = operatorStack.pop();
66        Set<String> set2 = operandStack.pop();
67        Set<String> set1 = operandStack.pop();
68        Set<String> res = new HashSet<>();
69        
70        if (op == '*') {
71            for (String s1 : set1) {
72                for (String s2 : set2) {
73                    res.add(s1 + s2);
74                }
75            }
76        } else if (op == ',') {
77            res.addAll(set1);
78            res.addAll(set2);
79        }
80        
81        operandStack.push(res);
82    }
83}