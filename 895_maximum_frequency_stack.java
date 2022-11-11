// https://leetcode.com/problems/maximum-frequency-stack/
// Runtime: 42 ms, faster than 87.35%
// Memory Usage: 69.4 MB, less than 83.44%

class FreqStack {
    Map<Integer, LinkedList<Integer>> st;
    Map<Integer, Integer> counts;
    int maxFreq;

    public FreqStack() {
        st = new HashMap<>();
        counts = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int f = counts.getOrDefault(val, 0) + 1;
        counts.put(val, f);
        if (f > maxFreq)
            maxFreq = f;

        st.putIfAbsent(f, new LinkedList());
        LinkedList<Integer> s = st.get(f);
        s.addFirst(val);
    }

    public int pop() {
        LinkedList<Integer> s = st.get(maxFreq);
        int val = s.removeFirst();
        counts.put(val, maxFreq-1);
        if (s.isEmpty())
            maxFreq -= 1;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
