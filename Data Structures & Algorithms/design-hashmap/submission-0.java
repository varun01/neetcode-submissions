class MyHashMap {
    final boolean[] keys;
    final int[] values;

    public MyHashMap() {
        keys = new boolean[1000001];
        values = new int[1000001];
    }

    public void put(int key, int value) {
        keys[key] = true;
        values[key] = value;
    }

    public int get(int key) {
        if (keys[key]) {
            return values[key];
        } else {
            return -1;
        }
    }

    public void remove(int key) {
        keys[key] = false;
        values[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */