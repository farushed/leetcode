// https://leetcode.com/problems/implement-queue-using-stacks/
// Runtime 0 ms Beats 100%
// Memory 39.8 MB Beats 96.30%

class MyQueue {
    private Deque<Integer> tmpstack;
    private Deque<Integer> qstack;

    public MyQueue() {
        qstack = new ArrayDeque();
        tmpstack = new ArrayDeque();
    }
    
    public void push(int x) {
        while (!qstack.isEmpty()) {
            tmpstack.push(qstack.pop());
        }
        qstack.push(x);
        while (!tmpstack.isEmpty()) {
            qstack.push(tmpstack.pop());
        }
    }
    
    public int pop() {
        return qstack.pop();
    }
    
    public int peek() {
        return qstack.peek();
    }
    
    public boolean empty() {
        return qstack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
