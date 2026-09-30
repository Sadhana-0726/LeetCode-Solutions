1class Solution {
2    public int pivotIndex(int[] nums) {
3        int total = 0 ; 
4        for(int i=0; i < nums.length ; i++){
5            total = total + nums[i];
6        }
7        int Lsum = 0;
8        for(int i=0;i<nums.length;i++){
9            int Rsum = total - Lsum - nums[i];
10
11            if(Lsum == Rsum){
12                return i;
13            }
14            Lsum+=nums[i];
15        }
16        return -1;
17        
18    }
19}