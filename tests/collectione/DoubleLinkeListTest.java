package collectione;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoubleLinkeListTest {
	
	String banane  = "banane";
	String apfel   = "apfel";
	String birne   = "birne";
	String rettich = "rettich";
	String kartoffel = "kartoffel";
	String sternfrucht = "sternfrucht";
	String wassermelone = "wassermelone";
	

	DoubleLinkedList dll;
	
	@Before
	public void reinitialize()
	{
		dll = new DoubleLinkedList();
	}
	
	@Test
	public void insertTest()
	{
		dll.insert(0, apfel);
		assertEquals("[apfel]", dll.toString());
		dll.insert(0, banane);
		assertEquals("[banane, apfel]", dll.toString());
		dll.insert(2, birne);
		assertEquals("[banane, apfel, birne]", dll.toString());
		dll.insert(2, kartoffel);
		assertEquals("[banane, apfel, kartoffel, birne]", dll.toString());
	}
	
	@Test
	public void removeTest()
	{
		dll.add(apfel);
		dll.add(birne);
		dll.add(rettich);
		dll.add(banane);
		assertEquals(4, dll.size());
		dll.remove(rettich);
		assertEquals(3, dll.size());
		assertEquals(-1, dll.indexOf(rettich));
	}
	
	@Test
	public void removeFirstTest()
	{
		dll.removeFirst();
		dll.add(apfel);
		dll.add(birne);
		dll.add(rettich);
		dll.add(banane);
		assertEquals(4, dll.size());
		dll.removeFirst();
		assertEquals(3, dll.size());
		
		
	}
	@Test
	public void removeLastTest()
	{
		dll.removeLast();
		dll.add(apfel);
		dll.removeLast();
		dll.add(birne);
		dll.add(rettich);
		dll.add(banane);
		
		assertEquals(4, dll.size());
		dll.removeLast();
		assertEquals(3, dll.size());
		
		
	}
	
	@Test
	public void test() {
		
		// Löschen aus der Liste ohne Elemente
//		assertEquals(false, dll.remove("Banane"));
		
		// Hinzufügen von Elementen zur Liste
		dll.add(apfel);
		dll.add(birne);
		dll.add(rettich);
		dll.add(banane);
		
		
		// Größe über size() abfragen
		assertEquals(4, dll.size());
		
		// Erfolgreiches Löschen aus der Liste
		assertEquals(true, dll.remove(banane));
		
		// Indexabfrage auf content
		dll.add(banane);		
		assertEquals(3, dll.indexOf(banane));
		
		// Indexabfrage auf content nach "verschieben"
		dll.removeFirst();
		
		// removeFirst entfernt erstes Element
		assertEquals(-1, dll.indexOf(apfel));
		assertEquals(2, dll.indexOf(banane));
		
		// Indexabfrage auf content, wenn nicht vorhanden
		dll.removeLast();
		assertEquals(-1, dll.indexOf(banane));
		
		dll.add(banane);
		dll.add(apfel);
		
		System.out.println(dll);
		
		
	}
}