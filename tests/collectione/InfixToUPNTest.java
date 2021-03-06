package collectione;
import static org.junit.Assert.*;

import java.nio.charset.MalformedInputException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;


public class InfixToUPNTest {
	
	Double delta = 0.001;

    @Test
    public void testTransformerSimple() {
    	String stringShouldBe = "10 4 3 * +";
        Queue<String> upnQueueIs = InfixToUPN.process("10 + 4 * 3");
        System.out.println(upnQueueIs);
        String upnStringIs = queueToString(upnQueueIs);
        assertEquals(stringShouldBe, upnStringIs);
    }
    
    @Test
    public void testTransformerWithParens() {
    	String stringShouldBe = "3 4 + 3 *";
        Queue<String> upnQueueIs = InfixToUPN.process("( 3 + 4 ) * 3");
        System.out.println(upnQueueIs);
        String upnStringIs = queueToString(upnQueueIs);
        assertEquals(stringShouldBe, upnStringIs);
    }
    
    @Test
    public void testTransformerWithParensComplicated() {
    	String stringShouldBe = "5 3 4 + * 6 2 1 + / *";
        Queue<String> upnQueueIs = InfixToUPN.process("5 * ( 3 + 4 ) * 6 / ( 2 + 1 )");
        System.out.println(upnQueueIs);
        String upnStringIs = queueToString(upnQueueIs);
        assertEquals(stringShouldBe, upnStringIs);
    }
    


    @Test
    public void testCalculator() throws MalformedInputException {
    	Double resultShouldBe = 15.0;
        Double resultIs = UPNTaschenrechner.process("3 4 3 * +");
        assertEquals(resultShouldBe, resultIs, delta);
    }
    
    
    
    // utils for testing
    public Queue<String> stringToQueue(String string) {
    	Queue<String> queue = new LinkedBlockingQueue<>();;
    	for (String character : string.split(" ")) {
    		queue.offer(character);
    	}
    	return queue;
    }

    public String queueToString(Queue<String> queue) {
    	return String.join(" ", queue);
    }
    
}
