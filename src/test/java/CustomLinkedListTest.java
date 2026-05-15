import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("CollectionAddedToSelf")
class CustomLinkedListTest {

    @Test
    public void givenNewEmptyList_returnsSizeOf_0() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertEquals(0, customLinkedList.size());
    }

    @Test
    public void givenConstructorWithCollectionParameter_onNullCollection_throws_NullPointerException() {
        assertThrows(NullPointerException.class, () -> new CustomLinkedList<Integer>(null));
    }

    @Test
    public void givenConstructorWithCollectionParameter_onCollectionOf_0_1_2_3_4_containsValues_withSizeOf_5() {
        Collection<Integer> values = new ArrayList<>(List.of(0, 1, 2, 3, 4));
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(values);
        assertTrue(customLinkedList.contains(0));
        assertTrue(customLinkedList.contains(1));
        assertTrue(customLinkedList.contains(2));
        assertTrue(customLinkedList.contains(3));
        assertTrue(customLinkedList.contains(4));
        assertEquals(5, customLinkedList.size());
    }

    @Test
    public void givenLinkedListOfType_Integer_onAdding_1_returnsSizeOf_1() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(1);
        assertEquals(1, customLinkedList.size());
    }

    @Test
    public void givenLinkedListOfType_Integer_onAdding_1_2_returnsSizeOf_2() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertEquals(1, customLinkedList.size());
        assertTrue(customLinkedList.add(2));
        assertEquals(2, customLinkedList.size());
    }

    @Test
    public void givenNewListOf_10_onAddLast_20_returnsSizeOf_2() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addFirst(10);
        customLinkedList.add(20);
        assertEquals(2, customLinkedList.size());
        assertEquals(20, customLinkedList.get(1));
    }

    @Test
    public void givenNewList_onRemove_throws_NoSuchElementException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertThrows(NoSuchElementException.class, customLinkedList::remove);
    }

    @Test
    public void givenNewListOf_10_20_30_on_remove_returns_10_andSizeOf_2() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(3, customLinkedList.size());
        assertEquals(10, customLinkedList.remove());
        assertEquals(2, customLinkedList.size());
    }

    @Test
    public void givenNewListOf_A_B_C_on_remove_A_returns_true() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("A");
        customLinkedList.add("B");
        customLinkedList.add("C");
        assertTrue(customLinkedList.remove("A"));
        assertEquals("B", customLinkedList.getFirst());
    }

    @Test
    public void givenNewListOf_A_B_C_on_remove_C_returns_true() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("A");
        customLinkedList.add("B");
        customLinkedList.add("C");
        assertTrue(customLinkedList.remove("C"));
        assertEquals("B", customLinkedList.getLast());
    }

    @Test
    public void givenNewListOf_A_on_remove_A_returns_true() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("A");
        assertTrue(customLinkedList.remove("A"));
    }

    @Test
    public void givenEmptyList_returns_onRemove_A_returns_false() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertFalse(customLinkedList.remove("A"));
    }

    @Test
    public void givenNewList_onRemoveFirst_throws_NoSuchElementException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertThrows(NoSuchElementException.class, customLinkedList::removeFirst);
    }

    @Test
    public void givenNewListOf_10_20_30_on_removeFirst_returns_10_andSizeOf_2() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(3, customLinkedList.size());
        assertEquals(10, customLinkedList.removeFirst());
        assertEquals(2, customLinkedList.size());
    }

    @Test
    public void givenNewList_onRemoveLast_throws_NoSuchElementException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertThrows(NoSuchElementException.class, customLinkedList::removeLast);
    }

    @Test
    public void givenNewListOf_10_removeLast_returns_10_andSizeOf_0() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        assertEquals(1, customLinkedList.size());
        assertEquals(10, customLinkedList.removeLast());
        assertEquals(0, customLinkedList.size());
    }

    @Test
    public void givenNewListOf_10_20_30_on_removeLast_returns_30_andSizeOf_2() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(3, customLinkedList.size());
        assertEquals(30, customLinkedList.removeLast());
        assertEquals(2, customLinkedList.size());
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_0_adds_100_toStart() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        customLinkedList.add(0, 100);
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_0_adds_100_toIndex_0() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        customLinkedList.add(0, 100);
        assertEquals(100, customLinkedList.get(0));
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_1_adds_100_toIndex_1() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        customLinkedList.add(1, 100);
        assertEquals(100, customLinkedList.get(1));
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_2_adds_100_toIndex_2() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        customLinkedList.add(2, 100);
        assertEquals(100, customLinkedList.get(2));
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_3_adds_100_toIndex_3() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        customLinkedList.add(3, 100);
        assertEquals(100, customLinkedList.get(3));
    }

    @Test
    void givenListOf_4_5_6_on_addAll_1_2_3_atIndex_0_returns_4_5_6_1_2_3() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.addAll(List.of(1, 2, 3));

        list.addAll(0, List.of(4, 5, 6));

        assertEquals(List.of(4, 5, 6, 1, 2, 3), list);
        assertNotNull(list.getFirst());
    }

    @Test
    public void givenEmptyCustomLinkedList_getFirst_throws_NoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> new CustomLinkedList<>().getFirst());
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_5_throwsIndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.remove(5));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_negative_1_throwsIndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.remove(-1));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_3_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertEquals(3, customLinkedList.remove(2));
        assertEquals(2, customLinkedList.size());
        assertEquals(1, customLinkedList.get(0));
        assertEquals(2, customLinkedList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.get(2));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_1_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertEquals(2, customLinkedList.remove(1));
        assertEquals(2, customLinkedList.size());
    }

    @Test
    public void givenEmptyLinkedListOfType_Integer_on_addLast_1_returnsSizeOf_1() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addLast(1);
        assertEquals(1, customLinkedList.size());
    }

    @Test
    public void givenEmptyLinkedListOfType_onGet_negativeOne_throwsIndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.get(-1));
    }

    @Test
    public void givenLinkedListOf3Values_onGetIndex_4_throws_indexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.get(4));
    }

    @Test
    public void givenLinkedListOfValue_10_20_30_onGetRelevantIndexes_returnsCorrectValues() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(10, customLinkedList.get(0));
        assertEquals(20, customLinkedList.get(1));
        assertEquals(30, customLinkedList.get(2));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toNegativeIndex_throws_indexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.add(-1,40));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toIndex_100_throws_indexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.add(100,40));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toIndex_1_returns_10_40_20_30() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        customLinkedList.add(1, 40);
        assertEquals(40, customLinkedList.get(1));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toIndex_2_returns_10_20_40_30() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        customLinkedList.add(2, 40);
        assertEquals(40, customLinkedList.get(2));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_40_onAdd_50_toIndex_3_returns_10_20_30_50_40() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        customLinkedList.add(40);
        customLinkedList.add(3, 50);
        assertEquals(50, customLinkedList.get(3));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onContains_null_throws_nullPointerException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onContains_100_returns_false() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertFalse(customLinkedList.contains(100));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onContains_20_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertTrue(customLinkedList.contains(20));
    }

    @Test
    public void givenEmptyLinkedList_of_element_throws_NoSuchElementException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertThrows(NoSuchElementException.class, customLinkedList::element);
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onElement_returns_10() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(10, customLinkedList.element());
    }

    @Test
    public void givenEmptyLinkedList_onPoll_returns_null() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertNull(customLinkedList.poll());
    }

    @Test
    public void givenLinkedListOf_20_onPoll_returns_20() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(20);
        assertEquals(20, customLinkedList.poll());
        assertEquals(0, customLinkedList.size());
    }

    @Test
    public void givenLinkedListOf_10_20_30_onPoll_returns_10() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(3, customLinkedList.size());
        assertEquals(10, customLinkedList.poll());
        assertEquals(2, customLinkedList.size());
    }

    @Test
    public void givenLinkedListOf_10_20_30_onOffer_40_returns_true_andLastItemInListOf_40() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(3, customLinkedList.size());
        assertEquals(30, customLinkedList.get(customLinkedList.size() - 1));
        assertTrue(customLinkedList.offer(40));
        assertEquals(40, customLinkedList.get(customLinkedList.size() - 1));
    }

    @Test
    public void givenLinkedListOf_10_20_30_onOfferFirst_40_returns_true_andFirstItemInListOf_40_andSecondItemInListOf_10() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(3, customLinkedList.size());
        assertEquals(30, customLinkedList.get(customLinkedList.size() - 1));
        assertTrue(customLinkedList.offerFirst(40));
        assertEquals(30, customLinkedList.get(customLinkedList.size() - 1));
        assertEquals(40, customLinkedList.get(0));
        assertEquals(10, customLinkedList.get(1));
    }

    @Test
    public void givenLinkedListOf_10_20_30_onOfferLast_40_returns_true_andLastInListOf_40() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(3, customLinkedList.size());
        assertEquals(30, customLinkedList.get(customLinkedList.size() - 1));
        assertTrue(customLinkedList.offerLast(40));
        assertEquals(40, customLinkedList.get(customLinkedList.size() - 1));
        assertEquals(30, customLinkedList.get(customLinkedList.size() - 2));
    }

    @Test
    public void givenEmptyLinkedList_onPeekFirst_returns_null() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertNull(customLinkedList.peekFirst());
    }

    @Test
    public void givenLinkedListOf_10_20_30_onPeekFirst_returns_10() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(10, customLinkedList.peekFirst());
    }

    @Test
    public void givenEmptyLinkedList_onPeekLast_returns_null() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertNull(customLinkedList.peekLast());
    }

    @Test
    public void givenLinkedListOf_10_20_30_onPeekLast_returns_30() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(30, customLinkedList.peekLast());
    }

    @Test
    public void givenEmptyLinkedList_onPollFirst_returns_null() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertNull(customLinkedList.pollFirst());
    }

    @Test
    public void givenLinkedListOf_10_20_30_onPollFirst_returns_10() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(10, customLinkedList.pollFirst());
    }

    @Test
    public void givenEmptyLinkedList_on_pollLast_returns_null() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertNull(customLinkedList.pollLast());
    }

    @Test
    public void givenLinkedListOf_10_20_30_on_pollLast_returns_30() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);
        assertEquals(30, customLinkedList.pollLast());
        assertEquals(20, customLinkedList.get(customLinkedList.size() - 1));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_push_valueOf_0_insert_zeroToStart() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        customLinkedList.push(0);
        assertEquals(0, customLinkedList.get(0));
    }

    @Test
    public void givenEmptyLinkedList_onPop_throws_NoSuchElementException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertThrows(NoSuchElementException.class, customLinkedList::pop);
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_pop_valueOf_0_insert_zeroToStart() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertEquals(1, customLinkedList.pop());
        assertEquals(2, customLinkedList.get(0));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_negative_1_to_40throwsIndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.set(-1, 40));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_4_to_40throwsIndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.set(4, 40));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_0_to_10_updatesIndexValueTo_10() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertEquals(1,  customLinkedList.set(0, 10));
        assertEquals(10, customLinkedList.get(0));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_1_to_10_updatesIndexValueTo_10() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertEquals(2,  customLinkedList.set(1, 10));
        assertEquals(10, customLinkedList.get(1));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_4_onSetIndexOf_2_to_10_updatesIndexValueTo_10() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertTrue(customLinkedList.add(4));
        assertEquals(3,  customLinkedList.set(2, 10));
        assertEquals(10, customLinkedList.get(2));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_4_onSetIndexOf_3_to_10_updatesIndexValueTo_10() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertTrue(customLinkedList.add(4));
        assertEquals(4,  customLinkedList.set(3, 10));
        assertEquals(10, customLinkedList.get(3));
    }

    @Test
    public void givenLinkedListOfTypeInteger_withNoValues_onToArray_returns_emptyArray() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertEquals(0, customLinkedList.toArray().length);
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onToArray_returnsCorrectArray() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertArrayEquals(new Integer[] { 1, 2, 3 } , customLinkedList.toArray());
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onToArray_withIntArrayParameter_returnsCorrectArray() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.add(3);
        assertArrayEquals(new Integer[] {1, 2, 3}, customLinkedList.toArray(new Integer[0]));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onToArray_withIntArrayParameterP_withSize_2_returnsCorrectArray() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.add(3);
        assertArrayEquals(new Integer[] {1, 2, 3}, customLinkedList.toArray(new Integer[2]));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onToArray_withIntArrayParameterP_withSize_5_returnsCorrectArray() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.add(3);
        assertArrayEquals(new Integer[] {1, 2, 3, null, null}, customLinkedList.toArray(new Integer[5]));
    }

    @Test
    public void givenLinkedListOfType_Integer_onAddingNullCollection_throws_NullPointerException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertThrows(NullPointerException.class, () -> customLinkedList.addAll(null));
    }

    @Test
    public void givenLinkedListOfType_Integer_onAddingEmptyCollection_returns_false() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertFalse(customLinkedList.addAll(new ArrayList<>()));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_onAddingEmptyCollection_atIndex_1_returns_false() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2));
        Collection<Integer> collection = List.of();
        assertFalse(customLinkedList.addAll(1, collection));
    }

    @Test
    public void insertAnotherCustomListAtBeginning_shouldWork() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(10, 20));
        CustomLinkedList<Integer> toInsert = new CustomLinkedList<>(List.of(1, 2));
        customLinkedList.addAll(0, toInsert);
        assertEquals(List.of(1, 2, 10, 20), List.copyOf(customLinkedList));
    }

    @Test
    public void givenEmptyLinkedListOfType_Integer_onAddAll_atIndex_1_returnsFalse() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2));
        Collection<Integer> collection = List.of(3);
        assertTrue(customLinkedList.addAll(1, collection));
        assertEquals(1, customLinkedList.get(0));
        assertEquals(3, customLinkedList.get(1));
        assertEquals(2, customLinkedList.get(2));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_onAddAll_2_atIndex_1_updatesListCorrectly() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2));
        Collection<Integer> collection = List.of(3);
        assertTrue(customLinkedList.addAll(1, collection));
        assertEquals(1, customLinkedList.get(0));
        assertEquals(3, customLinkedList.get(1));
        assertEquals(2, customLinkedList.get(2));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onAddAll_4_5_6_updatesListCorrectly() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        Collection<Integer> collection = new ArrayList<>();
        collection.add(4);
        collection.add(5);
        collection.add(6);
        assertTrue(customLinkedList.addAll(collection));
        assertEquals(1, customLinkedList.get(0));
        assertEquals(2, customLinkedList.get(1));
        assertEquals(3, customLinkedList.get(2));
        assertEquals(4, customLinkedList.get(3));
        assertEquals(5, customLinkedList.get(4));
        assertEquals(6, customLinkedList.get(5));
    }

    @Test
    public void givenTwoLinkedListsOfType_Integer_firstValues_1_2_3_secondValue_4_5_6_onEquals_returnsFalse() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));

        CustomLinkedList<Integer> customLinkedListTwo = new CustomLinkedList<>();
        customLinkedListTwo.add(4);
        customLinkedListTwo.add(5);
        customLinkedListTwo.add(6);
        assertNotEquals(customLinkedList, customLinkedListTwo);
    }

    @Test
    public void givenTwoLinkedListsOfType_Integer_firstValues_1_2_3_secondValue_1_2_3_onEquals_returnsTrue() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));

        CustomLinkedList<Integer> customLinkedListTwo = new CustomLinkedList<>();
        customLinkedListTwo.add(1);
        customLinkedListTwo.add(2);
        customLinkedListTwo.add(3);
        assertEquals(customLinkedList, customLinkedListTwo);
    }

    @Test
    public void givenEmptyLinkedList_onRemove_throws_NoSuchElementException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertThrows(NoSuchElementException.class, customLinkedList::remove);
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onRemove_returns_1() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertEquals(1, customLinkedList.remove());
        assertEquals(2, customLinkedList.peek());
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onRemoveObject_d_returns_false() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertFalse(customLinkedList.remove("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onRemoveObject_b_returns_true_andRemoveItFromList() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertTrue(customLinkedList.remove("b"));
        assertEquals("a", customLinkedList.get(0));
        assertEquals("c", customLinkedList.get(1));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onIndexOf_d_returns_minus_1() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertEquals(-1, customLinkedList.indexOf("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onIndexOf_a_returns_0_b_1_c_2() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertEquals(0, customLinkedList.indexOf("a"));
        assertEquals(1, customLinkedList.indexOf("b"));
        assertEquals(2, customLinkedList.indexOf("c"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onLastIndexOf_d_returns_minus_1() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertEquals(-1, customLinkedList.lastIndexOf("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onLastIndexOf_a_returns_0() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertEquals(0, customLinkedList.lastIndexOf("a"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onLastIndexOf_b_returns_1() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertEquals(1, customLinkedList.lastIndexOf("b"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_a_c_a_d_e_onLastIndexOf_a_returns_4() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("c"));
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("d"));
        assertEquals(4, customLinkedList.lastIndexOf("a"));
    }

    @Test
    public void givenEmptyLinkedList_on_removeFirst_throws_NoSuchElementException() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertThrows(NoSuchElementException.class, customLinkedList::removeFirst);
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_on_removeFirst_returns_a_andHeadSetsTo_b() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertEquals("a", customLinkedList.removeFirst());
        assertEquals("b", customLinkedList.peek());
        assertEquals(2, customLinkedList.size());
    }

    @Test
    public void givenEmptyLinkedListOfType_String_on_removeLast_throws_NoSuchElementException() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertThrows(NoSuchElementException.class, customLinkedList::removeLast);
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_on_removeLast_returns_c_andSetsLastElementTo_b() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertEquals("c", customLinkedList.removeLast());
        assertEquals("b", customLinkedList.peekLast());
        assertEquals(2, customLinkedList.size());
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_on_removeFirstOccurrenceOf_d_returns_false() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertFalse(customLinkedList.removeFirstOccurrence("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_on_removeFirstOccurrenceOf_b_returns_true() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertTrue(customLinkedList.removeFirstOccurrence("b"));
        assertEquals("a", customLinkedList.get(0));
        assertEquals("c", customLinkedList.get(1));
    }

    @Test
    public void givenEmptyLinkedList_on_removeLastOccurrenceOf_a_returns_false() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertFalse(customLinkedList.removeLastOccurrence("a"));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_withValues_a_b_c_on_removeLastOccurrenceOf_d_returns_false() {
        CustomLinkedList<String> customDoublyLinkedList = new CustomLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertFalse(customDoublyLinkedList.removeLastOccurrence("d"));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_withValues_a_b_c_on_removeLastOccurrenceOf_a_returns_true() {
        CustomLinkedList<String> customDoublyLinkedList = new CustomLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertTrue(customDoublyLinkedList.removeLastOccurrence("a"));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_withValues_a_removeLastOccurrenceOf_a_returns_true() {
        CustomLinkedList<String> customDoublyLinkedList = new CustomLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.removeLastOccurrence("a"));
    }


    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_on_removeLastOccurrenceOf_d_returns_false() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertFalse(customLinkedList.removeLastOccurrence("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_a_on_removeLastOccurrenceOf_a_returns_true() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.removeLastOccurrence("a"));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_withValues_a_b_c_a_c_on_removeLastOccurrenceOf_a_returns_true() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("c"));
        assertEquals("a", customLinkedList.get(3));
        assertTrue(customLinkedList.removeLastOccurrence("a"));
        assertEquals("c", customLinkedList.get(3));
    }

    @Test
    public void givenEmptyLinkedListOfType_Integer_withValues_1_2_3_onAddAllAtIndex_1_collection_4_5_6_returns_1_4_5_6_2_3() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        Collection<Integer> collection = new ArrayList<>();
        collection.add(4);
        collection.add(5);
        collection.add(6);
        assertTrue(customLinkedList.addAll(1, collection));
        assertEquals(1, customLinkedList.get(0));
        assertEquals(4, customLinkedList.get(1));
        assertEquals(5, customLinkedList.get(2));
        assertEquals(6, customLinkedList.get(3));
        assertEquals(2, customLinkedList.get(4));
        assertEquals(3, customLinkedList.get(5));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_returnsCorrectString_on_toString() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertEquals("[1, 2, 3]", customLinkedList.toString());
    }

    @Test
    public void givenLinkedListOfType_Integer_withNpValues_returnsStringOf_emptyBraces_on_toString() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertEquals("[]", customLinkedList.toString());
    }

    @Test
    public void givenEmptyLinkedList_onClear_returnsEmptySet() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.clear();
        assertTrue(customLinkedList.isEmpty());
    }

    @Test
    public void givenLinkedListOfType_Integer_with_1_2_onClear_clearsList() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2));
        customLinkedList.clear();
        assertTrue(customLinkedList.isEmpty());
    }

    @Test
    public void givenEmptyLinkedList_onClone_returnsEmptyList() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        CustomLinkedList<Integer> cloned = customLinkedList.clone();
        assertEquals(customLinkedList, cloned);
        assertTrue(cloned.isEmpty());
    }

    @Test
    public void givenEmptyLinkedListOfType_Integer_withValues_1_2_3_onClone_returnsMatchingLinkedList() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        CustomLinkedList<Integer> clone = customLinkedList.clone();
        assertEquals(customLinkedList, clone);
    }

    @Test
    public void givenAListOf_0_to_32_integers_onContainsAllOf_5_10_and_20_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        List<Integer> collection = IntStream.of(5, 10, 20).boxed().toList();
        IntStream.range(0, 33).forEach(customLinkedList::add);
        assertTrue(customLinkedList.containsAll(collection));
    }

    @Test
    public void givenAListOf_0_to_32_integers_onContainsAllOf_5_10_and_200_returns_false() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        List<Integer> collection = IntStream.of(5, 10, 200).boxed().toList();
        IntStream.range(0, 33).forEach(customLinkedList::add);
        assertFalse(customLinkedList.containsAll(collection));
    }

    @Test
    public void givenASetOf_0_to_32_integers_matchesInstanceOfSet() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        Set<Integer> collection = new HashSet<>(List.of(1, 2, 3));
        assertTrue(customLinkedList.containsAll(collection));
    }

    @Test
    public void givenAListOf_0_to_32_integers_onContainsAllOf_nullCollection_throws_NullPointerException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 33).forEach(customLinkedList::add);
        assertThrows(NullPointerException.class, () -> customLinkedList.containsAll(null));
    }

    @Test
    public void whenGettingSubList_withFirstIndexSmallerThan_0_throws_IndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.subList(-1, 10));
    }

    @Test
    public void whenGettingSubList_withToIndexGreaterThanSize_throws_IndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.subList(0, 6));
    }

    @Test
    public void whenGettingSubList_withFromIndex_equals_toIndex_returns_emptyList() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        List<Integer> empty = customLinkedList.subList(3, 3);
        assertTrue(empty.isEmpty());
    }

    @Test
    public void whenGettingSubList_withToFromIndexGreaterThanToIndex_throws_IndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.subList(2, 1));
    }

    @Test
    public void whenGettingSubList_withIndexOf_2_8_returnsCorrectSublistOf_size_8() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 10).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        CustomLinkedList<Integer> expected = new CustomLinkedList<>();
        IntStream.range(2, 8).mapToObj(i -> i * 10).forEach(expected::add);
        List<Integer> subList = customLinkedList.subList(2, 8);
        assertEquals(subList, expected);
    }

    @Test
    public void whenRemovingNullList_throws_NullPointerException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        assertThrows(NullPointerException.class, () -> customLinkedList.removeAll(null));
    }

    @Test
    public void whenRemovingEmptyList_returns_false() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        assertFalse(customLinkedList.removeAll(new ArrayList<>()));
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        Collection<Integer> items = IntStream.range(0, 3).mapToObj(i -> i * 10).toList();
        assertTrue(customLinkedList.removeAll(items));
    }

    @Test
    void removeAll_withSetCollection_shouldUseSetDirectly() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        Set<Integer> setToRemove = Set.of(0, 10);
        assertTrue(customLinkedList.removeAll(setToRemove));
        assertEquals(List.of(20, 30, 40), customLinkedList);
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_and_oneNot_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        Collection<Integer> items = IntStream.range(2, 6).mapToObj(i -> i * 10).toList();
        assertTrue(customLinkedList.removeAll(items));
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_withGaps_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        Collection<Integer> items = IntStream.of(0, 30, 10).boxed().toList();
        assertTrue(customLinkedList.removeAll(items));
    }

    @Test
    public void onAddAll_withNegativeIndex_throws_IndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.addAll(-1, List.of(1, 2, 3)));
    }

    @Test
    public void onAddAll_withIndexLargerThanListSize_throws_IndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customLinkedList::add);
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.addAll(6, List.of(1, 2, 3)));
    }

    @Test
    public void insertInTheMiddle_singleElement_shouldKeepBothPartsConnected() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(10, 20, 30));
        assertTrue(customLinkedList.addAll(1, List.of(99)));
        assertEquals(4, customLinkedList.size());
        assertListEquals(customLinkedList, 10, 99, 20, 30);
        assertEquals(30, customLinkedList.get(3));
    }

    @Test
    public void insertInTheMiddle_multipleElements_shouldConnectBothDirections() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addAll(List.of(1, 2, 3, 4, 5));
        customLinkedList.addAll(2, List.of(100, 200, 300));
        assertEquals(8, customLinkedList.size());
        assertListEquals(customLinkedList, 1, 2, 100, 200, 300, 3, 4, 5);
        assertEquals(300, customLinkedList.get(4));
        assertEquals(3,   customLinkedList.get(5));
        assertEquals(5,   customLinkedList.get(7));
    }

    @Test
    public void insertNearTheEnd_multipleElements_tailShouldStillBeReachable() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addAll(List.of(10, 20, 30, 40));
        customLinkedList.addAll(3, List.of(88, 99));
        assertEquals(6, customLinkedList.size());
        assertEquals(99, customLinkedList.get(4));
        assertEquals(40, customLinkedList.get(5));
        assertEquals(40, customLinkedList.getLast());
    }

    @Test
    public void insertAtIndexOne_shouldNotBreakTheRestOfTheList() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>(List.of("A", "B", "C", "D", "E"));
        customLinkedList.addAll(1, List.of("X", "Y"));
        assertEquals(7, customLinkedList.size());
        assertEquals("A", customLinkedList.get(0));
        assertEquals("X", customLinkedList.get(1));
        assertEquals("Y", customLinkedList.get(2));
        assertEquals("B", customLinkedList.get(3));
        assertEquals("E", customLinkedList.get(6));
    }

    @Test
    public void insertInMiddle_afterwards_iterationShouldNotStopEarly() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        customLinkedList.addAll(3, List.of(100, 200));
        assertEquals(9, customLinkedList.size());
    }

    @Test
    public void insertAtIndexSizeMinusOne_shouldStillReachOriginalTail() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3, 4));
        customLinkedList.addAll(3, List.of(-1, -2));
        assertEquals(6, customLinkedList.size());
        assertEquals(-2, customLinkedList.get(4));
        assertEquals( 4, customLinkedList.get(5));
    }

    @Test
    public void addAllAtZero_toEmptyList_shouldSetTailCorrectly() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addAll(0, List.of(5, 6, 7));
        assertEquals(3, customLinkedList.size());
        assertEquals(5, customLinkedList.getFirst().intValue());
        assertEquals(7, customLinkedList.getLast().intValue());
        assertEquals(List.of(5,6,7), List.copyOf(customLinkedList));
    }

    @Test
    public void addAllAtZeroToEmptyList_setsTail() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addAll(0, List.of(7, 8, 9));
        assertEquals(9, customLinkedList.getLast());
    }

    @Test
    public void addAllWithSameInstanceAtBeginning() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1,2,3));
        customLinkedList.addAll(0, customLinkedList);
    }

    @Test
   public void addAllAtZeroToEmptyList_setsTailCorrectly() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addAll(0, List.of(100, 200, 300));
        assertEquals(3, customLinkedList.size());
        assertEquals(100, customLinkedList.getFirst());
        assertEquals(300, customLinkedList.getLast());
    }

    @Test
    public void bulkInsertMiddleAndEnds() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addAll(List.of(1, 2, 3));
        customLinkedList.addAll(1, List.of(10, 11));
        customLinkedList.addAll(0, List.of(99));
        customLinkedList.addAll(customLinkedList.size(), List.of(88));
        assertEquals(List.of(99,1,10,11,2,3,88), List.copyOf(customLinkedList));
    }

    @Test
    public void bulkAddAtZeroEmpty_setsHeadTail() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addAll(0, List.of(10, 20, 30));
        assertEquals(3, customLinkedList.size());
        assertEquals(10, customLinkedList.getFirst());
        assertEquals(30, customLinkedList.getLast());
    }

    @Test
    public void mixedOps_indexedAndBulk() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addAll(List.of(1, 2, 3));
        customLinkedList.add(1, 99);
        customLinkedList.addAll(2, List.of(100, 101));
        customLinkedList.remove(0);
        customLinkedList.set(3, 777);
        assertEquals(List.of(99,100,101,777,3), List.copyOf(customLinkedList));
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_onEqualsExactObjectThatMatch_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        CustomLinkedList<Integer> customLinkedListTwo = new CustomLinkedList<>(List.of(1, 2, 3));
        assertEquals(customLinkedList, customLinkedListTwo);
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_onEqualsNonMatchingObject_returns_false() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        assertNotEquals(customLinkedList, new HashSet<>());
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_andListOf_1_2_onEquals_withDifferentSizes_returns_false() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        CustomLinkedList<Integer> customLinkedListTwo = new CustomLinkedList<>(List.of(1, 2));
        assertNotEquals(customLinkedList, customLinkedListTwo);
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_andCustomListOf_1_2_3_onEquals_withExactMatch_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        CustomLinkedList<Integer> customLinkedListTwo = new CustomLinkedList<>(List.of(1, 2, 3));
        assertEquals(customLinkedList, customLinkedListTwo);
    }

    @Test
    public void givenCustomLinkedList_empty_andCustomList_empty_onEquals_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        CustomLinkedList<Integer> customLinkedListTwo = new CustomLinkedList<>();
        assertEquals(customLinkedList, customLinkedListTwo);
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_andCustomListOf_1_2_3_4_onEquals_returns_false() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        CustomLinkedList<Integer> customLinkedListTwo = new CustomLinkedList<>(List.of(1, 2, 3,4));
        assertNotEquals(customLinkedList, customLinkedListTwo);
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_andCustomListOf_1_2_4_onEquals_differentContentSameSize_returns_false() {
        CustomLinkedList<Integer> list1 = new CustomLinkedList<>(List.of(1, 2, 3));
        CustomLinkedList<Integer> list2 = new CustomLinkedList<>(List.of(1, 2, 4));
        assertNotEquals(list1, list2);
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_onRetainAll_nullCollection_throws_nullPointerException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertThrows(NullPointerException.class, () -> customLinkedList.retainAll(null));
    }

    @Test
    public void givenEmptyCustomLinkedList_1_2_3_onRetainAll_emptyCollection_returnsTrue_andEmptiesCollection() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        Collection<Integer> empty = new ArrayList<>();
        assertTrue(customLinkedList.retainAll(empty));
        assertFalse(customLinkedList.contains(1));
        assertFalse(customLinkedList.contains(2));
        assertFalse(customLinkedList.contains(3));
        assertTrue(customLinkedList.isEmpty());
    }

    @Test
    public void givenCustomLinkedList_onRetainAll_emptyCollection_returnsFalse() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        Collection<Integer> empty = new ArrayList<>();
        assertFalse(customLinkedList.retainAll(empty));
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3__onRetainAll_withListOf_1_2_returnsTrue_andLeavesValues_1_2() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        Collection<Integer> retain = new ArrayList<>(List.of(1, 2));
        assertTrue(customLinkedList.retainAll(retain));
        assertTrue(customLinkedList.contains(1));
        assertTrue(customLinkedList.contains(2));
        assertFalse(customLinkedList.contains(3));
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3__onRetainAll_withSetOf_1_2_returnsTrue_andLeavesValues_1_2() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        Collection<Integer> retain = new HashSet<>(List.of(1, 2));
        assertTrue(customLinkedList.retainAll(retain));
        assertTrue(customLinkedList.contains(1));
        assertTrue(customLinkedList.contains(2));
        assertFalse(customLinkedList.contains(3));
    }

    @Test
    public void givenEmptyCustomLinkedList_hashCode_returns_1() {
        assertEquals(1, new CustomLinkedList<>().hashCode());
    }

    @Test
    public void hashCode_shouldMatchJavaLinkedList() {
        List<Integer> custom = new CustomLinkedList<>(List.of(1, 2, 3));
        List<Integer> standard = new LinkedList<>(List.of(1, 2, 3));
        assertEquals(standard.hashCode(), custom.hashCode());
    }

    @Test
    public void givenEmptyCustomLinkedList_on_iterator_next_throws_noSuchElementException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> customLinkedList.iterator().next());
    }

    @Test
    public void giveCustomLinkedListOf_1_2_3_on_iterator_remove_removesElement_andReturnsListOf_2_3() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        Iterator<Integer> it = customLinkedList.iterator();
        it.next();
        it.remove();
        assertEquals(2, customLinkedList.size());
        assertEquals(2, customLinkedList.get(0));
        assertEquals(3, customLinkedList.get(1));
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_ListIterator_hasNext_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        assertTrue(customLinkedList.listIterator().hasNext());
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_ListIterator_withIndexOf_negative_1_throws_IndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.listIterator(-1));
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_ListIterator_withIndexOf_3_throws_IndexOutOfBoundsException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.listIterator(3));
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_ListIterator_hasPrevious_returns_false() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        assertFalse(customLinkedList.listIterator().hasPrevious());
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_next_ListIterator_hasPrevious_returns_true() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        ListIterator<Integer> listIterator = customLinkedList.listIterator();
        assertEquals(1, listIterator.next());
        listIterator.next();
        assertTrue(listIterator.hasPrevious());
        assertEquals(2, listIterator.previous());
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_ListIterator_withIndex_1_returnsListIterator_withValues_2_3() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>(List.of(1, 2, 3));
        ListIterator<Integer> listIterator = customLinkedList.listIterator(1);
        assertEquals(2, listIterator.next());
        listIterator.next();
        assertTrue(listIterator.hasPrevious());
        assertEquals(3, listIterator.previous());
    }

    private void assertListEquals(CustomLinkedList<Integer> list, Integer... expected) {
        assertEquals(expected.length, list.size());
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], list.get(i));
    }
}