class Solution {
    int n;
    List<List<Integer>> ans=new ArrayList<>();
    public void solve(int idx,List<Integer> temp,int nums[]){
        if(idx>=n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(idx+1,temp,nums);
        temp.remove(new Integer(nums[idx]));
        solve(idx+1,temp,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        n=nums.length;
        List<Integer> temp=new ArrayList<>();
        solve(0,temp,nums);
        return ans;
    }
}
//T.C : O(2^n)
//S.C :  O(2^n*length of each subset) to store each subset
//       The recursion stack space complexity is O(N) , the maximum depth of the recursion is N, where N is the length of the input array.

class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void solve(int i,List<Integer> curr,int nums[]){
        
        if(i==nums.length){
            ans.add(new ArrayList(curr));
            return;
        }

        curr.add(nums[i]);  //doing something
        solve(i+1,curr,nums); //explore
        curr.remove(curr.size()-1); //revert step 1 and
        solve(i+1,curr,nums); //explore further
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr=new ArrayList<>();
        solve(0,curr,nums);  //start from 0 idx
        return ans;
    }
}