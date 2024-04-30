# LinkedList
Custom implementation of a singly LinkedList

# Methods
1. `CustomLinkedList()` - constructor.
2. `add(T item)` - add item to list, returns true if successful, else false.
3. `add(int index, T item)` - add item to list at given index - throws IndexOutOfBoundsException.
4. `addAll(Collection<T> collection)` - adds collection of items to list, return true if list has changed, else false.
5. `addAll(int index, Collection<T> collection)` adds all items in collection at given index, throws NullPointerException on null collection, throw IndexOutOfBoundsException on index smaller than 0 or larger than list size.
6. `addFirst(T item)` - adds item to start of list.
7. `addLast(T item)` - adds item to end of list.
8. `contains(T item)` - checks if list contains item, returns true if present, else false. Throws NullPointerException on null item.
9. `element()` - returns item at start of list.
10. `equals(Object o)` - compares if two lists are equals, returns true if equal else false.
11. `get(int index)` - get item at given index from list, throws IndexOutOfBoundsException on index less than zero or larger than list size.
12. `hashCode()` - returns hashcode of list object.
13. `indexOf(T item)` - returns the index of item in list if present, else -1.
14. `lastIndexOf(T item)` - returns last index of item in list, else -1.
15. `offer(T item)` - adds item to end of list. returns true if successful, else false.
16. `offerFirst(T item)` - adds item to start of list. returns true if successful, else false.
17. `offerLast(T item)` - adds item to end of list. returns true if successful, else false.
18. `peek()` - returns but does not remove item at start of list, if empty return null.
19. `peekFirst()` - returns but does not remove item from start of list if present, else false.
20. `peekLast()` - returns but does not remove item at end of list if present, else null.
21. `poll()` - remove and return item from start of list.
22. `pollFirst()` - remove and return item from start of list, else null.
23. `pollLast()` - remove and return item at end of list, else null.
24. `push()` - adds item to start of list.
25. `pop()` - remove and return item from start of list.
26. `remove()` - remove and return item from start of list, throws NoSuchElementException on empty list.
27. `remove(T item)` - remove and return item from list if present, else return null.
28. `removeFirst()` - remove and return item from start of list, throw NoSuchElementException on empty list.
29. `removeFirstOccurrence(T item)` - remove first occurrence of item in list, returns true if removed, else false.
30. `removeLast()` - remove last item from list, throws NoSuchElementException on empty list.
31. `removeLastOccurrence(T item)` - removes last occurrence of item in list, returns true if list has changed, else false.
32. `set(int index, T item)` - sets item at index to new value, returns previous value at index, throws IndexOutOfBoundsException on index smaller than 0 or larger than list size.
33. `size()` - return size of list.
34. `toArray()` - return list as array.
35. `toString()` - return String representation of list.
