class Solution {
    public int pivotInteger(int n) {
        int sum=(int)(n*(n+1))/2;
        int x=(int)Math.sqrt(sum);
        return x*x==sum?x:-1;
    }
}

// Formula derivation: 1+2+-----+x==x+------+n
                    // adding 1+2+3+-----+x in both sides 
                    // 2*(1+2+3+-----+x)==1+2+3+------n+x
                    // 2*(x*(x+1))/2==n*(n+1)/2+x
                    // x=sqrt(n*(n+1))/2 and it will be only a positive number 
// T.C:O(1)
// S.C:O(1)


class Solution {
    public int pivotInteger(int n) {
        if(n==1){
            return n;
        }
        int leftValue=1,rightValue=n;
        int leftSum=leftValue,rightSum=rightValue;
        while(leftValue<rightValue){
            if(leftSum<rightSum){
                leftValue++;
                leftSum+=leftValue;
            }
            else{
                rightValue--;
                rightSum+=rightValue;
            }
            if(leftSum==rightSum && leftValue+1==rightValue-1){
                return leftValue+1;
            }
        }
        return -1;
    }
}

// T.C:O(n)
// S.C:O(1)


class Solution {
    public int pivotInteger(int n) {
        int sum1=0;
        for(int i=1;i<=n;i++){
            sum1+=i;
            int sum2=0;
            for(int j=i;j<=n;j++){
                sum2+=j;
            }
            if(sum1==sum2){
                return i;
            }
        }
        return -1;
    }
}

// T.C:O(n^2)
// S.c:O(1)



class Solution {
    public int pivotInteger(int n) {
        for(int i=1;i<=n;i++){
            int sum1=0;
            int sum2=0;
            for(int j=1;j<=i;j++){
                sum1+=j;
            }

            for(int k=i;k<=n;k++){
                sum2+=k;
            }

            if(sum1==sum2){
                return i;
            }
        }
        return -1;
    }
}

// T.C:O(n^2)
// S.C:O(1)



