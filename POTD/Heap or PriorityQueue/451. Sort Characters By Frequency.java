class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        // Building maxheap 
        PriorityQueue<Character> pq=new PriorityQueue((a,b)->mp.get(b)-mp.get(a));
        for(char c:mp.keySet()){
            pq.offer(c);
        }

        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            char c=pq.poll();
            for(int i=0;i<mp.get(c);i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

// Priority Queue is maxHeap ( mp.get(b) - mp.get(a) )
// mp.get(c) returns count of character from the map.
// Hence maxHeap would have highest frequency item as root on the top.

// T.C: O(nlogk), where k is the number of distinct character.
// S.C: O(n)
// Since we are inserting k elements into the max heap and each insertion costs log(k) 
// times,and we have n elements so overall T.C:O(nlogk)



class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        List<Character> chars=new ArrayList<>(mp.keySet());
        Collections.sort(chars,(a,b)->mp.get(b)-mp.get(a));//Sort in descending order
        StringBuilder sb=new StringBuilder();
        for(Object c:chars){
            for(int i=0;i<mp.get(c);i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

// T.C: O(nlogn), since we sort the characters
// S.C: O(n)