class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        //all Possible combination will be from these combinations only
        List<Integer> allPossible=List.of(
            12,23,34,45,56,67,78,89,
            123,234,345,456,567,678,789,
            1234,2345,3456,4567,5678,6789,
            12345,23456,34567,45678,56789,
            123456,234567,345678,456789,
            1234567,2345678,3456789,
            12345678,23456789,
            123456789
        );
        List<Integer> ans=new ArrayList<>();
        int n=allPossible.size();
        for(int i=0;i<n;i++){
            if(allPossible.get(i)<low){
                continue;
            } 
            if(allPossible.get(i)>high){
                break;
            }
            ans.add(allPossible.get(i));
        }
        return ans;
    }
}
// T.C:O(1)
// S.C:O(1)



class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> que=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<9;i++){
            que.offer(i);
        }

        while(!que.isEmpty()){
            int temp=que.poll();
            if(temp>=low && temp<=high){
                ans.add(temp);
            }
            int lastDigit=temp%10;
            if(lastDigit+1<=9){//e.g:-910 after the 9 1 is small no. so that why 9 is not taken
                que.offer(temp*10+(lastDigit+1));
            }
        }
        return ans;
    }
}

// Using simple BFS
//T.C : O(N), where N is the number of valid sequential digits in the specified range.
//S.C : O(N), where N is the number of valid sequential digits in the specified range. (queue size)