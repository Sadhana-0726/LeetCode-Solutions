1class Solution {
2    public int largestAltitude(int[] gain) {
3        int max=0;
4        int cur=0;
5        for (int i=0;i<gain.length;i++){
6            cur=cur + gain[i];
7            max = Math.max(max, cur);
8        }
9        return max;
10    }
11}