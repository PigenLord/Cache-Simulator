import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.io.*;  

public class LRUCache<T> {

    private final int capacity;
    //size is not final since we need to keep updating it
    private int size;
    private final Map<String, Node> hashmap;
    private final DoublyLinkedList internalQueue; 


    
    LRUCache(final int capacity){
        this.capacity = capacity;  //initializing capacity
        this.hashmap = new HashMap<>();
        this.internalQueue = new DoublyLinkedList();
        this.size = 0;
    }

    //function1 where it gets the key value
    public T get(final String key){
        //fetch the data 
        Node node = hashmap.get(key);
        if (node == null){
            return null; 
        }
        internalQueue.moveNodeToFront(node);
        return hashmap.get(key).value;
    }

    //function 2 where users pass string and value
    public void put(final String key, final T value){
        Node currentNode = hashmap.get(key);
        if(currentNode != null){
            currentNode.value = value; 
            internalQueue.moveNodeToFront(currentNode);
        }
        //we remove 
        if(size == capacity ){
            String rearNodeKey = internalQueue.getRearKey();
            internalQueue.removeNodeFromRear();
            hashmap.remove(rearNodeKey);
            //we do minus minus since we are removing from the queue
            size--;
        }
        
        Node node = new Node(key, value);
        internalQueue.addNodeToFront(node);
        hashmap.put(key, node);
        size++;


        
    }

    //helps bundle up the two functions to create structure. 
    private class Node {
        String key;
        T value; 
        Node next, prev; //pointers
        public Node (final String key, final T value) {
                this.key = key;
                this.value = value; 
                this.next = null;
                this.prev = null;
        }
    }
    //internal class
    private class DoublyLinkedList {
        private Node front, rear; 
        public DoublyLinkedList() { 
                front = rear = null; 
        }
        //adds node to fron of the queue
        private void addNodeToFront(final Node node){
            // checks if queue is empty or not
            if(rear == null){
                front = rear = node;
                return; 
            }
            /*if the queue does have data present  
            we get the current node by pointing the next of the currentNode to the front
            next we point the previous of the front to the current node
            last we get front and make it the current node
            */
                node.next = front;
                front.prev = node;
                front = node; 
        }

        //it will move the particular node we want to the front of the queue 
        public void moveNodeToFront(final Node node){
            if(front == node){
                return; 
            }
            //we check if the current node is the rear node
            if(node == rear){
                rear = rear.prev;
                rear.next = null; 
            } else {
                //first the next to the previous node will change and will point next to the current node 
                node.prev.next = node.next;
                //next the previous to the next node is going to point to the previous to the current node
                node.next.prev = node.prev;
            }
                
                //Here we want to add to the front of the queue
                //first the prev of the node will become empty
                node.prev = null;
                //next of the node will be pointing to the current front of the queue
                node.prev = front; 
                //previous will point to the current node 
                front.prev = node;
                //front will point to the current node 
                front = node;  
        }

        private void removeNodeFromRear() {
            //check if queue is empty 
            if(rear == null){
                return;
            }
            System.out.println("Deleting Key: " + rear.key);
            //check if only one node is in the queue
            if(front == rear){ 
                front = rear = null; 
                //otherwise there are multiple nodes present in the queue
            } else {
                //move the rear making rear point to previous 
                rear =  rear.prev; 
                //rear is now empty since its last node in the queue 
                rear.next = null; 
            }

        }
        //getting rear key of the node 
        private String getRearKey(){
            return rear.key; 
        }
    }
}
