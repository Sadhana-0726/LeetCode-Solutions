1class Solution {
2    public int[] corpFlightBookings(int[][] bookings, int n) {
3        int[]res = new int[n];
4        for(int[] b : bookings){
5            int start = b[0]-1;
6            int end = b[1]-1;
7            int seats = b[2];
8
9
10            for(int i= start ; i<=end;i++){
11                res[i] = res[i] + seats;
12            }
13        }
14        return res;
15    }
16}