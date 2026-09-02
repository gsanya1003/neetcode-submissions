class MinStack {

 Stack<Integer> st;
 //PriorityQueue<Integer> pq;
 int min;
    public MinStack() {
        st = new Stack<>();
      //  pq = new PriorityQueue<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
     if(val <= min){
        st.push(min);
       min=val;
    }
    st.push(val);
    }
    
    public void pop() {
     if(st.pop() == min)
      min = st.pop();
    }
    
    public int top() {
       return  st.peek();
    }
    
    public int getMin() {
       return  min;
    }
}
