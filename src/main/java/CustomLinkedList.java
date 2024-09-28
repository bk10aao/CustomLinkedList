import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomLinkedList<T> implements CustomLinkedListInterface<T> {

    private Node head;

    private int size = 0;

    public CustomLinkedList() {

    }

    public CustomLinkedList(final Collection<T> items) {
        if(items == null)
            throw new NullPointerException("Null collection not supported");
        this.addAll(items);
    }

    public boolean add(final T data){
        if(this.head == null)
            head = new Node(data);
        else {
            Node currentNode = head;
            while(currentNode.nextNode != null)
                currentNode = currentNode.nextNode;
            currentNode.nextNode = new Node(data);
        }
        size++;
        return true;
    }

    public void add(final int index, final T data){
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node nodeToBeInserted = new Node(data);
        Node node = head;
        for(int i = 0; i< index -1; i++)
            node = node.nextNode;
        nodeToBeInserted.nextNode  = node.nextNode;
        node.nextNode = nodeToBeInserted;
        size++;
    }

    public boolean addAll(final Collection<T> collection) {
        if(collection == null)
            throw new NullPointerException();
        int startSize = size;
        collection.forEach(this::add);
        return startSize != size;
    }

    public boolean addAll(final int index, final Collection<T> collection) {
        if(collection == null)
            throw new NullPointerException();
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        int startSize = size;
        int insertIndex = 0;
        Node currentNode = head;
        while(currentNode.nextNode != null) {
            if(insertIndex == index) {
                for (T item : collection)
                    add(insertIndex++, item);
                break;
            }
            insertIndex++;
            currentNode = currentNode.nextNode;
        }
        return startSize != size;
    }

    public void addFirst(final T item) {
        Node newHead = new Node(item);
        newHead.nextNode = head;
        head = newHead;
        size++;
    }

    public void addLast(final T item) {
        add(item);
    }

    public CustomLinkedList<T> clone() {
        CustomLinkedList<T> clone = new CustomLinkedList<>();
        for (Node x = head; x != null; x = x.nextNode)
            clone.add(x.data);
        return clone;
    }

    public boolean contains(final T item) {
        if(item == null)
            throw new NullPointerException();
        return indexOf(item) > -1;
    }

    public T element() {
        if(size == 0)
            throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass())
            return false;
        CustomLinkedList<?> that = (CustomLinkedList<?>) o;
        T[] firstArray = this.toArray();
        T[] secondArray = (T[]) ((CustomLinkedList<?>) o).toArray();
        for(int i = 0; i < firstArray.length; i++)
            if (!firstArray[i].equals(secondArray[i]))
                return false;
        return size == that.size;
    }

    public T get(final int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if(index == 0)
            return head.data;
        Node current = head.nextNode;
        if(index == size - 1)
            while (current.nextNode != null)
                current = current.nextNode;
        else
            for (int i = 0; i < index - 1; i++)
                current = current.nextNode;
        return current.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }

    public int indexOf(final T item) {
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode, index++)
            if (x.data == item)
                return index;
        return -1;
    }

    public int lastIndexOf(final T item) {
        int foundIndex = -1;
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode, index++)
            if (x.data == item)
                foundIndex = index;
        return foundIndex;
    }

    public boolean offer(final T item) {
        return add(item);
    }

    public boolean offerFirst(final T item) {
        addFirst(item);
        return head.data == item;
    }

    public boolean offerLast(final T item) {
        addLast(item);
        return get(size - 1).equals(item);
    }

    public T peek() {
        return head.data;
    }

    public T peekFirst() {
        return size == 0 ? null : peek();
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
        if(size == 0)
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

    public void push(final T item) {
        addFirst(item);
    }

    public T pop() {
        if(size == 0)
            throw new NoSuchElementException();
        return poll();
    }

    public T remove() {
        if(size == 0)
            throw new NoSuchElementException();
        return pollFirst();
    }

    public boolean remove(final int index) {
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException();
        Node node = head;
        for(int i = 0; i < index -1; i++)
            node = node.nextNode;
        node.nextNode = node.nextNode.nextNode;
        size--;
        return true;
    }

    public T remove(final T item) {
        if(contains(item)) {
            remove(indexOf(item));
            return item;
        }
        return null;
    }

    public T removeFirst() {
        if(size == 0)
            throw new NoSuchElementException();
        return poll();
    }

    public boolean removeFirstOccurrence(final T item) {
        if(item == null || size == 0)
            return false;
        return contains(item) ? remove(indexOf(item)) : false;
    }

    public T removeLast() {
        if(size == 0)
            throw new NoSuchElementException();
        return pollLast();
    }

    public boolean removeLastOccurrence(final T item) {
        if(item == null || size == 0)
            return false;
        return contains(item) ? remove(lastIndexOf(item)) : false;
    }

    public T set(final int index, final T item) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        T previousValue;
        if(index == 0) {
            previousValue = head.data;
            head.data = item;
            return previousValue;
        } else {
            return updateIndex(index, item);
        }
    }

    public int size() {
        return this.size;
    }

    public T[] toArray() {
        if(head != null) {
            Object[] array = new Object[size];
            int insertIndex = 0;
            Node currentNode = head;
            while(currentNode.nextNode != null){
                array[insertIndex++] = currentNode.data;
                currentNode = currentNode.nextNode;
            }
            array[insertIndex] = currentNode.data;
            return (T[]) array;
        }
        return null;
    }

    public String toString(){
        if(size == 0)
            return "{ }";
        StringBuilder s = new StringBuilder("{ ");
        s.append(head.data).append(", ");

        if(head != null) {
            Node currentNode = head;
            while(currentNode.nextNode != null){
                currentNode = currentNode.nextNode;
                s.append(currentNode.data).append(", ");

            }
        }
        return s.replace(s.lastIndexOf(", "), s.length(), " }").toString();
    }

    private T updateIndex(int index, final T item) {
        T previousValue;
        int currentIndex = 0;
        Node currentHead = head;
        while(currentHead.nextNode != null) {
            if(currentIndex == index) {
                previousValue = currentHead.data;
                currentHead.data = item;
                return previousValue;
            }
            currentHead = currentHead.nextNode;
            currentIndex++;
        }
        return null;
    }

    private class Node {

        private T data;
        private Node nextNode;

        public Node(T data) {
            this.data = data;
        }
    }
}
