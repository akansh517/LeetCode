class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if(a==e || b==f){ //rook and queen are in the same line
            if(a==e && a==c && ((d-b)*(d-f)<0))  return 2;//checking horizontally that bishop lies in between the queen and rook
            if(b==f && b==d && ((c-a)*(c-e)<0)) return 2;//checking vertically that bishop lies in between the queen and rook
            return 1; //queen and rook are on the same line and bishop is not present in between them
        }

        if(Math.abs(c-e)==Math.abs(d-f)){ //queen and bishop lies diagonally on the same line
            if(Math.abs(a-c)==Math.abs(b-d) && (b-f)*(b-d)<0)   return 2;//checking if rook is in between the bishop and queen that are placed diagonally in the same line
            return 1;//rook is not between them and both queen and bishop lies diagonally on the same line
        }
        return 2;//in any other case either rook or bishop will take atmost 2 steps to capture the queen 
    }
}


// T.C:O(1)
// S.C:O(1)