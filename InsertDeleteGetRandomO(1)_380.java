class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map; // store the index of val in the list

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1); // value of map is index of val
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // replace val with last element of list, update in map, and remove
        int idx = map.get(val);
        list.set(idx, list.get(list.size() - 1)); // idx now contains last element
        map.put(list.get(idx), idx); // update its location to new one
        list.remove(list.size() - 1); // remove last element, which was duplicate, O(1)
        map.remove(val); // val is no more
        return true;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
