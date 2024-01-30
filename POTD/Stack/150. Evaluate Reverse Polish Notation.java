class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int n=tokens.length;
        for(int i=0;i<n;i++){
            if(tokens[i].equals("+")){
                int first=st.pop();
                int second=st.pop();
                int res=second+first;
                st.push(res);
            }
            else if(tokens[i].equals("-")){
                int first=st.pop();
                int second=st.pop();
                int res=second-first;
                st.push(res);
            }
            else if(tokens[i].equals("*")){
                int first=st.pop();
                int second=st.pop();
                int res=second*first;
                st.push(res);
            }
            else if(tokens[i].equals("/")){
                int first=st.pop();
                int second=st.pop();
                int res=second/first;
                st.push(res);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}



// T.C:O(n) just traversing the String array
// S.C:O(n) due to the stack 