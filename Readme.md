# LinkedList
Custom implementation of a singly LinkedList

# Methods
1. `CustomLinkedList()` - constructor.
2. `CustomLinkedList(Collection<T> items)` - constructor with Collection of items to be added to list, throws NullPointerException on null collection.
3. `add(T item)` - add item to list, returns true if successful, else false.
4. `add(int index, T item)` - add item to list at given index - throws IndexOutOfBoundsException.
5. `addAll(Collection<T> collection)` - adds collection of items to list, return true if list has changed, else false.
6. `addAll(int index, Collection<T> collection)` adds all items in collection at given index, throws NullPointerException on null collection, throw IndexOutOfBoundsException on index smaller than 0 or larger than list size.
7. `addFirst(T item)` - adds item to start of list.
8. `addLast(T item)` - adds item to end of list.
9. `clone()` - returns a shallow copy of the list.
10. `contains(T item)` - checks if list contains item, returns true if present, else false. Throws NullPointerException on null item.
11. `element()` - returns item at start of list.
12. `equals(Object o)` - compares if two lists are equals, returns true if equal else false.
13. `get(int index)` - get item at given index from list, throws IndexOutOfBoundsException on index less than zero or larger than list size.
14. `hashCode()` - returns hashcode of list object.
15. `indexOf(T item)` - returns the index of item in list if present, else -1.
16. `lastIndexOf(T item)` - returns last index of item in list, else -1.
17. `offer(T item)` - adds item to end of list. returns true if successful, else false.
18. `offerFirst(T item)` - adds item to start of list. returns true if successful, else false.
19. `offerLast(T item)` - adds item to end of list. returns true if successful, else false.
20. `peek()` - returns but does not remove item at start of list, if empty return null.
21. `peekFirst()` - returns but does not remove item from start of list if present, else false.
22. `peekLast()` - returns but does not remove item at end of list if present, else null.
23. `poll()` - remove and return item from start of list.
24. `pollFirst()` - remove and return item from start of list, else null.
25. `pollLast()` - remove and return item at end of list, else null.
26. `push()` - adds item to start of list.
27. `pop()` - remove and return item from start of list.
28. `remove()` - remove and return item from start of list, throws NoSuchElementException on empty list.
29. `remove(T item)` - remove and return item from list if present, else return null.
30. `removeFirst()` - remove and return item from start of list, throw NoSuchElementException on empty list.
31. `removeFirstOccurrence(T item)` - remove first occurrence of item in list, returns true if removed, else false.
32. `removeLast()` - remove last item from list, throws NoSuchElementException on empty list.
33. `removeLastOccurrence(T item)` - removes last occurrence of item in list, returns true if list has changed, else false.
34. `set(int index, T item)` - sets item at index to new value, returns previous value at index, throws IndexOutOfBoundsException on index smaller than 0 or larger than list size.
35. `size()` - return size of list.
36. `toArray()` - return list as array.
37. `toString()` - return String representation of list.
