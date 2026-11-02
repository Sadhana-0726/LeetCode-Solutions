class Solution:
    def hIndex(self, citations: list[int]) -> int:
        n = len(citations)
        counts = [0] * (n + 1)
        
        for c in citations:
            if c >= n:
                counts[n] += 1
            else:
                counts[c] += 1
                
        h = 0
        for i in range(n, -1, -1):
            h += counts[i]
            if h >= i:
                return i
                
        return 0 