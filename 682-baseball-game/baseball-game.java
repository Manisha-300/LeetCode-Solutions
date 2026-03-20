class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        
        for(String s: operations)
        {
            if (s.equals("+"))
            {
                int x= st.pop();
                int y =st.pop();
                int z=x+y;
                st.push(y);
                st.push(x);
                st.push(z);
            }
            else if(s.equals("D"))
            {
                int a=st.pop();
                int b=2*a;
                st.push(a);
                st.push(b);
            }
            else if(s.equals("C"))
            {
                st.pop();
            }
            else
            {
                st.push(Integer.parseInt(s));
            }
        }
        int sum=0;
        for(int num:st)
        {
            sum=sum+num;
        }

        return sum;

    }
}