import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] requestCount = new int[k];
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        TreeSet<Integer> available = new TreeSet<>();
        
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        
        for (int i = 0; i < arrival.length; i++) {
            int currTime = arrival[i];
            int duration = load[i];
            
            while (!busy.isEmpty() && busy.peek()[0] <= currTime) {
                available.add(busy.poll()[1]);
            }
            
            if (available.isEmpty()) {
                continue;
            }
            
            Integer targetServer = available.ceiling(i % k);
            if (targetServer == null) {
                targetServer = available.first();
            }
            
            requestCount[targetServer]++;
            busy.offer(new int[]{currTime + duration, targetServer});
            available.remove(targetServer);
        }
        
        int maxRequests = 0;
        for (int count : requestCount) {
            maxRequests = Math.max(maxRequests, count);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCount[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}