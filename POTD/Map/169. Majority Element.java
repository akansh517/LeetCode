class Solution {
    public int majorityElement(int[] nums) {
        int el=0;
        int cnt=0;
        for(int num:nums){
            if(cnt==0){
                el=num;
                cnt++;
            }
            else if(num==el){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        return el;
    }
}

// T.C:O(n)
// S.C:O(1)



class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            if(mp.get(num)>n/2){
                return num;
            }
        }
        return -1;
    }
}

// T.C:O(n)
// S.C:O(n)