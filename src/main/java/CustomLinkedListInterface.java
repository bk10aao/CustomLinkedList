import java.util.Collection;
import java.util.NoSuchElementException;

public interface CustomLinkedListInterface<T> {

    /**
     * Add item to list
     * @param item - item to be added to list
     * @return true if added
     */
    boolean add(final T item);

    /**
     * Add item to list at given index
     * @param index - index of item to be added to list
     * @param item - item to be added to list
     * @throws IndexOutOfBoundsException - on index less than 0 or larger than list size
     */
    void add(final int index, final T item);

    /**
     * Add all items in collection to list
     * @param collection - collection of items to add to list
     * @throws NullPointerException - on null collection
     */
    boolean addAll(final Collection<T> collection);

    /**
     * Add all items in collection to list at given index
     * @param index - index to add collection to list
     * @param collection - collection of items to add to list
     * @throws NullPointerException - on null collection
     * @throws IndexOutOfBoundsException - on index less than 0 or larger than list size
     */
    boolean addAll(final int index, final Collection<T> collection);

    /**
     * Add item to start of list
     * @param item - item to be added to list
     */
    void addFirst(final T item);

    /**
     * Add item to end of list
     * @param item - item to be added to list
     */
    void addLast(final T item);

    /**
     * Get a shallow clone of list
     * @return CustomLinkedList<T> - clone of list.
     */
    CustomLinkedList<T> clone();

    /**
     * Get whether item is in list
     * @param item - item to be searched for
     * @return true if present, else false
     * @throws NullPointerException - on null item
     */
    boolean contains(final T item);

    /**
     * Get first item in list
     * @return item at start of list
     * @throws NoSuchElementException - on empty list
     */
    T element();

    /**
     * Compares and returns whether two lists are equal
     * @param o - list to be compared to
     * @return true if equal, else false
     */
    boolean equals(final Object o);

    /**
     * Get item at given index
     * @param index - index of item to return
     * @return T - item at index
     * @throws IndexOutOfBoundsException - on index smaller than zero, or larger than list size
     */
    T get(final int index);

    /**
     * Get hashcode for list
     * @return hashcode for list
     */
    int hashCode();

    /**
     * Get the index of item in list
     * @param item - item to be found
     * @return index of item in list if present, else -1
     */
    int indexOf(final T item);

    /**
     * Get last index of item in list
     * @param item - item to be found
     * @return last index of item in list if present, else -1
     */
    int lastIndexOf(final T item);

    /**
     * Adds item to list
     * @param item - item to be added to list
     * @return true if added to list, else false
     */
    boolean offer(final T item);

    /**
     * Adds item to start of list
     * @param item - item to be added to start of list
     * @return true if added to list, else false
     */
    boolean offerFirst(final T item);

    /**
     * Adds item to end of list
     * @param item - item to be added to end of list
     * @return true if added to list, else false
     */
    boolean offerLast(final T item);

    /**
     * Returns but does not remove item from start of list
     * @return item at start of list
     */
    T peek();

    /**
     * Returns but does not remove item from start of list
     * @return item at start of list if present, else null
     */
    T peekFirst();

    /**
     * Returns but does not remove item from end of list
     * @return item at end of list if present, else null
     */
    T peekLast();

    /**
     * Get and remove item from start of list
     * @return item at start of list, else null
     */
    T poll();

    /**
     * Get and remove item from start of list
     * @return item at start of list, else null.
     */
    T pollFirst();

    /**
     * Get and remove item from end of list
     * @return item at end of list, else null.
     */
    T pollLast();

    /**
     * Adds item to start of list
     * @param item - item to be added to start of list;
     */
    void push(final T item);

    /**
     * remove item from start of list
     * @return item at start of list
     */
    T pop();

    /**
     * Get and remove item from start of list
     * @return item at start of list
     * @throws NoSuchElementException on empty list
     */
    T remove();

    /**
     * Remove item from list with given index
     * @param index - index of item to remove
     * @return true if removed
     */
    boolean remove(final int index);

    /**
     * Removes item from list
     * @param item - item to be removed from list
     * @return item removed if present, else null
     */
    T remove(final T item);

    /**
     * Remove and return first item in list
     * @return first item in list
     * @throws NoSuchElementException on empty list
     */
    T removeFirst();

    /**
     * Remove first occurrence of item in list
     * @param item - item to be removed
     * @return true if removed, else false. return false if item is null
     */
    boolean removeFirstOccurrence(final T item);

    /**
     * Remove and return last item from list
     * @return last item from list
     * @throws NoSuchElementException on empty list.
     */
    T removeLast();

    /**
     * Remove last occurrence of item from list
     * @return true if removed, else false. return false if item is null
     */
    boolean removeLastOccurrence(final T item);

    /**
     * Set item at given index to new value
     * @param index - index of item to be updated
     * @param item - value to be updated to
     * @return previous value for item
     * @throws IndexOutOfBoundsException on index less than 0 or larger than list size.
     */
    T set(final int index, final T item);

    /**
     * Get size of list
     * @return size of list as integer
     */
    int size();

    /**
     * Get all values from list as array
     * @return all values from list as array, else null
     */
    T[] toArray();

    /**
     * Get String representation of list
     * @return String representation of list
     */
    String toString();
}
