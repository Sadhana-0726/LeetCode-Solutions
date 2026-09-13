import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> nonZero1 = new ArrayList<>();
        List<int[]> nonZero2 = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    nonZero1.add(new int[]{r, c});
                }
                if (img2[r][c] == 1) {
                    nonZero2.add(new int[]{r, c});
                }
            }
        }

        Map<String, Integer> count = new HashMap<>();
        int maxOverlap = 0;

        for (int[] p1 : nonZero1) {
            for (int[] p2 : nonZero2) {
                int dr = p2[0] - p1[0];
                int dc = p2[1] - p1[1];
                String key = dr + "," + dc;
                int currentCount = count.getOrDefault(key, 0) + 1;
                count.put(key, currentCount);
                maxOverlap = Math.max(maxOverlap, currentCount);
            }
        }

        return maxOverlap;
    }
}