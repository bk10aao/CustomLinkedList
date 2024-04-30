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
8. `clone()` - returns a shallow copy of the list.
9. `contains(T item)` - checks if list contains item, returns true if present, else false. Throws NullPointerException on null item.
10. `element()` - returns item at start of list.
11. `equals(Object o)` - compares if two lists are equals, returns true if equal else false.
12. `get(int index)` - get item at given index from list, throws IndexOutOfBoundsException on index less than zero or larger than list size.
13. `hashCode()` - returns hashcode of list object.
14. `indexOf(T item)` - returns the index of item in list if present, else -1.
15. `lastIndexOf(T item)` - returns last index of item in list, else -1.
16. `offer(T item)` - adds item to end of list. returns true if successful, else false.
17. `offerFirst(T item)` - adds item to start of list. returns true if successful, else false.
18. `offerLast(T item)` - adds item to end of list. returns true if successful, else false.
19. `peek()` - returns but does not remove item at start of list, if empty return null.
20. `peekFirst()` - returns but does not remove item from start of list if present, else false.
21. `peekLast()` - returns but does not remove item at end of list if present, else null.
22. `poll()` - remove and return item from start of list.
23. `pollFirst()` - remove and return item from start of list, else null.
24. `pollLast()` - remove and return item at end of list, else null.
25. `push()` - adds item to start of list.
26. `pop()` - remove and return item from start of list.
27. `remove()` - remove and return item from start of list, throws NoSuchElementException on empty list.
28. `remove(T item)` - remove and return item from list if present, else return null.
29. `removeFirst()` - remove and return item from start of list, throw NoSuchElementException on empty list.
30. `removeFirstOccurrence(T item)` - remove first occurrence of item in list, returns true if removed, else false.
31. `removeLast()` - remove last item from list, throws NoSuchElementException on empty list.
32. `removeLastOccurrence(T item)` - removes last occurrence of item in list, returns true if list has changed, else false.
33. `set(int index, T item)` - sets item at index to new value, returns previous value at index, throws IndexOutOfBoundsException on index smaller than 0 or larger than list size.
34. `size()` - return size of list.
35. `toArray()` - return list as array.
36. `toString()` - return String representation of list.
