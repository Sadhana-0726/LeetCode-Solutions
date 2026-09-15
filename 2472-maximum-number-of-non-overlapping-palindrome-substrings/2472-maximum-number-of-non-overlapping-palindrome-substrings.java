class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int i = 0;

        while (i < n) {
            if (i + k <= n) {
                boolean isPal = true;
                for (int l = i, r = i + k - 1; l < r; l++, r--) {
                    if (s.charAt(l) != s.charAt(r)) {
                        isPal = false;
                        break;
                    }
                }
                if (isPal) {
                    count++;
                    i += k;
                    continue;
                }
            }

            if (i + k + 1 <= n) {
                boolean isPal = true;
                for (int l = i, r = i + k; l < r; l++, r--) {
                    if (s.charAt(l) != s.charAt(r)) {
                        isPal = false;
                        break;
                    }
                }
                if (isPal) {
                    count++;
                    i += k + 1;
                    continue;
                }
            }

            i++;
        }

        return count;
    }
}