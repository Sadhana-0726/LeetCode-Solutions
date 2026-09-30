1class Solution {
2    public int findMiddleIndex(int[] nums) {
3        int total=0;
4        for(int n : nums){
5            total+=n;
6            
7        }
8        int Lsum=0;
9        for(int i=0;i<nums.length;i++){
10            int Rsum= total - Lsum - nums[i];
11
12            if(Lsum == Rsum){
13                return i;
14            }
15            Lsum= Lsum + nums[i];
16        }
17        return -1;
18    }
19}