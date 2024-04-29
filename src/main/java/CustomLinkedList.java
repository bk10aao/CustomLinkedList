import java.util.NoSuchElementException;

public class CustomLinkedList<T> {

    private Node head;

    private int size = 0;

    public CustomLinkedList() {
    }

    public boolean add(T data){
        if(this.head == null)
            head = new Node(data);
        else {
            Node currentNode = head;
            while(currentNode.getNextNode() != null)
                currentNode = currentNode.getNextNode();
            currentNode.setNextNode(new Node(data));
        }
        size++;
        return true;
    }

    public void add(int index, T data){
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node nodeToBeInserted = new Node(data);
        Node node = head;
        for(int i = 0; i< index -1; i++)
            node = node.getNextNode();
        nodeToBeInserted.setNextNode(node.getNextNode());
        node.setNextNode(nodeToBeInserted);
        size++;
    }

    public void addFirst(T item) {
        Node newHead = new Node(item);
        newHead.nextNode = head;
        head = newHead;
        size++;
    }

    public void addLast(T item) {
        add(item);
    }

    public boolean contains(T item) {
        if(item == null)
            throw new NullPointerException();
        if(head.data.equals(item))
            return true;
        Node current = head.nextNode;
        while (current.getNextNode() != null) {
            if(current.data.equals(item))
                return true;
            current = current.getNextNode();
        }
        return false;
    }

    public T element() {
        if(size == 0)
            throw new NoSuchElementException();
        return head.data;
    }

    public T get(int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if(index == 0)
            return head.data;
        Node current = head.nextNode;
        if(index == size - 1)
            while (current.getNextNode() != null)
                current = current.getNextNode();
        else
            for (int i = 0; i < index - 1; i++)
                current = current.nextNode;

        return current.data;
    }

    public boolean offer(T item) {
        return add(item);
    }

    public boolean offerFirst(T item) {
        addFirst(item);
        return head.data == item;
    }

    public boolean offerLast(T item) {
        addLast(item);
        return get(size - 1).equals(item);
    }

    public T peek() {
        return head.data;
    }

    public T peekFirst() {
        if(size == 0)
            return null;
        return peek();
    }

    public T peekLast() {
        if(size == 0)
            return null;
        else if(size == 1)
            return head.data;

        Node current = head.nextNode;
        while(current.nextNode != null)
            current = current.nextNode;
        return current.data;
    }

    public T poll() {
        if(size== 0)
            return null;
        T headValue = head.data;
        head = head.nextNode;
        size--;
        return headValue;
    }

    public T pollFirst() {
        return poll();
    }

    public T pollLast() {
        if(size == 0)
            return null;
        T last = get(size - 1);
        remove(size - 1);
        return last;
    }

    public void push(T item) {
        addFirst(item);
    }

    public T pop() {
        if(size == 0)
            throw new NoSuchElementException();
        return poll();
    }

    public boolean remove(int index) {
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException();
        Node node = head;
        for(int i = 0; i< index -1; i++)
            node = node.getNextNode();
        node.setNextNode(node.getNextNode().getNextNode());
        size--;
        return true;
    }


    public int size() {
        return this.size;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        if(head != null) {
            Node currentNode = head;
            while(currentNode.getNextNode() != null){
                s.append(currentNode.data).append("\n");
                currentNode = currentNode.getNextNode();
            }
            s.append(currentNode.data);
        }
        return s.toString();
    }

    public class Node {

        private final T data;
        private Node nextNode;

        public Node(T data){
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
