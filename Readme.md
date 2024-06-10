# LinkedList
Custom implementation of a singly LinkedList

# Methods
1. `CustomLinkedList()` - constructor.
2. `CustomLinkedList(Collection<T> items)` - constructor with Collection of items to be added to list, throws NullPointerException on null collection.
3. `boolean add(T item)` - add item to list, returns true if successful, else false.
4. `void add(int index, T item)` - add item to list at given index - throws IndexOutOfBoundsException.
5. `boolean addAll(Collection<T> collection)` - adds collection of items to list, return true if list has changed, else false.
6. `boolean addAll(int index, Collection<T> collection)` adds all items in collection at given index, throws NullPointerException on null collection, throw IndexOutOfBoundsException on index smaller than 0 or larger than list size.
7. `void addFirst(T item)` - adds item to start of list.
8. `void addLast(T item)` - adds item to end of list.
9. `CustomLinkedList<T> clone()` - returns a shallow copy of the list.
10. `boolean contains(T item)` - checks if list contains item, returns true if present, else false. Throws NullPointerException on null item.
11. `T element()` - returns item at start of list.
12. `boolean equals(Object o)` - compares if two lists are equals, returns true if equal else false.
13. `T get(int index)` - get item at given index from list, throws IndexOutOfBoundsException on index less than zero or larger than list size.
14. `int hashCode()` - returns hashcode of list object.
15. `int indexOf(T item)` - returns the index of item in list if present, else -1.
16. `int lastIndexOf(T item)` - returns last index of item in list, else -1.
17. `boolean offer(T item)` - adds item to end of list. returns true if successful, else false.
18. `boolean offerFirst(T item)` - adds item to start of list. returns true if successful, else false.
19. `boolean offerLast(T item)` - adds item to end of list. returns true if successful, else false.
20. `T peek()` - returns but does not remove item at start of list, if empty return null.
21. `T peekFirst()` - returns but does not remove item from start of list if present, else false.
22. `T peekLast()` - returns but does not remove item at end of list if present, else null.
23. `T poll()` - remove and return item from start of list.
24. `T pollFirst()` - remove and return item from start of list, else null.
25. `T pollLast()` - remove and return item at end of list, else null.
26. `void push()` - adds item to start of list.
27. `boolean remove(int index)` - remove and return item at given index, throws IndexOutOfBoundsException on index less than zero or larger than list size.
28. `T pop()` - remove and return item from start of list.
29. `T remove()` - remove and return item from start of list, throws NoSuchElementException on empty list.
30. `T remove(T item)` - remove and return item from list if present, else return null.
31. `T removeFirst()` - remove and return item from start of list, throw NoSuchElementException on empty list.
32. `boolean removeFirstOccurrence(T item)` - remove first occurrence of item in list, returns true if removed, else false.
33. `T removeLast()` - remove last item from list, throws NoSuchElementException on empty list.
34. `boolean removeLastOccurrence(T item)` - removes last occurrence of item in list, returns true if list has changed, else false.
35. `T set(int index, T item)` - sets item at index to new value, returns previous value at index, throws IndexOutOfBoundsException on index smaller than 0 or larger than list size.
36. `int size()` - return size of list.
37. `T[] toArray()` - return list as array.
38. `String toString()` - return String representation of list.
