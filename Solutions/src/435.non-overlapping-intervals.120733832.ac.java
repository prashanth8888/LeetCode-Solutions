/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        
        if(intervals.length == 0) return 0;
        
        Arrays.sort(intervals, new MyComparator());
        
        int count = 0;
        int endInterval = intervals[0].end;
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start >= endInterval){
                endInterval = intervals[i].end;
                count++;
            }
        }
        
        return intervals.length - count - 1;
        
    }
    
}


class MyComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b)
        {
            return a.end - b.end;
        }
}
