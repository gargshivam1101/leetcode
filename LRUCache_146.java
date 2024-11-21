class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void addAfterHead(Node node) {
        Node front = head.next;
        head.next = node;
        node.next = front;
        front.prev = node;
        node.prev = head;
    }

    private Node removeFromLast() {
        Node removing = tail.prev;
        removing.prev.next = tail;
        tail.prev = removing.prev;
        return removing;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    Node head, tail;
    Map<Integer, Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            removeNode(node);
            addAfterHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            // make the node and add right after head
            node = new Node(key, value);
            cache.put(key, node);
            addAfterHead(node);

            if (cache.size() > capacity) {
                Node removed = removeFromLast();
                cache.remove(removed.key);
            }
        } else {
            // update val and move next to head
            node.val = value;
            removeNode(node);
            addAfterHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
