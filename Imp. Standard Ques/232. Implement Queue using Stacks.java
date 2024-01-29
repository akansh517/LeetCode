class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    int peekEl=-1;
    public MyQueue() {
        input=new Stack<>();
        output=new Stack<>();
    }
    
    public void push(int x) {
        if(input.isEmpty()){ //when the element is the first element then i will put this element into the peekEl variable
            peekEl=x;
        }
        input.add(x); //O(1)
    }
//amortized O(1) i.e in most of the cases it will be O(1) when output stack is not empty and in some of the cases like when output is empty then i have to transfer input->output i.e O(n)
    public int pop() {
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.add(input.pop());
            }
        }
        return output.pop();
    }
    
    public int peek() {
        if(output.isEmpty()){
            return peekEl;
        }
        int val=output.peek();
        return val;
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}





// using que d.s
// class MyQueue {
//     Queue<Integer> que;
//     public MyQueue() {
//         que=new LinkedList<Integer>();
//     }
    
//     public void push(int x) {
//         que.add(x);
//     }
    
//     public int pop() {
//         return que.remove();
//     }
    
//     public int peek() {
//         return que.peek();
//     }
    
//     public boolean empty() {
//         return que.isEmpty();
//     }
// }




/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */