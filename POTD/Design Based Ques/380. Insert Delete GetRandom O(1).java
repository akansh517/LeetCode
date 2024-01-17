class RandomizedSet {
    ArrayList<Integer> vec;
    HashMap<Integer,Integer> mp;
    private Random random;
    public RandomizedSet() {
        vec=new ArrayList<>();
        mp=new HashMap<>();
        random=new Random();
    }
    // Inserts a value to the set. Returns true if the set did not already contain the specified element.
    public boolean insert(int val) {
        if(mp.containsKey(val)){
            return false;
        }
        vec.add(val);
        mp.put(val,vec.size()-1);
        return true;
    }   

    //  Removes a value from the set. Returns true if the set contained the specified element. 
    public boolean remove(int val) {
        if(!mp.containsKey(val)){
            return false;
        }
        int idx=mp.get(val);
        int lastElement=vec.get(vec.size()-1);
        vec.set(idx,lastElement);
        mp.put(lastElement,idx);
        vec.remove(vec.size()-1);
        mp.remove(val);
        return true;
    }
    // Get a random element from the set. 
    public int getRandom() {
        int n=vec.size();
        int randIndex=random.nextInt(n);
        return vec.get(randIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */