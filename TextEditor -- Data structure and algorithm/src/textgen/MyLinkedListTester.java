/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		//assertEquals("check size",(Integer)2,shortList.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		shortList.add("C");
		assertEquals("AddEnd: check new added element","C",shortList.get(2));
		//assertEquals("check size",(Integer)3,shortList.size()); error, size 3 should not have (Integer)
		assertEquals("check size",3,shortList.size());
		list1.add(369);
		assertEquals("AddEnd: check index3:",(Integer)369,list1.get(3));
		assertEquals("AddEnd: check size:",4,list1.size());
		
		
		
		
		try {
			shortList.add(null);
			fail("add null and check null");
		}catch(NullPointerException e) {
			
		}
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("check size",2,shortList.size());
		// TODO: implement this test
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			list1.add(-1, 88);
			fail("check index");
		}catch(IndexOutOfBoundsException e) {
			
		}
		try {
			list1.add(5, 88);
			fail("check index");
		}catch(IndexOutOfBoundsException e) {
			
		}
		try {
			list1.add(2,null);
			fail("check null");
		}catch(NullPointerException e) {
			
		}
		list1.add(1,88);
		assertEquals("check index 1",(Integer)88,list1.get(1));
		assertEquals("check index 2",(Integer)21,list1.get(2));
		assertEquals("AddAtIndex: check size",4,list1.size());
		longerList.add(5,36);
		assertEquals("check index 5",(Integer)36,longerList.get(5));
		assertEquals("check index 6",(Integer)5,longerList.get(6));
		assertEquals("AddAtIndex: check size",11,longerList.size());
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		int b=longerList.set(6,36);
		assertEquals("set: change index 6 ", (Integer)36,longerList.get(6));
		assertEquals("set: original  index 6: ",6,b);
		
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
