package collectione;

import static org.junit.Assert.*;
import org.junit.Test;

public class DoubleLinkeListTest {
	@Test
	public void test() {
		DoubleLinkedList dll = new DoubleLinkedList();
		
		// L�schen aus der Liste ohne Elemente
		assertEquals(false, dll.remove("Banane"));
		
		String banane  = "banane";
		String apfel   = "apfel";
		String birne   = "birne";
		String rettich = "rettich";
		
		// Hinzuf�gen von Elementen zur Liste
		dll.add(apfel);
		dll.add(birne);
		dll.add(rettich);
		dll.add(banane);
		
		// Gr��e �ber size() abfragen
		assertEquals(4, dll.size());
		
		// Erfolgreiches L�schen aus der Liste
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
		System.out.println(dll.toString());
		
		
	}
}