package collectione;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DoubleLinkeListTest {

	@Test
	public void test() {
		List<String> testList = new ArrayList<>();
		testList.add("Test");
		
		testList.add(100,"Test2");
		
		Arrays.toString(testList.toArray());
	}

}
