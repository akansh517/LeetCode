class Solution {
    public int maximumLength(String s) {
        Map<String,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();){
            StringBuilder sb=new StringBuilder(); // Use StringBuilder for efficient concatenation
            int j=i;
            while(j<s.length() && s.charAt(j)==s.charAt(i)){
                sb.append(s.charAt(j));
                j++;
            }
            String x=sb.toString(); // Create the string only once by converting sb
            mp.put(x,mp.getOrDefault(x,0)+1);
            i=j;
        }

        int ans=-1;
        for(Map.Entry<String,Integer> entry:mp.entrySet()){
            String a=entry.getKey();
            int len=a.length();
            int times=entry.getValue();
            if(len==1 && times>=3){
                ans=Math.max(ans,1);
            }
            else if(len>=2){
                // Store aWithoutLast for reuse
                String awithoutLast=a.substring(0,len-1);
                if(times>=3){
                    ans=Math.max(ans,len);
                }
                else if(times==2){
                    ans=Math.max(ans,len-1);
                }
                else if(times==1 && mp.containsKey(awithoutLast)){
                    ans=Math.max(ans,len-1);
                }
                else if(len>=3){
                    ans=Math.max(ans,len-2);
                }
            }
        }
        return ans;
    }
}


// x length -len
// x- x*3 times len will be len         aaaa   aaaa     aaaa
// x- x*2 times len will be len-1       aaaa    aaaa
// x- x*(x-1) len will be len-1         aaaa  aaa
// len>=3 then  len will be len-2       aaaa
