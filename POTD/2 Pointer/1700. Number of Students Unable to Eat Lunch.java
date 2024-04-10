class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int arr[]=new int[2];
        //arr[0] = count of student who like circular
        //arr[1] = count of student who like square
        for(int stud:students){
            arr[stud]++;
        } 
        int n=students.length;
        for(int i=0;i<n;i++){
            int sandwich=sandwiches[i];
            if(arr[sandwich]==0){
                return n-i;
            }
            arr[sandwich]--;
        }
        return 0;
    }
}
// T.C:O(n+m)
// S.C:O(1)




class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int len = students.length;
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < len; i++) {
            st.push(sandwiches[len - i - 1]);
            que.add(students[i]);
        }

        int lastServed = 0;
        while (!que.isEmpty() && lastServed < que.size()) {
            if (st.peek() == que.peek()) {
                st.pop();
                que.poll();
                lastServed = 0;
            } else {
                que.add(que.peek());
                que.poll();
                lastServed++;
            }
        }

        return que.size();
    }
}

// (Simply simulate whatever the problem asks for)
//T.C : O(n)
//S.C : O(n)
