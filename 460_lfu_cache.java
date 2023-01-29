// https://leetcode.com/problems/lfu-cache/
// Runtime 93 ms Beats 47.75%
// Memory 127.6 MB Beats 70.60%

class LFUCache {
    int capacity;

    Map<Integer, Integer> map;
    Map<Integer, Integer> counts;
    List<LinkedList<Integer>> keysPerCount;
    int smallest;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        counts = new HashMap<>();
        keysPerCount = new ArrayList<>();
        keysPerCount.add(new LinkedList<>());
        keysPerCount.add(new LinkedList<>());
        smallest = 1;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        increaseCount(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.containsKey(key)) {
            increaseCount(key);
            map.put(key, value);
        } else {
            if (map.size() >= capacity) {
                int k = keysPerCount.get(smallest).poll();
                map.remove(k);
                counts.remove(k);
            }
            counts.put(key, 1);
            keysPerCount.get(1).offer(key);
            map.put(key, value);
            smallest = 1;
        }
    }

    void increaseCount(int key) {
        int c = counts.get(key);
        counts.put(key, c+1);

        if (keysPerCount.size()>c)
            keysPerCount.add(new LinkedList<>());
        keysPerCount.get(c).remove(Integer.valueOf(key));
        keysPerCount.get(c+1).offer(key);

        if (smallest == c && keysPerCount.get(c).size() == 0) {
            smallest = c+1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
