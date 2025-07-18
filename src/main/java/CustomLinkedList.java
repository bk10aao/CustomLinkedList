import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomLinkedList<T> implements CustomLinkedListInterface<T> {

    private Node head;
    private Node tail;

    private int size = 0;

    public CustomLinkedList() {
        head = tail = null;
    }

    public CustomLinkedList(final Collection<T> items) {
        if(items == null)
            throw new NullPointerException("Input collection cannot be null");
        head = tail = null;
        this.addAll(items);
    }

    public boolean add(final T data) {
        if(data == null)
            throw new NullPointerException();
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public void add(final int index, final T data) {
        if(data == null)
            throw new NullPointerException();
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.nextNode = head;
            head = newNode;
            if (tail == null) tail = newNode;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.nextNode;
            newNode.nextNode = prev.nextNode;
            prev.nextNode = newNode;
            if (index == size)
                tail = newNode;
        }
        size++;
    }

    public boolean addAll(final Collection<T> collection) {
        if(collection == null)
            throw new NullPointerException();
        int startSize = size;
        for (T item : collection)
            add(item);
        return startSize != size;
    }

    public boolean addAll(final int index, final Collection<T> collection) {
        if (collection == null)
            throw new NullPointerException();
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (collection.isEmpty())
            return true;
        Node first = null;
        Node last = null;
        for (T t : collection) {
            if (t == null)
                throw new NullPointerException("Collection elements cannot be null");
            Node newNode = new Node(t);
            if (first == null)
                first = newNode;
            else
                last.nextNode = newNode;
            last = newNode;
        }
        if (index == 0) {
            last.nextNode = head;
            head = first;
            if (size == 0)
                tail = last;
        } else {
            Node previous = head;
            if(previous == null)
                throw new IllegalStateException();
            for (int i = 0; i < index - 1; i++) {
                if (previous.nextNode == null)
                    throw new IllegalStateException();
                previous = previous.nextNode;
            }
            last.nextNode = previous.nextNode;
            previous.nextNode = first;
            if (index == size)
                tail = last;
        }
        size += collection.size();
        return true;
    }

    public void addFirst(final T item) {
        if(item == null)
            throw new NullPointerException();
        Node newHead = new Node(item);
        newHead.nextNode = head;
        head = newHead;
        if(tail == null)
            tail = newHead;
        size++;
    }

    public void addLast(final T item) {
        add(item);
    }

    public CustomLinkedList<T> clone() {
        CustomLinkedList<T> clone = new CustomLinkedList<>();
        if (head == null)
            return clone;
        Node cloneHead = new Node(head.data);
        clone.head = cloneHead;
        Node cloneCurrent = cloneHead;
        for (Node x = head.nextNode; x != null; x = x.nextNode) {
            cloneCurrent.nextNode = new Node(x.data);
            cloneCurrent = cloneCurrent.nextNode;
        }
        clone.tail = cloneCurrent;
        clone.size = size;
        return clone;
    }

    public boolean contains(final T item) {
        if(item == null)
            throw new NullPointerException();
        return indexOf(item) != -1;
    }

    public T element() {
        if(size == 0)
            throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomLinkedList)) return false;
        CustomLinkedList<?> that = (CustomLinkedList<?>) o;
        if (size != that.size) return false;
        Node thisNode = head;
        CustomLinkedList<?>.Node thatNode = that.head;
        while (thisNode != null && thatNode != null) {
            if (!Objects.equals(thisNode.data, thatNode.data)) return false;
            thisNode = thisNode.nextNode;
            thatNode = thatNode.nextNode;
        }
        return thisNode == null && thatNode == null;
    }

    public T get(final int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) throw new IllegalStateException("List structure corrupted");
            current = current.nextNode;
        }
        if (current == null) throw new IllegalStateException("List structure corrupted");
        return current.data;
    }

    public int hashCode() {
        int result = 1;
        for (Node x = head; x != null; x = x.nextNode)
            result = 31 * result + x.data.hashCode();
        return result;
    }

    public int indexOf(final T item) {
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode, index++)
            if (Objects.equals(x.data, item))
                return index;
        return -1;
    }

    public int lastIndexOf(final T item) {
        int foundIndex = -1;
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode, index++)
            if (Objects.equals(x.data, item))
                foundIndex = index;
        return foundIndex;
    }

    public boolean offer(final T item) {
        return add(item);
    }

    public boolean offerFirst(final T item) {
        addFirst(item);
        return Objects.equals(head.data, item);
    }

    public boolean offerLast(final T item) {
        addLast(item);
        return Objects.equals(tail.data, item);
    }

    public T peek() {
        return size == 0 ? null : head.data;
    }

    public T peekFirst() {
        return size == 0 ? null : peek();
    }

    public T peekLast() {
        return size == 0 ? null : tail.data;
    }

    public T poll() {
        if(size == 0)
            return null;
        T headValue = head.data;
        head = head.nextNode;
        if(head == null)
            tail = null;
        size--;
        return headValue;
    }

    public T pollFirst() {
        return poll();
    }

    public T pollLast() {
        if(size == 0)
            return null;
        if(size == 1) {
            T data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        Node previous = head;
        while(previous.nextNode != tail)
            previous = previous.nextNode;
        T data = tail.data;
        previous.nextNode = null;
        tail = previous;
        size--;
        return data;
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
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if(index == 0) {
            if(head == null)
                throw new IllegalStateException();
            head = head.nextNode;
            if(head == null)
                tail = null;
            size--;
            return true;
        }
        Node previous = head;
        if(previous == null)
            throw new IllegalStateException();

        for(int i = 0; i < index -1; i++) {
            if(previous.nextNode == null)
                throw new IllegalStateException();
            previous = previous.nextNode;
        }
        if(previous.nextNode == null)
            throw new IllegalStateException();
        previous.nextNode = previous.nextNode.nextNode;
        if (index == size - 1)
            tail = previous;
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
        Object[] array = new Object[size];
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode)
            array[index++] = x.data;
        return (T[]) array;
    }

    public String toString(){
        if(size == 0)
            return "{ }";
        StringBuilder stringBuilder = new StringBuilder("{ ");
        for (Node x = head; x != null; x = x.nextNode)
            stringBuilder.append(x.data).append(", ");
        return stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), " }").toString();
    }

    private T updateIndex(final int index, final T item) {
        Node current = head;
        for(int i = 0; i < index; i++) {
            if(current == null)
                throw new IllegalStateException();
            current = current.nextNode;
        }
        if(current == null)
            throw new IllegalStateException();
        T previousValue = current.data;
        current.data = item;
        return previousValue;
    }

    private class Node {

        private T data;
        private Node nextNode;

        public Node(T data) {
            this.data = data;
        }
    }
}
