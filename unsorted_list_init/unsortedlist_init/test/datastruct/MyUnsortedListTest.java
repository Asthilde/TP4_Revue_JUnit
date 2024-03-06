package datastruct;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyUnsortedListTest {
	UnsortedList<Integer> list;
	UnsortedList<Integer> emptylist;
	UnsortedList<Integer> emptylist2;
	@Before
	public void init() {
		list = MyUnsortedList.of(1,2,3,4);  
		emptylist = MyUnsortedList.of();
		emptylist2 = MyUnsortedList.of();
	}

	@Test
	public void testIsEmpty() {
		assertTrue("list is empty", emptylist.isEmpty());
	}
	@Test
	public void testIsNotEmpty() {
		assertFalse("list is not empty", list.isEmpty());
	}
	@Test
	public void testSize() {
		assertEquals(4, list.size());
	}
	@Test
	public void testPrepend() {
		UnsortedList<Integer> prependlist = MyUnsortedList.of(0,1,2,3,4);  
		list.prepend(0);
		assertEquals(prependlist, list);
	}
	@Test
	public void testAppend() {
		UnsortedList<Integer> appendlist = MyUnsortedList.of(1,2,3,4,5);  
		list.append(5);
		assertEquals(appendlist, list);
	}
	@Test
	public void testInsert() {
		UnsortedList<Integer> insertlist = MyUnsortedList.of(1,2,3,8,4);  
		list.insert(8,3);
		System.out.print(list);
		assertEquals(insertlist, list);
	}
	@Test
	public void testInsertInEmptyList() {
	     emptylist.insert(10, 0);
	     assertEquals("List size should be 1 after insertion", 1, emptylist.size());
	 }
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertPosNeg() {	
		list.insert(8,-1);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertPlsuGrandeQueSize() {
		list.insert(8,10);
	}
	@Test 
	public void testPop() {
		UnsortedList<Integer> poplist = MyUnsortedList.of(2,3,4);  
		list.pop();
		assertEquals(poplist, list);
		
	}
	@Test(expected = EmptyListException.class)
	public void testPopEmpty() {
		emptylist.pop();
	}
	@Test 
	public void testReturnValeuOfPop() {
		int popped = list.pop();
		assertEquals(1, popped);
	}
	@Test
	public void testPopLast() {
		list.popLast();
		assertEquals(3,list.size());
	}
	@Test(expected = EmptyListException.class)
	public void testPopLastEmptyList() {
		emptylist.popLast();
	}
	@Test
	public void testPopLastReturn() {
		int lastpopped = list.popLast();
		assertEquals(4,lastpopped);
	}
	@Test
	public void testRemove() {	
		UnsortedList<Integer> removedlist = MyUnsortedList.of(1,3,4);  
		list.remove(1);
		System.out.print(list);
		assertEquals(removedlist, list);
	}
	@Test
	public void testRemovePosZero() {	
		UnsortedList<Integer> poppedlist = MyUnsortedList.of(2,3,4);  
		list.remove(0);
		assertEquals(poppedlist, list);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveEmptyList() {	
		emptylist.remove(1);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemovePosNeg() {	
		list.remove(-1);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemovePosPlsuGrandeQueSize() {
		list.remove(10);
	}
	@Test
    public void testEqualsSelf() {
        assertTrue("A list should be equal to itself", list.equals(list));
    }

    @Test
    public void testNotEqualsNull() {
        assertFalse("A list should not be equal to null", list.equals(null));
    }

    @Test
    public void testNotEqualsDifferentType() {
        assertFalse("A list should not be equal to an object of a different type", list.equals(new Object()));
    }

    @Test
    public void testEqualsSameElements() {
        UnsortedList<Integer> other = MyUnsortedList.of(1, 2, 3, 4);
        assertTrue("Two lists with the same elements should be equal", list.equals(other));
    }

    @Test
    public void testNotEqualsDifferentSize() {
        UnsortedList<Integer> shorter = MyUnsortedList.of(1, 2, 3);
        assertFalse("Two lists of different sizes should not be equal", list.equals(shorter));
    }

    @Test
    public void testNotEqualsDifferentOrder() {
        UnsortedList<Integer> differentOrder = MyUnsortedList.of(4, 3, 2, 1);
        assertFalse("Two lists with the same elements in a different order should not be equal", list.equals(differentOrder));
    }

    @Test
    public void testNotEqualsDifferentElements() {
        UnsortedList<Integer> differentElements = MyUnsortedList.of(5, 6, 7, 8);
        assertFalse("Two lists with different elements should not be equal", list.equals(differentElements));
    }

    @Test
    public void testEqualsEmptyLists() {
        UnsortedList<Integer> anotherEmptyList = MyUnsortedList.of();
        assertTrue("Two empty lists should be equal", emptylist.equals(emptylist2));
    }

	
}







