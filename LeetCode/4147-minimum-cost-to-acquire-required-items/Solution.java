class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;

        long commonCost = Math.min(cb, c1 + c2);
        long commonCount = Math.min(n1, n2);

        long rem1 = n1 - commonCount;
        long rem2 = n2 - commonCount;

        long rem1Cost = rem1 * Math.min(cb, c1);
        long rem2Cost = rem2 * Math.min(cb, c2);

        return commonCount * commonCost + rem1Cost + rem2Cost;
    }
}