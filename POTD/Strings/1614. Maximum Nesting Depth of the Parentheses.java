class Solution {
    public int maxDepth(String s) {
        int left=0;
        int right=0;
        int depth=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                left++;
            }
            else if(ch==')'){
                left--;
            }
            depth=Math.max(depth,left);            
        }
        return depth;
    }
}
// T.C:O(n)
// S.C:O(1)


class Solution {
    public int maxDepth(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        int depth=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                st.pop();
            }
            depth=Math.max(depth,st.size());            
        }
        return depth;
    }
}
// T.C:O(n)
// S.C:O(n)
