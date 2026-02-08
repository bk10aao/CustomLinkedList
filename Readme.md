# LinkedList
Custom implementation of a Singly LinkedList.
All methods implemented are of the [Java Linked List](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html) class including the [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html), [Deque](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html), [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) and [Cloneable](https://docs.oracle.com/javase/8/docs/api/java/lang/Cloneable.html) interfaces.

Implementation of a Dubly Linked List can be found [here](https://https://github.com/bk10aao/CustomDoublyLinkedList/tree/master).

![Null-Hostile](https://img.shields.io/badge/null-hostile-red)
![JDK-Matched](https://img.shields.io/badge/performance-JDK%20matched-blue)
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
