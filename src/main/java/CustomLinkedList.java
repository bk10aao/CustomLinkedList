import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/**
 * A custom singly-linked list implementation that maintains elements in insertion order.
 * This list does not permit null elements and throws a {@link NullPointerException} when
 * attempting to add null elements. It implements the {@link List} interface.
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
public class CustomLinkedList<E> implements List<E>, Iterable<E>, Serializable, Cloneable {

    private transient Node<E> head;
    private transient Node<E> tail;

    private transient int size = 0;

    @Serial
    private static final long serialVersionUID = 1L;

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
            insert(index, newNode);
        }
        size++;
    }

    /**
     * Appends all elements in the specified e to the end of this list,
     * in the order they are returned by the e's iterator.
     *
     * @param e the e containing elements to be added
     *
     * @return {@code true} if this list changed as a result of the call, {@code false} if the e is empty
     *
     * @throws NullPointerException if the e or any element is null
     */
    public boolean addAll(final Collection<? extends E> e) {
        if(e == null)
            throw new NullPointerException();
        if(e.isEmpty())
            return false;
        for (E item : e)
            add(item);
        return true;
    }

    /**
     * Inserts all elements in the specified collection into this list at the specified index,
     * in the order they are returned by the collection's iterator. Shifts the element currently
     * at that position (if any) and any subsequent elements to the right.
     *
     * @param index the index at which to insert the first element from the collection
     * @param c the collection containing elements to be added
     *
     * @return {@code true} if this list changed as a result of the call, {@code false} if the collection is empty
     *
     * @throws NullPointerException if the collection or any element is null
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index > size()})
     * @throws IllegalStateException if the list structure is inconsistent during traversal
     */
    public boolean addAll(final int index, final Collection<? extends E> c) {
        if (c == null)
            throw new NullPointerException();
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (c.isEmpty())
            return false;
        int i = index;
        for (E item : c)
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
     * @param o the element to search for
     *
     * @return {@code true} if the element is present in the list, {@code false} otherwise
     */
    public boolean contains(final Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Returns {@code true} if this list contains all elements in Collection.
     *
     * @param c collection to check for all values in CustomList
     *
     * @return {@code true} if this list contains all elements in collection
     *
     * @throws NullPointerException if the specified collection or any of its elements is null
     */
    public boolean containsAll(final Collection<?> c) {
        Set<?> values = (c instanceof Set<?> s) ? s : new HashSet<>(c);
        for(Object o : values)
            if (!contains(o))
                return false;
        return true;
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
        Node<E> current = head;
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
     * Gets but does not remove the first element of this list.
     *
     * @return {@code E} element at the start of the list.
     *
     * @throws NoSuchElementException if this list is empty
     */
    public E getFirst() {
        if(size == 0)
            throw new NoSuchElementException();
        return head.data;
    }

    /**
     * Gets but does not remove the last element of this list.
     *
     * @return {@code E} element at the end of the list.
     *
     * @throws NoSuchElementException if this list is empty
     */
    public E getLast() {
        return get(size - 1);
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
     * @param o the element to search for
     *
     * @return the index of the first occurrence of the element, or -1 if not found
     */
    public int indexOf(final Object o) {
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode, index++)
            if (Objects.equals(x.data, o))
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
    public ListIterator<E> iterator() {
        return new CustomListIterator(0);
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if the element is not present. Uses {@link Objects#equals(Object, Object)}
     * for comparison.
     *
     * @param o the element to search for (may be null)
     *
     * @return the index of the last occurrence of the element, or -1 if not found
     */
    public int lastIndexOf(final Object o) {
        int foundIndex = -1;
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode, index++)
            if (Objects.equals(x.data, o))
                foundIndex = index;
        return foundIndex;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return {@code ListIterator} over the elements in this list in proper sequence
     */
    public ListIterator<E> listIterator() {
        return new CustomListIterator(0);
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @param index the index of the start of List Iterator
     *
     * @return {@code ListIterator} over the elements in this list in proper sequence
     *
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     */
    public ListIterator<E> listIterator(final int index) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        return new CustomListIterator(index);
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
        Node<E> previous = head;
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
     *
     * @param o the element to be removed (may be null)
     *
     * @return {@code true} if this list contained the specified element
     */
    public boolean remove(final Object o) {
        if(head.data.equals(o)) {
            head = head.nextNode;
            if(head == null)
                tail = null;
            size--;
            return true;
        }
        Node<E> node = head;
        while(node.nextNode != null) {
            if (Objects.equals(head.nextNode.data, o)) {
                return unlink(node);
            }
            node = node.nextNode;
        }
        return false;
    }

    /**
     * Removes from this list all elements that are contained in the specified collection.
     *
     * @param c collection containing elements to be removed from this list
     *
     * @return {@code true} if this list changed
     * @see Collection#contains(Object)
     */
    public boolean removeAll(final Collection<?> c) {
        if (c.isEmpty())
            return false;
        final Set<?> remove = (c instanceof Set<?>) ? (Set<?>) c : new HashSet<>(c);
        boolean modified = false;
        for (Node<E> node = head, next; node != null; node = next) {
            next = node.nextNode;
            if (remove.contains(node.data)) {
                remove(node);
                modified = true;
            }
        }
        return modified;
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
     * @param item the Object to be removed (may be null)
     *
     * @return {@code true} if the element was found and removed, {@code false} otherwise
     */
    public boolean removeFirstOccurrence(final Object item) {
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
                return unlink(node);
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
    public boolean removeLastOccurrence(final Object item) {
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
     * Retains only the elements in this list that are contained in the specified collection.
     * In other words, removes from this list all of its elements that are not contained in {@code c}.
     *
     * @param c collection containing elements to be retained in this list
     *
     * @return {@code true} if this list changed as a result of the call
     *
     * @throws NullPointerException if {@code c} is null or contains null
     */
    public boolean retainAll(final Collection<?> c) {
        if (c.isEmpty()) {
            boolean modified = !isEmpty();
            clear();
            return modified;
        }
        Set<?> retain = (c instanceof Set<?> s) ? s : new HashSet<>(c);
        boolean modified = false;
        for (Node<E> node = head, next; node != null; node = next) {
            next = node.nextNode;
            if (!retain.contains(node.data)) {
                remove(node);
                modified = true;
            }
        }
        return false;
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
     * Returns a new list containing the portion of this list between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive. If
     * {@code fromIndex} and {@code toIndex} are equal, the returned list is empty.
     * Note: The returned list is a copy, not a view backed by the original.
     *
     * @param fromIndex index of the first element (inclusive)
     * @param toIndex index after the last element (exclusive)
     *
     * @return a new {@code CustomDoublyLinkedList} containing the specified range of elements
     *
     * @throws IndexOutOfBoundsException if {@code fromIndex < 0}, {@code toIndex > size()} or {@code fromIndex > toIndex}
     */
    public List<E> subList(final int fromIndex, final int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        if(fromIndex == toIndex)
            return new CustomLinkedList<>();
        CustomLinkedList<E> result = new CustomLinkedList<>();
        for (int i = fromIndex; i < toIndex; i++)
            result.add(get(i));
        return result;
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
    public String toString(){
        if(isEmpty())
            return "[]";
        StringBuilder stringBuilder = new StringBuilder("[");
        boolean first = true;
        for (Node x = head; x != null; x = x.nextNode) {
            if (!first)
                stringBuilder.append(", ");
            stringBuilder.append(x.data);
            first = false;
        }
        return stringBuilder.append("]").toString();
    }

    /**
     * Insert Node at the specified index
     *
     * @param index the index of the element to replace
     * @param newNode the new element to set
     *
     * @throws IllegalStateException if the list structure is inconsistent (e.g., a node is unexpectedly null)
     */
    private void insert(int index, final Node newNode) {
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

    /**
     * Unlinks the node from neighbours and decreases the size by 1.
     *
     * @param node to be unlinked
     * @return true
     */
    private boolean unlink(final Node<E> node) {
        node.nextNode = node.nextNode.nextNode;
        if (node.nextNode == null)
            tail = node;
        size--;
        return true;
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
        Node<E> current = head;
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

    /**
     * A node in the singly-linked list, containing an element.
     */
    private static class Node<E> {

        private E data;
        private Node<E> nextNode;

        public Node(E data) {
            this.data = data;
        }
    }

    /**
     * An iterator over the elements in this list in proper sequence.
     */
    private class CustomListIterator implements ListIterator<E> {
        private Node<E> next;
        private Node<E> lastReturned;
        private Node<E> prev;
        private int nextIndex;

        CustomListIterator(int index) {
            nextIndex = index;

            if (size == 0) {
                next = null;
                prev = null;
                return;
            }

            if (index == 0) {
                next = head;
                prev = null;
                return;
            }

            if (index == size) {
                next = null;
                prev = head;
                for (int i = 1; i < size; i++)
                    prev = prev.nextNode;
                return;
            }

            Node<E> current = head;
            for (int i = 0; i < index; i++)
                current = current.nextNode;
            next = current;
            prev = (index == 0) ? null : getNodeAt(index - 1);
        }

        public boolean hasNext() {
            return next != null;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = next;
            prev = lastReturned;
            next = next.nextNode;
            nextIndex++;
            return lastReturned.data;
        }

        public boolean hasPrevious() {
            return prev != null;
        }

        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            lastReturned = prev;
            next = lastReturned;
            prev = (nextIndex == 1) ? null : getNodeAt(nextIndex - 2);
            nextIndex--;
            return lastReturned.data;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();

            if (lastReturned == head) {
                head = head.nextNode;
                if (head == null)
                    tail = null;
            } else {
                Node<E> before = (prev == lastReturned) ? getNodeAt(nextIndex - 2) : prev;
                if (before == null)
                    throw new IllegalStateException();
                before.nextNode = lastReturned.nextNode;
                if (lastReturned == tail)
                    tail = before;
            }
            if (next == lastReturned)
                next = lastReturned.nextNode;
            else
                nextIndex--;
            lastReturned = null;
            size--;
        }

        public void set(E e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            if (e == null)
                throw new NullPointerException();
            lastReturned.data = e;
        }

        public void add(E e) {
            if (e == null)
                throw new NullPointerException();

            Node<E> newNode = new Node<>(e);

            if (next == null)
                if (tail == null)
                    head = tail = newNode;
                else {
                    tail.nextNode = newNode;
                    tail = newNode;
                }
            else if (next == head) {
                newNode.nextNode = head;
                head = newNode;
            } else {
                prev.nextNode = newNode;
                newNode.nextNode = next;
            }
            lastReturned = null;
            prev = newNode;
            next = newNode.nextNode;
            nextIndex++;
            size++;
        }

        private Node<E> getNodeAt(int index) {
            if (index < 0 || index >= size)
                return null;
            Node<E> node = head;
            for (int i = 0; i < index; i++)
                node = node.nextNode;
            return node;
        }
    }
}
