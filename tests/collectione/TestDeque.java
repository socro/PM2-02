package collectione;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import org.junit.Before;
import org.junit.Test;
import collectione.*;

public class TestDeque {

	@Test
	public void testPushLeft() {
		Deque deque = new Deque();
		deque.pushLeft(5);
		deque.pushRight(5);
		deque.pushLeft(1);
		deque.pushRight(1);
		assertEquals("[1, 5, 5, 1]", deque.toString());

	}

}
