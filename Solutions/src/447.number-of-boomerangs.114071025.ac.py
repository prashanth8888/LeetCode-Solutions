class Solution(object):
    def numberOfBoomerangs(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        
        res = 0
        
        for p in points:
            cmap = {}
            
            for q in points:
                dist1 = p[0] - q[0]
                dist2 = p[1] - q[1]
                cmap[dist1*dist1 + dist2*dist2] = cmap.get(dist1*dist1 + dist2*dist2, 0) + 1
            
            for k in cmap:
                res += cmap[k] * (cmap[k] - 1)
        
        return res
        
