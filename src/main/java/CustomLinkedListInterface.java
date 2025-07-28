import java.util.Collection;
import java.util.NoSuchElementException;

public interface CustomLinkedListInterface<E> {

    /**
     * Add item to list.
     * @param item - item to be added to list.
     * @return true if added.
     */
    boolean add(final E item);

    /**
     * Add item to list at given index.
     * @param index - index of item to be added to list.
     * @param item - item to be added to list.
     * @throws IndexOutOfBoundsException - on index less than 0 or larger than list size.
     */
    void add(final int index, final E item);

    /**
     * Add all items in collection to list.
     * @param collection - collection of items to add to list.
     * @throws NullPointerException - on null collection.
     */
    boolean addAll(final Collection<E> collection);

    /**
     * Add all items in collection to list at given index.
     * @param index - index to add collection to list.
     * @param collection - collection of items to add to list.
     * @throws NullPointerException - on null collection.
     * @throws IndexOutOfBoundsException - on index less than 0.
     * @throws IndexOutOfBoundsException on index larger than list size.
     */
    boolean addAll(final int index, final Collection<E> collection);

    /**
     * Add item to start of list.
     * @param item - item to be added to list.
     */
    void addFirst(final E item);

    /**
     * Add item to end of list.
     * @param item - item to be added to list.
     */
    void addLast(final E item);

    /**
     * Get a shallow clone of list.
     * @throws RuntimeException
     * @return CustomLinkedList<T> - clone of list.
     */
    CustomLinkedList<E> clone();

    /**
     * Get whether item is in list.
     * @param item - item to be searched for.
     * @throws NullPointerException - on null item.
     * @return true if present, else false.
     */
    boolean contains(final E item);

    /**
     * Get first item in list.
     * @throws NoSuchElementException - on empty list.
     * @return item at start of list.
     */
    E element();

    /**
     * Compares and returns whether two lists are equal.
     * @param o - list to be compared to.
     * @return true if equal, else false.
     */
    boolean equals(final Object o);

    /**
     * Get item at given index.
     * @param index - index of item to return.
     * @throws IndexOutOfBoundsException - on index smaller than zero.
     * @throws IndexOutOfBoundsException on  index larger than list size.
     * @return T - item at index.
     */
    E get(final int index);

    /**
     * Get hashcode for list.
     * @return hashcode for list.
     */
    int hashCode();

    /**
     * Get the index of item in list.
     * @param item - item to be found.
     * @return index of item in list if present, else -1.
     */
    int indexOf(final E item);

    /**
     * Get last index of item in list.
     * @param item - item to be found.
     * @return last index of item in list if present, else -1.
     */
    int lastIndexOf(final E item);

    /**
     * Adds item to list.
     * @param item - item to be added to list.
     * @return true if added to list, else false.
     */
    boolean offer(final E item);

    /**
     * Adds item to start of list.
     * @param item - item to be added to start of list.
     * @return true if added to list, else false.
     */
    boolean offerFirst(final E item);

    /**
     * Adds item to end of list.
     * @param item - item to be added to end of list.
     * @return true if added to list, else false.
     */
    boolean offerLast(final E item);

    /**
     * Returns but does not remove item from start of list.
     * @return item at start of list.
     */
    E peek();

    /**
     * Returns but does not remove item from start of list.
     * @return item at start of list if present, else null.
     */
    E peekFirst();

    /**
     * Returns but does not remove item from end of list.
     * @return item at end of list if present, else null.
     */
    E peekLast();

    /**
     * Get and remove item from start of list.
     * @throws NoSuchElementException on empty list.
     * @return item at start of list, else null.
     */
    E poll();

    /**
     * Get and remove item from start of list.
     * @return item at start of list, else null.
     */
    E pollFirst();

    /**
     * Get and remove item from end of list.
     * @return item at end of list, else null.
     */
    E pollLast();

    /**
     * Adds item to start of list.
     * @param item - item to be added to start of list.
     */
    void push(final E item);

    /**
     * remove item from start of list.
     * @return item at start of list.
     */
    E pop();


    /**
     * remove item from start of List.
     * @throws NoSuchElementException on empty list.
     * @return item - item at start of the list, else null.
     */
    E remove();

    /**
     * remove item from start of List.
     * @throws IndexOutOfBoundsException on index less than 0.
     * @throws IndexOutOfBoundsException on index bigger than or equal to size().
     * @return boolean - return true if removed else false.
     */
    boolean remove(int position);

    /**
     * Removes item from list.
     * @param item - item to be removed from list.
     * @throws NoSuchElementException on empty list.
     * @return item removed if present, else null.
     */
    E remove(final E item);

    /**
     * Remove and return first item in list.
     * @throws NoSuchElementException on empty list.
     * @return first item in list.
     */
    E removeFirst();

    /**
     * Remove first occurrence of item in list.
     * @param item - item to be removed.
     * @throws NoSuchElementException on empty list.
     * @return true if removed, else false.
     */
    boolean removeFirstOccurrence(final E item);

    /**
     * Remove and return last item from list.
     * @throws NoSuchElementException on empty list.
     * @return last item from list.
     */
    E removeLast();

    /**
     * Remove last occurrence of item from list.
     * @throws NoSuchElementException on empty list.
     * @return true if removed, else false. return false if item is null.
     */
    boolean removeLastOccurrence(final E item);

    /**
     * Set item at given index to new value.
     * @param index - index of item to be updated.
     * @param item - value to be updated to.
     * @throws IndexOutOfBoundsException on index less than 0.
     * @throws IndexOutOfBoundsException on index larger than or equal to size.
     * @return previous value for item.
     */
    E set(final int index, final E item);

    /**
     * Get size of list.
     * @return size of list as integer
     */
    int size();

    /**
     * Get all values from list as array.
     * @return all values from list as array, else null.
     */
    E[] toArray();

    /**
     * Get String representation of list.
     * @return String representation of list.
     */
    String toString();
}