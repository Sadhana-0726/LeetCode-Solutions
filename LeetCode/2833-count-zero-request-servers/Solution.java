class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] result = new int[m];
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0, right = 0;
        int activeServers = 0;

        for (int i = 0; i < m; i++) {
            int queryTime = sortedQueries[i][0];
            int originalIdx = sortedQueries[i][1];
            int startTime = queryTime - x;

            while (right < logs.length && logs[right][1] <= queryTime) {
                int server = logs[right][0];
                int currentFreq = countMap.getOrDefault(server, 0);
                if (currentFreq == 0) {
                    activeServers++;
                }
                countMap.put(server, currentFreq + 1);
                right++;
            }

            while (left < logs.length && logs[left][1] < startTime) {
                int server = logs[left][0];
                int currentFreq = countMap.get(server);
                if (currentFreq == 1) {
                    activeServers--;
                    countMap.remove(server);
                } else {
                    countMap.put(server, currentFreq - 1);
                }
                left++;
            }

            result[originalIdx] = n - activeServers;
        }

        return result;
    }
}