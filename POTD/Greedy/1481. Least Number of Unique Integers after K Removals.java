class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n=arr.length;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int num:arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }   

        int freqCount[]=new int[n+1];
        // freqCount[i] = number of elements having i frequency
        for(int count:mp.values()){
            freqCount[count]++;
        }
        int uniqueElements=mp.size();

        for(int freq=1;freq<=n;freq++){
            int countUniqueElementsRemoved=Math.min(k/freq,freqCount[freq]);
            // k/freq - I can remove at max this number of elements whose frequency = freq
            // freqCount[freq] - Actual Number of elements you have whose frequency = freq

            k=k-(countUniqueElementsRemoved*freq);// Each one of them has frequency = freq
            uniqueElements-=countUniqueElementsRemoved;
            if(k<=freq){    
                return uniqueElements;
            }
        }
        return 0;// All were removed
    }
}
// Using counting sort
//T.C : O(n)
//S.C : O(n)





class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int num:arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }   

        PriorityQueue<Integer> pq=new PriorityQueue<>(mp.values()); //by default it is minheap
        int elemRemoved=0;
        while(!pq.isEmpty()){
            elemRemoved+=pq.peek();
            if(elemRemoved>k){
                return pq.size();
            }
            pq.poll();
        }
        return 0;
    }
}

// we have n elements inside the map and we have to put the freq of all elements inside the
// priority queue and the insertion for one element inside the priority queue is O(nlogn)
// and we have n elements so the overall complexity becomes O(nlogn)
// S.C:O(n) due to the priority queue and the map 


class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int num:arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }   

        List<Integer> freq=new ArrayList<>(mp.values());
        Collections.sort(freq);   

        int elemRemoved=0;
        for(int i=0;i<freq.size();i++){
            elemRemoved+=freq.get(i);
            if(elemRemoved>k){
                return freq.size()-i;
            }
        }
        return 0;
    }
}

// T.C:O(nlogn) due to the sorting 
// S.C:O(n) due to the map and freq array .In the Worst case it freq.size()==mp.size()