import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomLinkedListTest {

    @Test
    public void givenDefaultConstructor_returnsSizeOf_0() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        assertEquals(0, customLinkedList.size());
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
    public void givenEmptyLinkedList_onPop_throws_NoSuchElementExceptiont() {
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
}
