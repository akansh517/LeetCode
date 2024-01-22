class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int dup=-1;
        int missing=-1;
        for(int i=0;i<n;i++){
            int num=Math.abs(nums[i]);
            if(nums[num-1]<0){
                dup=num;
            }
            else{
                nums[num-1]*=(-1);
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                missing=i+1;
                break;
            }
        }

        return new int[]{dup,missing};
    }
}

// T.C:O(n)
// S.C:O(1)


// class Solution {
//     public int[] findErrorNums(int[] nums) {
//         int n=nums.length;
//         Set<Integer> set=new HashSet<>();
//         for(int i=1;i<=n;i++){
//             set.add(i);
//         }
//         System.out.println(set);
//         Set<Integer> set2=new HashSet<>();
//         int repeat=-1;
//         for(int val:nums){
//             if(set2.contains(val)){
//                 repeat=val;
//             }
//             set2.add(val);
//         }
//         System.out.println(repeat);
//         System.out.println(set2);
//         int missing=-1;
//         for(int i=1;i<=n;i++){
//             if(!set2.contains(i)){
//                 missing=i;
//                 break;
//             }
//         }

//         return new int[]{repeat,missing};
//     }
// }



class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int x:nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }
        System.out.println(mp);
        int dup=-1;
        int missing=-1;
        for(int i=1;i<=nums.length;i++){
            if(!mp.containsKey(i)){
                missing=i;
            }
            if(mp.get(i)!=null && mp.get(i)!=1){
                dup=i;
            }
        }
        return new int[]{dup,missing};
    }
}


// T.C:O(n)
// S.C:O(n)


// 4th by using arithmetic progression and cumulative sum
// expectedSum = n * (n+1) / 2.
// missing number = expectedSum - (actualSum - duplicatedNumber).