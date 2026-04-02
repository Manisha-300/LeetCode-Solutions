class MinStack {
        Stack<Integer> st=new Stack<>(),s=new Stack<>();
    
    public void push(int val) {
        st.push(val);
        if(s.isEmpty() ||val <=s.peek()) s.push(val);
    }
    
    public void pop() {
        if(st.peek().equals(s.peek())) s.pop();
        st.pop();
            }
    
    public int top() {
       return st.isEmpty() ? -1:st.peek();
    }
    
    public int getMin() {
       return s.isEmpty() ?-1:s.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */