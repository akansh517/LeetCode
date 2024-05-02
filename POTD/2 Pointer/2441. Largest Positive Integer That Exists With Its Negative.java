class Solution {
    public int findMaxK(int[] nums) {
        int arr[]=new int[2001];
        int ans=-1;
        for(int num:nums){
            if(arr[-num+1000]==1){
                ans=Math.max(ans,Math.abs(num));
            }
            arr[num+1000]=1;
        }
        return ans;
    }
}
// T.C:O(n)
// S.C:O(1)


class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int res=-1;
        while(i<j){
            if(-(nums[i])==nums[j]){
                return nums[j];
            }
            if(-(nums[i])<nums[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return res;
    }
}

// (Using Sorting + 2-Pointers)
// T.C : O(n)
// S.C : O(1)



class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int result = -1;

        for (int num : nums) {
            if (seen.contains(-num)) {
                result = Math.max(result, Math.abs(num));
            }
            seen.add(num);
        }
        
        return result;
    }
}

// (Using set)
// T.C : O(n)
// S.C : O(n)


class Solution {
    public int findMaxK(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            if(num<0){
                list.add(num);
            }
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        System.out.println(list);
        int ans=-1;
        for(int val:list){
            int pos=Math.abs(val);
            if(mp.containsKey(pos) && pos>ans){
                ans=pos;
            }
        }
        return ans;
    }
}