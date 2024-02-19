class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        int bits=Integer.bitCount(n);
        return (bits==1)?true:false;
    }
}

// The observation we can conclude is that the number which is a 
// power of two has always compulsory 1 true bit.
// 4->0000 0100
// 8->0000 1000


class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        return (n&(n-1))==0;
    }
}


// T.C:O(1)
// S.C:O(1)




class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        while(n%2==0){
            n=n/2;
        }
        return n==1;
    }
}

// T.C:O(logn)
// S.C:O(1)





class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        return (n==1 || n%2==0 && isPowerOfTwo(n/2));
    }
}

// T.C:O(logn)
// S.C:O(logn)  due to the recursive stack

