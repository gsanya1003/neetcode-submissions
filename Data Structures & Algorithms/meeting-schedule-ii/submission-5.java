

class Solution {
    public int minMeetingRooms(List<Interval> list) {
        int max = 0;
        if(list.size()==0)
        return 0;
            Collections.sort(list, (a, b) -> {

    if(a.start == b.start) {
        return a.end - b.end;
    }

    return a.start - b.start;
});
            PriorityQueue<Interval> st = new PriorityQueue<>((a, b) -> a.end - b.end);
            st.add(list.get(0));
            for(int i =1; i < list.size(); i++){
                
                Interval it = st.peek();
                while(st.size()>0 && st.peek().end <= list.get(i).start ){
                    st.remove();
                   
                }
                 st.add(list.get(i));
                  max = Math.max(max, st.size());
                
            }
            return Math.max(max, st.size());

    }
}
