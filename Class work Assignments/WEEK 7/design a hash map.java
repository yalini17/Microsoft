class MyHashMap {

    private Bucket[] bucketArray; 
    private final float capacaity = 0.75f;
    private int size = 0; 
    private int bucketLength = 8;
    
    public MyHashMap() {
        this.bucketArray = new Bucket[bucketLength];
        for (int i = 0; i < bucketLength; i++) {
            bucketArray[i] = new Bucket();
        }
    }
    
    private int getBucketIndex(int key) {
        return key % this.bucketLength;
    } 
    
    private void rehash() {
        int oldBucketLength = this.bucketLength;
        this.bucketLength = this.bucketLength * 2;
        Bucket[] newBucketArray = new Bucket[this.bucketLength];
        for (int i = 0; i < this.bucketLength; i++) {
            newBucketArray[i] = new Bucket();
        }
        
        for (int i = 0; i < oldBucketLength; i++) {
            Bucket b = this.bucketArray[i];
            LinkedList<Node> linkedList = b.getContainer();
            for (Node n : linkedList) {
                int newIndex = this.getBucketIndex(n.getKey());
                newBucketArray[newIndex].insert(n);
            }
        }
        this.bucketArray = newBucketArray;
    }
    
    public void put(int key, int value) {
        
        if (this.size * 1.0 / bucketLength > this.capacaity) {
            rehash();
        }
        
        int index = this.getBucketIndex(key);
        Bucket b = this.bucketArray[index];
        boolean res = b.insert(new Node(key, value));
        if (res) {
            this.size++;
        }
    }
    
    public int get(int key) {
        int index = this.getBucketIndex(key);
        Bucket b = this.bucketArray[index];
        return b.get(key);
    }
    
    public void remove(int key) {
        int index = this.getBucketIndex(key);
        Bucket b = this.bucketArray[index];
        boolean res = b.remove(key);
        if (res) {
            this.size--;
        }
    }
}

class Bucket {
    
    private LinkedList<Node> container;
    
    Bucket() {
        this.container = new LinkedList<Node>();
    }
    
    public LinkedList<Node> getContainer() {
        return this.container;
    }
    
    public boolean insert(Node node) {
        
        boolean isUpdated = false;
        for (Node n : this.container) {
            if (n.getKey() == node.getKey()) {
                n.setValue(node.getValue());
                isUpdated = true;
                break;
            }
        }
        
        if (!isUpdated) {
            this.container.add(node);
            return true;
        }
        
        return false;
    } 
    
    public boolean remove(int key) {
        
        Node removedNode = null; 
        for (Node n : this.container) {
            if (n.getKey() == key) {
                removedNode = n;
                break;
            }
        }
        
        if (removedNode != null) {
            this.container.remove(removedNode);
            return true;
        }
        return false;
    }
    
    public int get(int key) {
        Iterator it = this.container.iterator();
        while (it.hasNext()) {
            Node n = (Node)it.next();
            if (key == n.getKey()) {
                return n.getValue();
            }
        }
        return -1;
    }
    
    
}

class Node {
    
    private int key;
    private int value;
    
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
    
    public int getKey() {
        return this.key;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
}
