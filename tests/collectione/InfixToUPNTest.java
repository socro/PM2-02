package collectione;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import org.junit.Test;


public class InfixToUPNTest {

    @Test
    public void testTransformer() {
        Queue<String> upnQueue = InfixToUPN.process("3 + 4");
        System.out.println(upnQueue.toString());
    }


}
