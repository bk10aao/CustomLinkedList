import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A custom singly-linked list implementation that maintains elements in insertion order.
 * This list does not permit null elements and throws a {@link NullPointerException} when
 * attempting to add null elements. It implements the {@link CustomLinkedListInterface}
 * for standard list operations and supports iteration via {@link Iterable}.
 * <p>
 * This implementation provides O(1) time complexity for operations at the head (e.g.,
 * {@code addFirst}, {@code removeFirst}) and O(n) for operations at the tail or indexed
 * positions (e.g., {@code removeLast}, {@code get(int)}). It is not thread-safe.
 * <p>
 *
 * @param <E> the type of elements maintained by this list
 *
 * @author Benjamin Kane
 *
 * @see <a href="https://www.linkedin.com/in/benjamin-kane-81149482/">LinkedIn Profile</a>
 * @see <a href="https://github.com/bk10aao">GitHub Account</a>
 * @see <a href="https://github.com/bk10aao/CustomLinkedList">Repository</a>
 */
public class CustomLinkedList<E> implements CustomLinkedListInterface<E>, Iterable<E> {

    private Node head;
    private Node tail;

    private int size = 0;

    /**
     * Constructs an empty singly-linked list with no elements.
     * Initializes the list with {@code size = 0}, {@code head = null}, and {@code tail = null}.
     */
    public CustomLinkedList() {
        head = tail = null;
    }

    /**
     * Constructs a singly-linked list containing the elements of the specified collection,
     * added in the order they are returned by the collection's iterator.
     *
     * @param items the collection of elements to add to the list
     *
     * @throws NullPointerException if the collection or any element is null
     */
    public CustomLinkedList(final Collection<E> items) {
        if(items == null)
            throw new NullPointerException();
        head = tail = null;
        this.addAll(items);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item the element to be added to the list (may be null)
     *
     * @return {@code true} (as specified by {@link java.util.List#add(Object)})
     */
    public boolean add(final E item) {
        Node newNode = new Node(item);
        if (head == null)
            head = tail = newNode;
        else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified index in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index the index at which to insert the element
     * @param item the element to be inserted (may be null)
     *
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index > size()})
     */
    public void add(final int index, final E data) {
        if(data == null)
            throw new NullPointerException();
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.nextNode = head;
            head = newNode;
            if (tail == null)
                tail = newNode;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                if (prev == null)
                    throw new IllegalStateException();
                prev = prev.nextNode;
            }
            newNode.nextNode = prev.nextNode;
            prev.nextNode = newNode;
            if (index == size)
                tail = newNode;
        }
        size++;
    }

    /**
     * Appends all elements in the specified collection to the end of this list,
     * in the order they are returned by the collection's iterator.
     *
     * @param collection the collection containing elements to be added
     *
     * @return {@code true} if this list changed as a result of the call, {@code false} if the collection is empty
     *
     * @throws NullPointerException if the collection or any element is null
     */
    public boolean addAll(final Collection<E> collection) {
        if(collection == null)
            throw new NullPointerException();
        if(collection.isEmpty())
            return false;
        for (E item : collection)
            add(item);
        return true;
    }

    /**
     * Inserts all elements in the specified collection into this list at the specified index,
     * in the order they are returned by the collection's iterator. Shifts the element currently
     * at that position (if any) and any subsequent elements to the right.
     *
     * @param index the index at which to insert the first element from the collection
     * @param collection the collection containing elements to be added
     *
     * @return {@code true} if this list changed as a result of the call, {@code false} if the collection is empty
     *
     * @throws NullPointerException if the collection or any element is null
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index > size()})
     * @throws IllegalStateException if the list structure is inconsistent during traversal
     */
    public boolean addAll(final int index, final Collection<E> collection) {
        if (collection == null)
            throw new NullPointerException();
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (collection.isEmpty())
            return false;
        int i = index;
        for (E item : collection)
            add(i++, item);
        return true;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param item the element to be added to the head of the list
     *
     * @throws NullPointerException if the element is null
     */
    public void addFirst(final E item) {
        if(item == null)
            throw new NullPointerException();
        Node newHead = new Node(item);
        newHead.nextNode = head;
        head = newHead;
        if(tail == null)
            tail = newHead;
        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     * This method is equivalent to {@link #add(Object)}.
     *
     * @param item the element to be added to the end of the list
     *
     * @throws NullPointerException if the element is null
     */
    public void addLast(final E item) {
        add(item);
    }

    /**
     * Removes all elements from this list, setting its size to zero and
     * resetting the head and tail to {@code null}.
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Creates and returns a shallow copy of this {@code CustomLinkedList}.
     * The new list contains the same elements as this list, in the same order,
     * but modifications to the elements themselves (if mutable) will affect both lists.
     * The internal structure (nodes) of the new list is independent of this list.
     *
     * @return a new {@code CustomLinkedList} instance containing all elements of this list
     *
     * @throws OutOfMemoryError if there is insufficient memory to create the clone
     */
    public CustomLinkedList<E> clone() {
        CustomLinkedList<E> clone = new CustomLinkedList<>();
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

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains at least
     * one element {@code e} such that {@code Objects.equals(item, e)}.
     *
     * @param item the element to search for
     *
     * @return {@code true} if the element is present in the list, {@code false} otherwise
     */
    public boolean contains(final E item) {
        return indexOf(item) != -1;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the element at the head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    public E element() {
        if(isEmpty())
            throw new NoSuchElementException();
        return head.data;
    }

    /**
     * Compares the specified object with this list for equality.
     * Returns {@code true} if and only if the specified object is also a
     * {@code CustomLinkedList}, both lists have the same size, and all
     * corresponding pairs of elements in the two lists are equal according to
     * {@link Objects#equals(Object, Object)}. In other words, two lists are
     * considered equal if they contain the same elements in the same order.
     * This implementation allows comparison with any {@code CustomLinkedList}
     * regardless of its generic type.
     *
     * @param o the object to be compared for equality with this list
     *
     * @return {@code true} if the specified object is equal to this list,
     *         {@code false} otherwise
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CustomLinkedList<?> that))
            return false;
        if (size != that.size)
            return false;
        Node thisNode = head;
        Node thatNode = (Node) that.head;
        while (thisNode != null && thatNode != null) {
            if (!Objects.equals(thisNode.data, thatNode.data))
                return false;
            thisNode = thisNode.nextNode;
            thatNode = thatNode.nextNode;
        }
        return thisNode == null && thatNode == null;
    }

    /**
     * Returns the element at the specified index in this list.
     *
     * @param index the index of the element to return
     *
     * @return the element at the specified index
     *
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     * @throws IllegalStateException if the list structure is inconsistent (e.g., a node is unexpectedly null)
     */
    public E get(final int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null)
                throw new IllegalStateException();
            current = current.nextNode;
        }
        if (current == null)
            throw new IllegalStateException();
        return current.data;
    }

    /**
     * Returns the hash code value for this list.
     * The hash code is computed based on the hash codes of all elements in the list,
     * using the standard list hash code formula:
     * {@code 1 + 31 * (element1.hashCode()) + 31^2 * (element2.hashCode()) + ...}.
     * This ensures that {@code list1.equals(list2)} implies
     * {@code list1.hashCode() == list2.hashCode()} for any two lists, as required
     * by the general contract of {@link Object#hashCode()}.
     *
     * @return the hash code value for this list
     */
    @Override
    public int hashCode() {
        int result = 1;
        for (Node x = head; x != null; x = x.nextNode)
            result = 31 * result + x.data.hashCode();
        return result;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if the element is not present. Uses {@link Objects#equals(Object, Object)}
     * for comparison.
     *
     * @param item the element to search for
     *
     * @return the index of the first occurrence of the element, or -1 if not found
     */
    public int indexOf(final E item) {
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode, index++)
            if (Objects.equals(x.data, item))
                return index;
        return -1;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if the list is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an {@code Iterator} over the elements in this list
     */
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if the element is not present. Uses {@link Objects#equals(Object, Object)}
     * for comparison.
     *
     * @param item the element to search for (may be null)
     *
     * @return the index of the last occurrence of the element, or -1 if not found
     */
    public int lastIndexOf(final E item) {
        int foundIndex = -1;
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode, index++)
            if (Objects.equals(x.data, item))
                foundIndex = index;
        return foundIndex;
    }

    /**
     * Appends the specified element to the end of this list.
     * This method is equivalent to {@link #add(Object)}.
     *
     * @param item the element to be added to the end of the list
     *
     * @return {@code true} (as specified by {@link java.util.Queue#offer(Object)})
     *
     * @throws NullPointerException if the element is null
     */
    public boolean offer(final E item) {
        add(item);
        return true;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     * This method is equivalent to {@link #addFirst(Object)}.
     *
     * @param item the element to be added to the head of the list
     *
     * @return {@code true} (as specified by {@link java.util.Deque#offerFirst(Object)})
     *
     * @throws NullPointerException if the element is null
     */
    public boolean offerFirst(final E item) {
        addFirst(item);
        return true;
    }

    /**
     * Appends the specified element to the end of this list.
     * This method is equivalent to {@link #addLast(Object)}.
     *
     * @param item the element to be added to the end of the list
     *
     * @return {@code true} (as specified by {@link java.util.Deque#offerLast(Object)})
     *
     * @throws NullPointerException if the element is null
     */
    public boolean offerLast(final E item) {
        addLast(item);
        return true;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the element at the head of the list, or {@code null} if the list is empty
     */
    public E peek() {
        return isEmpty() ? null : head.data;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     * This method is equivalent to {@link #peek()}.
     *
     * @return the element at the head of the list, or {@code null} if the list is empty
     */
    public E peekFirst() {
        return peek();
    }

    /**
     * Retrieves, but does not remove, the last element of this list.
     *
     * @return the element at the end of the list, or {@code null} if the list is empty
     */
    public E peekLast() {
        return isEmpty() ? null : tail.data;
    }

    /**
     * Removes and returns the head (first element) of this list.
     *
     * @return the element at the head of the list, or {@code null} if the list is empty
     */
    public E poll() {
        if(isEmpty())
            return null;
        E headValue = head.data;
        head = head.nextNode;
        if(head == null)
            tail = null;
        size--;
        return headValue;
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()}.
     *
     * @return the element at the head of the list, or {@code null} if the list is empty
     */
    public E pollFirst() {
        return poll();
    }

    /**
     * Removes and returns the last element of this list.
     *
     * @return the element at the end of the list, or {@code null} if the list is empty
     */
    public E pollLast() {
        if(isEmpty())
            return null;
        Node previous = head;
        while(previous.nextNode != tail) {
            if (previous.nextNode == null)
                throw new IllegalStateException();
            previous = previous.nextNode;
        }
        E data = tail.data;
        previous.nextNode = null;
        tail = previous;
        size--;
        return data;
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()} but throws an exception if the list is empty.
     *
     * @return the element at the head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    public E pop() {
        if(isEmpty())
            throw new NoSuchElementException();
        return poll();
    }

    /**
     * Inserts the specified element at the beginning of this list.
     * This method is equivalent to {@link #addFirst(Object)}.
     *
     * @param item the element to be added to the head of the list
     *
     * @throws NullPointerException if the element is null
     */
    public void push(final E item) {
        addFirst(item);
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()} but throws an exception if the list is empty.
     *
     * @return the element at the head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    public E remove() {
        if(isEmpty())
            throw new NoSuchElementException();
        return poll();
    }

    /**
     * Removes the element at the specified index in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     *
     * @return the element that was removed
     *
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     * @throws IllegalStateException if the list structure is inconsistent
     */
    public E remove(final int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        E removedValue;
        if (index == 0)
            return pollLast();
        Node previous = head;
        for (int i = 0; i < index - 1; i++)
            previous = previous.nextNode;
        removedValue = previous.nextNode.data;
        previous.nextNode = previous.nextNode.nextNode;
        if (index == size - 1)
            tail = previous;
        size--;
        return removedValue;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if present.
     * If the element is not found, the list is unchanged.
     *
     * @param item the element to be removed (may be null)
     *
     * @return the element that was removed, or {@code null} if the element was not found
     */
    public E remove(final E item) {
        if (isEmpty())
            return null;
        if (Objects.equals(head.data, item)) {
            E data = head.data;
            head = head.nextNode;
            if (head == null)
                tail = null;
            size--;
            return data;
        }
        Node node = head;
        while (node.nextNode != null) {
            if (Objects.equals(node.nextNode.data, item)) {
                E data = node.nextNode.data;
                node.nextNode = node.nextNode.nextNode;
                if (node.nextNode == null)
                    tail = node;
                size--;
                return data;
            }
            node = node.nextNode;
        }
        return null;
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()} but throws an exception if the list is empty.
     *
     * @return the element at the head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    public E removeFirst() {
        if(isEmpty())
            throw new NoSuchElementException();
        return poll();
    }

    /**
     * Removes the first occurrence of the specified element from this list, if present.
     * If the element is not found, the list is unchanged.
     *
     * @param item the element to be removed (may be null)
     *
     * @return {@code true} if the element was found and removed, {@code false} otherwise
     */
    public boolean removeFirstOccurrence(final E item) {
        if(isEmpty())
            return false;
        if (Objects.equals(head.data, item)) {
            head = head.nextNode;
            if (head == null)
                tail = null;
            size--;
            return true;
        }
        Node node = head;
        while (node.nextNode != null) {
            if (Objects.equals(node.nextNode.data, item)) {
                node.nextNode = node.nextNode.nextNode;
                if (node.nextNode == null)
                    tail = node;
                size--;
                return true;
            }
            node = node.nextNode;
        }
        return false;
    }

    /**
     * Removes and returns the last element of this list.
     *
     * @return the element that was removed
     *
     * @throws NoSuchElementException if the list is empty
     */
    public E removeLast() {
        if(isEmpty())
            throw new NoSuchElementException();
        return pollLast();
    }

    /**
     * Removes the last occurrence of the specified element from this list, if present.
     * If the element is not found, the list is unchanged.
     *
     * @param item the element to be removed
     *
     * @return {@code true} if the element was found and removed, {@code false} if the element is null,
     *         the list is empty, or the element is not found
     */
    public boolean removeLastOccurrence(final E item) {
        if (isEmpty())
            return false;
        Node lastMatchPrev = null;
        Node lastMatch = null;
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (Objects.equals(current.data, item)) {
                lastMatchPrev = previous;
                lastMatch = current;
            }
            previous = current;
            current = current.nextNode;
        }
        if (lastMatch == null)
            return false;
        if (lastMatch == head) {
            head = head.nextNode;
            if (head == null)
                tail = null;
        } else {
            lastMatchPrev.nextNode = lastMatch.nextNode;
            if (lastMatch == tail)
                tail = lastMatchPrev;
        }
        size--;
        return true;
    }

    /**
     * Replaces the element at the specified index in this list with the specified element.
     *
     * @param index the index of the element to replace
     * @param item the new element to set at the specified index
     *
     * @return the previous element at the specified index
     *
     * @throws NullPointerException if the element is null
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     * @throws IllegalStateException if the list structure is inconsistent (e.g., a node is unexpectedly null)
     */
    public E set(final int index, final E item) {
        if (item == null)
            throw new NullPointerException();
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(index == 0) {
            E previousValue = head.data;
            head.data = item;
            return previousValue;
        } else
            return updateIndex(index, item);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns an array containing all elements in this list in proper sequence
     * (from head to tail).
     *
     * @return an array containing the elements of this list
     *
     * @throws ArrayStoreException if the runtime type of the array elements is not
     *         compatible with the type of the elements in this list
     */
    public E[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode)
            array[index++] = x.data;
        return (E[]) array;
    }

    /**
     * Returns an array containing all elements in this list in proper sequence
     * (from head to tail).
     *
     * @return an array containing the elements of this list
     */
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode)
            a[index++] = (T) x.data;
        if (a.length > size)
            a[size] = null;
        return a;
    }

    /**
     * Returns a string representation of this list.
     * The string representation consists of the elements of the list in order,
     * enclosed in curly braces ({@code "{ }"}). Adjacent elements are separated
     * by a comma and a space ({@code ", "}). If the list is empty, returns
     * {@code "{ }"}.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString(){
        if(isEmpty())
            return "{ }";
        StringBuilder stringBuilder = new StringBuilder("{ ");
        for (Node x = head; x != null; x = x.nextNode)
            stringBuilder.append(x.data).append(", ");
        return stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), " }").toString();
    }

    /**
     * Replaces the element at the specified index with the specified element and
     * returns the previous element.
     *
     * @param index the index of the element to replace
     * @param item the new element to set
     *
     * @return the previous element at the specified index
     *
     * @throws NullPointerException if the element is null
     * @throws IllegalStateException if the list structure is inconsistent (e.g., a node is unexpectedly null)
     */
    private E updateIndex(final int index, final E item) {
        if(item == null)
            throw new NullPointerException();
        Node current = head;
        for(int i = 0; i < index; i++) {
            if(current == null)
                throw new IllegalStateException();
            current = current.nextNode;
        }
        if(current == null)
            throw new IllegalStateException();
        E previousValue = current.data;
        current.data = item;
        return previousValue;
    }

    private class Node {

        private E data;
        private Node nextNode;

        public Node(E data) {
            this.data = data;
        }
    }

    /**
     * An iterator over the elements in this list in proper sequence.
     */
    private class ListIterator implements Iterator<E> {
        private Node current = head;
        private Node previous = null;
        private Node prevPrevious = null;

        /**
         * Returns {@code true} if the iteration has more elements.
         *
         * @return {@code true} if there are more elements to iterate
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the list
         * @throws NoSuchElementException if there are no more elements
         */
        @Override
        public E next() {
            if (current == null)
                throw new NoSuchElementException();
            prevPrevious = previous;
            previous = current;
            E data = current.data;
            current = current.nextNode;
            return data;
        }

        /**
         * Removes the last element returned by {@link #next()} from the list.
         * This method can only be called once per call to {@link #next()}.
         *
         * @throws IllegalStateException if {@link #next()} has not been called, or
         *         {@link #remove()} has already been called after the last call to {@link #next()}
         */
        @Override
        public void remove() {
            if (previous == null)
                throw new IllegalStateException("next() must be called before remove()");
            if (prevPrevious == null) {
                head = current;
                if (head == null)
                    tail = null;
            } else {
                prevPrevious.nextNode = current;
                if (current == null)
                    tail = prevPrevious;
            }
            size--;
            previous = null;
        }
    }
}
