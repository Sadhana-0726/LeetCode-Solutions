from collections import defaultdict, deque

class Solution:
    def assignEdgeWeights(self, edges: list[list[int]]) -> int:
        MOD = 10**9 + 7
        n = len(edges) + 1
        
        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        
        depth = {1: 0}
        queue = deque([1])
        
        while queue:
            curr = queue.popleft()
            for neighbor in adj[curr]:
                if neighbor not in depth:
                    depth[neighbor] = depth[curr] + 1
                    queue.append(neighbor)
        
        max_depth = max(depth.values())
        
        return pow(2, max_depth - 1, MOD)