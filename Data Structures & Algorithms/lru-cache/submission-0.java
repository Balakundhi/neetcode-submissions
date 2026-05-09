class Node{
    public int key;
    public int value;
    public Node next;
    public Node previous;

    Node(){
        key = value = -1;
        next = previous = null;
    }

    Node(int key, int value){
        this.key = key;
        this.value = value;
        next = previous = null;
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public void deleteNode(Node node){
        Node previousNode = node.previous;
        Node nextNode = node.next;
        previousNode.next = nextNode;
        nextNode.previous = previousNode;
    }

    public void insertNode(Node node){
        Node nextNode = head.next;
        head.next = node;
        nextNode.previous = node;
        node.previous = head;
        node.next = nextNode;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.previous = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))  return -1;  
        Node node = map.get(key);
        int newValue = node.value;
        deleteNode(node);
        insertNode(node);
        return newValue;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertNode(node);
            return;
        }

        if(map.size() == capacity){
            Node node = tail.previous;
            map.remove(node.key);
            deleteNode(node);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertNode(newNode);
    }
}
