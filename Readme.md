# LinkedList
Custom implementation of a singly LinkedList

# Methods
1. `CustomLinkedList()` - constructor.
2. `CustomLinkedList(Collection<E> items)` - constructor with Collection of items to be added to list, throws NullPointerException on null collection.
3. `boolean add(E item)` - add item to list, returns true if successful, else false.
4. `void add(int index, E item)` - add item to list at given index - throws IndexOutOfBoundsException.
5. `boolean addAll(Collection<E> collection)` - adds collection of items to list, return true if list has changed, else false.
6. `boolean addAll(int index, Collection<E> collection)` adds all items in collection at given index, throws NullPointerException on null collection, throw IndexOutOfBoundsException on index smaller than 0 or larger than list size.
7. `void addFirst(E item)` - adds item to start of list.
8. `void addLast(E item)` - adds item to end of list.
9. `CustomLinkedList<E> clone()` - returns a shallow copy of the list.
10. `boolean contains(E item)` - checks if list contains item, returns true if present, else false. Throws NullPointerException on null item.
11. `E element()` - returns item at start of list.
12. `boolean equals(Object o)` - compares if two lists are equals, returns true if equal else false.
13. `E get(int index)` - get item at given index from list, throws IndexOutOfBoundsException on index less than zero or larger than list size.
14. `int hashCode()` - returns hashcode of list object.
15. `int indexOf(E item)` - returns the index of item in list if present, else -1.
16. `int lastIndexOf(E item)` - returns last index of item in list, else -1.
17. `boolean offer(E item)` - adds item to end of list. returns true if successful, else false.
18. `boolean offerFirst(E item)` - adds item to start of list. returns true if successful, else false.
19. `boolean offerLast(E item)` - adds item to end of list. returns true if successful, else false.
20. `E peek()` - returns but does not remove item at start of list, if empty return null.
21. `E peekFirst()` - returns but does not remove item from start of list if present, else false.
22. `E peekLast()` - returns but does not remove item at end of list if present, else null.
23. `E poll()` - remove and return item from start of list.
24. `E pollFirst()` - remove and return item from start of list, else null.
25. `E pollLast()` - remove and return item at end of list, else null.
26. `void push()` - adds item to start of list.
27. `boolean remove(int index)` - remove and return item at given index, throws IndexOutOfBoundsException on index less than zero or larger than list size.
28. `E pop()` - remove and return item from start of list.
29. `E remove()` - remove and return item from start of list, throws NoSuchElementException on empty list.
30. `E remove(E item)` - remove and return item from list if present, else return null.
31. `E removeFirst()` - remove and return item from start of list, throw NoSuchElementException on empty list.
32. `boolean removeFirstOccurrence(E item)` - remove first occurrence of item in list, returns true if removed, else false.
33. `E removeLast()` - remove last item from list, throws NoSuchElementException on empty list.
34. `boolean removeLastOccurrence(E item)` - removes last occurrence of item in list, returns true if list has changed, else false.
35. `E set(int index, T item)` - sets item at index to new value, returns previous value at index, throws IndexOutOfBoundsException on index smaller than 0 or larger than list size.
36. `int size()` - return size of list.
37. `E[] toArray()` - return list as array.
38. `String toString()` - return String representation of list.

# Time Complexity Comparison:

| **Method**                             | **Java LinkedList** | **CustomLinkedList<T>** | **Winner** |
|----------------------------------------|:-------------------:|:-----------------------:|:----------:|
| `add(E)`                               |        O(1)         |          O(1)           |    Tie     |
| `add(int, E)`                          |        O(n)         |          O(n)           |    Tie     |
| `addAll(Collection<? extends E>)`      |        O(m)         |          O(m)           |    Tie     |
| `addAll(int, Collection<? extends E>)` |      O(n + m)       |        O(n + m)         |    Tie     |
| `addFirst(T)`                          |        O(1)         |          O(1)           |    Tie     |
| `addLast(T)`                           |        O(1)         |          O(1)           |    Tie     |
| `clone()`                              |        O(n)         |          O(n)           |    Tie     |
| `contains(Object)`                     |        O(n)         |          O(n)           |    Tie     |
| `element()`                            |        O(1)         |          O(1)           |    Tie     |
| `get(int)`                             |        O(n)         |          O(n)           |    Tie     |
| `indexOf(Object)`                      |        O(n)         |          O(n)           |    Tie     |
| `lastIndexOf(Object)`                  |        O(n)         |          O(n)           |    Tie     |
| `offer(E)`                             |        O(1)         |          O(1)           |    Tie     |
| `offerFirst(E)`                        |        O(1)         |          O(1)           |    Tie     |
| `offerLast(E)`                         |        O(1)         |          O(1)           |    Tie     |
| `peek()`                               |        O(1)         |          O(1)           |    Tie     |
| `peekFirst()`                          |        O(1)         |          O(1)           |    Tie     |
| `peekLast()`                           |        O(1)         |          O(1)           |    Tie     |
| `poll()`                               |        O(1)         |          O(1)           |    Tie     |
| `pollFirst()`                          |        O(1)         |          O(1)           |    Tie     |
| `pollLast()`                           |        O(1)         |          O(n)           | LinkedList |
| `push(E)`                              |        O(1)         |          O(1)           |    Tie     |
| `pop()`                                |        O(1)         |          O(1)           |    Tie     |
| `remove()`                             |        O(1)         |          O(1)           |    Tie     |
| `remove(int)`                          |        O(n)         |          O(n)           |    Tie     |
| `remove(Object)`                       |        O(n)         |          O(n)           |    Tie     |
| `removeFirst()`                        |        O(1)         |          O(1)           |    Tie     |
| `removeFirstOccurrence(Object)`        |        O(n)         |          O(n)           |    Tie     |
| `removeLast()`                         |        O(1)         |          O(n)           | LinkedList |
| `removeLastOccurrence(Object)`         |        O(n)         |          O(n)           |    Tie     |
| `set(int, E)`                          |        O(n)         |          O(n)           |    Tie     |
| `size()`                               |        O(1)         |          O(1)           |    Tie     |
| `toArray()`                            |        O(n)         |          O(n)           |    Tie     |
| `toString()`                           |        O(n)         |          O(n)           |    Tie     |


# Space Complexity Comparison:

| **Method**                             | **Java LinkedList** | **CustomLinkedList<T>** | **Winner** |
|----------------------------------------|:-------------------:|:-----------------------:|:----------:|
| `add(T)`                               |        O(1)         |          O(1)           |    Tie     |
| `add(int, E)`                          |        O(1)         |          O(1)           |    Tie     |
| `addAll(Collection<? extends E>)`      |        O(m)         |          O(m)           |    Tie     |
| `addAll(int, Collection<? extends E>)` |        O(m)         |          O(m)           |    Tie     |
| `addFirst(E)`                          |        O(1)         |          O(1)           |    Tie     |
| `addLast(E)`                           |        O(1)         |          O(1)           |    Tie     |
| `clone()`                              |        O(n)         |          O(n)           |    Tie     |
| `contains(Object)`                     |        O(1)         |          O(1)           |    Tie     |
| `element()`                            |        O(1)         |          O(1)           |    Tie     |
| `get(int)`                             |        O(1)         |          O(1)           |    Tie     |
| `indexOf(Object)`                      |        O(1)         |          O(1)           |    Tie     |
| `lastIndexOf(Object)`                  |        O(1)         |          O(1)           |    Tie     |
| `offer(E)`                             |        O(1)         |          O(1)           |    Tie     |
| `offerFirst(E)`                        |        O(1)         |          O(1)           |    Tie     |
| `offerLast(E)`                         |        O(1)         |          O(1)           |    Tie     |
| `peek()`                               |        O(1)         |          O(1)           |    Tie     |
| `peekFirst()`                          |        O(1)         |          O(1)           |    Tie     |
| `peekLast()`                           |        O(1)         |          O(1)           |    Tie     |
| `poll()`                               |        O(1)         |          O(1)           |    Tie     |
| `pollFirst()`                          |        O(1)         |          O(1)           |    Tie     |
| `pollLast()`                           |        O(1)         |          O(1)           |    Tie     |
| `push(E)`                              |        O(1)         |          O(1)           |    Tie     |
| `pop()`                                |        O(1)         |          O(1)           |    Tie     |
| `remove()`                             |        O(1)         |          O(1)           |    Tie     |
| `remove(int)`                          |        O(1)         |          O(1)           |    Tie     |
| `remove(Object)`                       |        O(1)         |          O(1)           |    Tie     |
| `removeFirst()`                        |        O(1)         |          O(1)           |    Tie     |
| `removeFirstOccurrence(Object)`        |        O(1)         |          O(1)           |    Tie     |
| `removeLast()`                         |        O(1)         |          O(1)           |    Tie     |
| `removeLastOccurrence(Object)`         |        O(1)         |          O(1)           |    Tie     |
| `set(int, E)`                          |        O(1)         |          O(1)           |    Tie     |
| `size()`                               |        O(1)         |          O(1)           |    Tie     |
| `toArray()`                            |        O(n)         |          O(n)           |    Tie     |
| `toString()`                           |        O(n)         |          O(n)           |    Tie     |


notes:
- *n* = Number of elements in the list.
- *m* = Number of elements in the input

# Performance Charts

## Custom Linked List vs Linked List
![Combined Performance Charts](PerformanceTesting/Constructor().png)
![Combined Performance Charts](PerformanceTesting/Constructor(Collection).png)
![Combined Performance Charts](PerformanceTesting/add(T).png)
![Combined Performance Charts](PerformanceTesting/add(int,%20T).png)
![Combined Performance Charts](PerformanceTesting/addAll(Collection).png)
![Combined Performance Charts](PerformanceTesting/addAll(int,%20Collection).png)
![Combined Performance Charts](PerformanceTesting/addFirst().png)
![Combined Performance Charts](PerformanceTesting/addLast().png)
![Combined Performance Charts](PerformanceTesting/clone().png)
![Combined Performance Charts](PerformanceTesting/contains(T).png)
![Combined Performance Charts](PerformanceTesting/equals(Object).png)
![Combined Performance Charts](PerformanceTesting/get(int).png)
![Combined Performance Charts](PerformanceTesting/hashCode().png)
![Combined Performance Charts](PerformanceTesting/indexOf().png)
![Combined Performance Charts](PerformanceTesting/lastIndexOf(T).png)
![Combined Performance Charts](PerformanceTesting/offer(T).png)
![Combined Performance Charts](PerformanceTesting/peek().png)
![Combined Performance Charts](PerformanceTesting/poll().png)
![Combined Performance Charts](PerformanceTesting/remove(T).png)
![Combined Performance Charts](PerformanceTesting/removeFIrstOccurence(T).png)
![Combined Performance Charts](PerformanceTesting/removeLastOccurence(T).png)
![Combined Performance Charts](PerformanceTesting/set(int,%20T).png)
![Combined Performance Charts](PerformanceTesting/toArray().png)
![Combined Performance Charts](PerformanceTesting/toString().png)
