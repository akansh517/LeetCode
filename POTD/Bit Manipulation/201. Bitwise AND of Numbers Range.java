class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(right>left){
            right=right&(right-1);
        }
        return right;
    }
}

// T.C:O(log(n)), where n is the maximum number of bits needed to represent 
// the given input integers left and right.In the worst case a number has atmost log(n) bits
// means we have to unset that number of bits 
// S.C:O(1)
// E.g:left=1; then right>left bcz if we make right=0-1=-1 which is not possible

// using AND operation technique or facts
//1. n&(n-1) is basically used for clearing the rightmost set bit to 0
// 101
// 100
// ---
// 100
// 2.It also helps to find out the number of set bits 
// n=5 101 ==2 until the n&(n-1)==0 we will do the no. of operation continuously and the
// no. of operations is my setBits count 



// using shift approach

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shiftCount=0;
        while(left!=right){ //until left and right is not equal we are increasing the shiftCount
            left=left>>1;
            right=right>>1;
            shiftCount++;
        }
        return left<<shiftCount;//padding the 0's after the matching part
    }
}

// T.C:O(logn) O(log(n)), where n is the maximum number of bits needed 
// to represent the given input integers left and right. for e.g: left =00000
                                                                //right=11111
// in the above case we have to make all bits shift
// S.C:O(1)



// Both approaches aim to find the bitwise AND of a range of integers (left to right),
//  with the first approach using a shift-based method and the second approach 
//  utilizing the property that bitwise AND between a number and its predecessor
//   resets the rightmost set bit.
