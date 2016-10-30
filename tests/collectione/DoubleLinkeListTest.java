package collectione;

import static org.junit.Assert.*;


import org.junit.Test;

public class DoubleLinkeListTest {

	@Test
	public void test() {
		DoubleLinkedList dll = new DoubleLinkedList();
		
		assertEquals(false, dll.remove("Banane"));
		
		String banane = "banane";
		
		dll.add("Banane");
		dll.add("Banane");
		dll.add("Banane");
		dll.add(banane);
		
		System.out.println(dll.toString());
		
		assertEquals(true, dll.remove(banane));
		System.out.println(dll.toString());
	}

}
