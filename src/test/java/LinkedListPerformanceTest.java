import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class LinkedListPerformanceTest {

    private static final int RUNS = 100;

    public static void main(String[] args) {
        int[] sizes = {1000, 2500, 5000, 7500, 10000, 25000, 50000, 100000, 250000, 500000, 1000000};

        long[][] results = new long[sizes.length][];

        String[] methodNames = {
                "\"LinkedList()\"",
                "\"LinkedList(Collection)\"",
                "\"add(T)\"",
                "\"add(int, T)\"",
                "\"addAll(Collection)\"",
                "\"addAll(int, Collection)\"",
                "\"addFirst(T)\"",
                "\"addLast(T)\"",
                "\"clone()\"",
                "\"contains(T)\"",
                "\"element()\"",
                "\"equals(Object)\"",
                "\"get(int)\"",
                "\"hashCode()\"",
                "\"indexOf(T)\"",
                "\"lastIndexOf(T)\"",
                "\"offer(T)\"",
                "\"offerFirst(T)\"",
                "\"offerLast(T)\"",
                "\"peek()\"",
                "\"peekFirst()\"",
                "\"peekLast()\"",
                "\"poll()\"",
                "\"pollFirst()\"",
                "\"pollLast()\"",
                "\"push(T)\"",
                "\"pop()\"",
                "\"remove()\"",
                "\"remove(int)\"",
                "\"remove(T)\"",
                "\"removeFirst()\"",
                "\"removeFirstOccurrence(T)\"",
                "\"removeLast()\"",
                "\"removeLastOccurrence(T)\"",
                "\"set(int, T)\"",
                "\"size()\"",
                "\"toArray()\"",
                "\"toString()\""
        };

        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            System.out.println("Benchmarking size: " + size);
            Collection<Integer> input = generateCollection(size);

            long constructorTime = benchmarkConstructor();
            long constructorCollectionTime = benchmarkConstructorCollection(input);
            long addTime = benchmarkAdd(size);
            long addIndexTime = benchmarkAddIndex(size);
            long addAllTime = benchmarkAddAll(input);
            long addAllIndexTime = benchmarkAddAllIndex(size, input);
            long addFirstTime = benchmarkAddFirst();
            long addLastTime = benchmarkAddLast();
            long cloneTime = benchmarkClone(size);
            long containsTime = benchmarkContains(size);
            long elementTime = benchmarkElement(size);
            long equalsTime = benchmarkEquals(size);
            long getTime = benchmarkGet(size);
            long hashCodeTime = benchmarkHashCode(size);
            long indexOfTime = benchmarkIndexOf(size);
            long lastIndexOfTime = benchmarkLastIndexOf(size);
            long offerTime = benchmarkOffer();
            long offerFirstTime = benchmarkOfferFirst();
            long offerLastTime = benchmarkOfferLast();
            long peekTime = benchmarkPeek(size);
            long peekFirstTime = benchmarkPeekFirst(size);
            long peekLastTime = benchmarkPeekLast(size);
            long pollTime = benchmarkPoll(size);
            long pollFirstTime = benchmarkPollFirst(size);
            long pollLastTime = benchmarkPollLast(size);
            long pushTime = benchmarkPush();
            long popTime = benchmarkPop(size);
            long removeTime = benchmarkRemove(size);
            long removeIndexTime = benchmarkRemoveIndex(size);
            long removeObjectTime = benchmarkRemoveObject(size);
            long removeFirstTime = benchmarkRemoveFirst(size);
            long removeFirstOccurrenceTime = benchmarkRemoveFirstOccurrence(size);
            long removeLastTime = benchmarkRemoveLast(size);
            long removeLastOccurrenceTime = benchmarkRemoveLastOccurrence(size);
            long setTime = benchmarkSet(size);
            long sizeTime = benchmarkSize(size);
            long toArrayTime = benchmarkToArray(size);
            long toStringTime = benchmarkToString(size);

            results[i] = new long[]{
                    size, constructorTime, constructorCollectionTime, addTime, addIndexTime, addAllTime,
                    addAllIndexTime, addFirstTime, addLastTime, cloneTime, containsTime, elementTime,
                    equalsTime, getTime, hashCodeTime, indexOfTime, lastIndexOfTime, offerTime,
                    offerFirstTime, offerLastTime, peekTime, peekFirstTime, peekLastTime, pollTime,
                    pollFirstTime, pollLastTime, pushTime, popTime, removeTime, removeIndexTime,
                    removeObjectTime, removeFirstTime, removeFirstOccurrenceTime, removeLastTime,
                    removeLastOccurrenceTime, setTime, sizeTime, toArrayTime, toStringTime
            };
        }

        try (FileWriter writer = new FileWriter("LinkedList_performance.csv")) {
            writer.write("\"Size\";");
            for (int j = 0; j < methodNames.length; j++) {
                writer.write(methodNames[j]);
                if (j < methodNames.length - 1) writer.write(";");
            }
            writer.write("\n");

            for (long[] row : results) {
                for (int j = 0; j < row.length; j++) {
                    writer.write(String.valueOf(row[j]));
                    if (j < row.length - 1) writer.write(";");
                }
                writer.write("\n");
            }
            System.out.println("Performance data written to LinkedList_performance.csv");
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }

    private static Collection<Integer> generateCollection(int size) {
        Collection<Integer> collection = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            collection.add(i);
        }
        return collection;
    }

    private static long benchmarkConstructor() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            long start = System.nanoTime();
            new LinkedList<>();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkConstructorCollection(Collection<Integer> input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            long start = System.nanoTime();
            new LinkedList<>(input);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAdd(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            long start = System.nanoTime();
            for (int j = 0; j < size; j++) {
                list.add(j);
            }
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAddIndex(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.add(size / 2, size + 1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAddAll(Collection<Integer> input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            long start = System.nanoTime();
            list.addAll(input);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAddAllIndex(int size, Collection<Integer> input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.addAll(size / 2, input);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAddFirst() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            long start = System.nanoTime();
            list.addFirst(1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAddLast() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            long start = System.nanoTime();
            list.addLast(1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkClone(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.clone();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkContains(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.contains(size - 1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkElement(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.element();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkEquals(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list1 = new LinkedList<>();
            LinkedList<Integer> list2 = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                list1.add(j);
                list2.add(j);
            }
            long start = System.nanoTime();
            list1.equals(list2);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkGet(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.get(size / 2);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkHashCode(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.hashCode();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkIndexOf(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.indexOf(size - 1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkLastIndexOf(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.lastIndexOf(size - 1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkOffer() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            long start = System.nanoTime();
            list.offer(1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkOfferFirst() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            long start = System.nanoTime();
            list.offerFirst(1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkOfferLast() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            long start = System.nanoTime();
            list.offerLast(1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkPeek(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.peek();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkPeekFirst(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.peekFirst();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkPeekLast(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.peekLast();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkPoll(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.poll();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkPollFirst(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.pollFirst();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkPollLast(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.pollLast();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkPush() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            long start = System.nanoTime();
            list.push(1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkPop(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.pop();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkRemove(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.remove();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkRemoveIndex(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.remove(size / 2);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkRemoveObject(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.remove(Integer.valueOf(size - 1));
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkRemoveFirst(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.removeFirst();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkRemoveFirstOccurrence(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.removeFirstOccurrence(size - 1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkRemoveLast(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.removeLast();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkRemoveLastOccurrence(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.removeLastOccurrence(size - 1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkSet(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.set(size / 2, size + 1);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkSize(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.size();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkToArray(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.toArray();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkToString(int size) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) list.add(j);
            long start = System.nanoTime();
            list.toString();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }
}