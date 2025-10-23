import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomLinkedListTest {

    @Test
    public void givenDefaultConstructor_returnsSizeOf_0() {
        assertEquals(0, new CustomLinkedList<>().size());
    }

    @Test
    public void givenConstructorWithCollectionParameter_onNullCollection_throws_NullPointerException() {
        assertThrows(NullPointerException.class, () -> new CustomLinkedList<Integer>(null));
    }

    @Test
    public void givenConstructorWithCollectionParameter_onCollectionOf_0_1_2_3_4_containsValues_withSizeOf_5() {
        Collection<Integer> values = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            values.add(i);
        CustomLinkedList<Integer> list = new CustomLinkedList<>(values);
        assertTrue(list.contains(0));
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertTrue(list.contains(4));
        assertEquals(5, list.size());
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
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_peek_returns_1() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertEquals(1, customLinkedList.peek());
    }

    @Test
    public void givenEmptyLinkedListOfType_Integer_onAddFirst_withValueOf_10_returnsSizeOf_1() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addFirst(10);
        assertEquals(1, customLinkedList.size());
        assertEquals(10, customLinkedList.peek());
        assertEquals(10, customLinkedList.get(0));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_addFirst_valueOf_0_insert_zeroToStart() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        customLinkedList.addFirst(0);
        assertEquals(0, customLinkedList.peek());
        assertEquals(0, customLinkedList.get(0));
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
        assertTrue(customLinkedList.remove(2));
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
        assertTrue(customLinkedList.remove(1));
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
        assertThrows(IndexOutOfBoundsException.class, () -> new CustomLinkedList<>().get(-1));
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
        assertThrows(NullPointerException.class, () -> customLinkedList.contains(null));
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
        assertThrows(NoSuchElementException.class, new CustomLinkedList<>()::element);
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
        assertNull(new CustomLinkedList<>().poll());
    }

    @Test
    public void givenLinkedListOf_20_onPoll_returns_20() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(20);
        assertEquals(20, customLinkedList.poll());
        assertTrue(customLinkedList.isEmpty());
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
        assertNull(new CustomLinkedList<>().peekFirst());
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
        assertNull(new CustomLinkedList<>().peekLast());
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
        assertNull(new CustomLinkedList<>().pollFirst());
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
        assertNull(new CustomLinkedList<>().pollLast());
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
        assertThrows(NoSuchElementException.class, new CustomLinkedList<>()::pop);
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
    public void givenLinkedListOfTypeInteger_withNoValues_onToArray_returns_emptyArray() {
        assertEquals(0, new CustomLinkedList<>().toArray().length);
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
    public void givenLinkedListOfType_Integer_onAddingNullCollection_throws_NullPointerException() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertThrows(NullPointerException.class, () -> customLinkedList.addAll(null));
    }

    @Test
    public void givenLinkedListOfType_Integer_onAddingEmptyCollection_returnsFalse() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertFalse(customLinkedList.addAll(new ArrayList<>()));
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
    public void givenLinkedListOfType_String_withValues_a_b_c_onRemoveObject_d_returns_null() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertNull(customLinkedList.remove("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onRemoveObject_b_returns_b_andRemoveItFromList() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertEquals("b", customLinkedList.remove("b"));
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
        assertThrows(NoSuchElementException.class, new CustomLinkedList<>()::removeFirst);
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
        assertThrows(NoSuchElementException.class, new CustomLinkedList<>()::removeLast);
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
    public void givenEmptyLinkedListOfType_String_on_removeFirstOccurrence_returns_false() {
        assertFalse(new CustomLinkedList<>().removeFirstOccurrence(null));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_withValues_a_b_c_on_removeFirstOccurrenceOf_d_returns_false() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertFalse(customLinkedList.removeFirstOccurrence("d"));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_withValues_a_b_c_on_removeFirstOccurrenceOf_b_returns_true() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertTrue(customLinkedList.removeFirstOccurrence("b"));
        assertEquals("a", customLinkedList.get(0));
        assertEquals("c", customLinkedList.get(1));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_on_removeLastOccurrence_returns_false() {
        assertFalse(new CustomLinkedList<>().removeLastOccurrence(null));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_withValues_a_b_c_on_removeLastOccurrenceOf_d_returns_false() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add("a"));
        assertTrue(customLinkedList.add("b"));
        assertTrue(customLinkedList.add("c"));
        assertFalse(customLinkedList.removeLastOccurrence("d"));
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
    public void givenEmptyLinkedListOfType_Integer_withValues_1_2_3_onClone_returnsMatchingLinkedList() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        System.out.println(customLinkedList);
        CustomLinkedList<Integer> clone = customLinkedList.clone();
        assertEquals(customLinkedList, clone);
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_toString_returnsCorrectStringRepresentation() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertTrue(customLinkedList.add(1));
        assertTrue(customLinkedList.add(2));
        assertTrue(customLinkedList.add(3));
        assertEquals("{ 1, 2, 3 }", customLinkedList.toString());
    }

    @Test
    public void givenEmptyLinkedListOfType_Integer_returnsCorrectStringRepresentationOf_emptyCurlyBrackets() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertEquals("{ }", customLinkedList.toString());
    }

    @Test
    public void givenEmptyLinkedList_onClear_returnsEmptySet() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.clear();
        assertTrue(customLinkedList.isEmpty());
    }

    @Test
    public void givenLinkedListOfType_Integer_with_1_2_onClear_clearsList() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.clear();
        assertEquals(0, customLinkedList.size());
        assertTrue(customLinkedList.isEmpty());
    }
}
