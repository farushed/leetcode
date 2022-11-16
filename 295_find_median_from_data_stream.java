// https://leetcode.com/problems/find-median-from-data-stream/
// Runtime: 178 ms, faster than 80.82%
// Memory Usage: 60.6 MB, less than 98.27%

class MedianFinder {
    Heap<Integer> below;
    Heap<Integer> above;
    double median;
    boolean odd;

    public MedianFinder() {
        below = new Heap(false); // max heap
        above = new Heap(true); // min heap
        median = 0;
        odd = false;
    }

    public void addNum(int num) {
        if (num > median) {
            above.add(num);
            if (odd) below.add((int) median);
        } else {
            below.add(num);
            if (odd) above.add((int) median);
        }

        odd = !odd;

        if (odd) {
            if (above.size() > below.size())
                median = above.pop();
            else
                median = below.pop();
        }
        else
            median = ((double) (below.peek() + above.peek())) / 2.0;
    }

    public double findMedian() {
        return median;
    }
}



class Heap<T extends Comparable<T>> {
    List<T> arr;
    boolean minHeap;

    public Heap(boolean min) {
        arr = new ArrayList<>();
        arr.add(null);
        minHeap = min;
    }

    public int size() {
        return arr.size()-1;
    }

    public void add(T val) {
        arr.add(val);
        swim(arr.size()-1);
    }

    public T pop() {
        int n = arr.size()-1;
        T ret = arr.get(1);

        arr.set(1, arr.get(n));
        arr.remove(n);
        sink(1);

        return ret;
    }

    public T peek() {
        return arr.get(1);
    }

    private boolean order(int a, int b) {
        if (minHeap)
            return arr.get(a).compareTo(arr.get(b)) < 0;
        return arr.get(a).compareTo(arr.get(b)) > 0;
    }

    private void exch(int a, int b) {
        T tmp = arr.get(b);
        arr.set(b, arr.get(a));
        arr.set(a, tmp);
    }

    private void swim(int k) {
        while (k > 1 && !order(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        int j = 2*k;
        int n = arr.size()-1;
        while (j <= n) {
            if (j < n && !order(j, j+1)) j++;
            if (order(k, j)) break;
            exch(k, j);
            k = j;
            j = 2*k;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
