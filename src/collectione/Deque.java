package collectione;

import java.util.NoSuchElementException;

public class Deque {
	private DoubleLinkedList queue;
	
	Deque(){
		queue = new DoubleLinkedList();
	}
	
	void pushLeft(Object o){
		queue.insert(0, o);
	}
	void pushRight(Object o){
		queue.add(o);
	}
	
	Object popLeft(){
		if(size() == 0)
			throw new NoSuchElementException();
		Object returnVal = queue.get(0);
		queue.removeFirst();
		return returnVal;
	}
	Object popRight(){
		if(size() == 0)
			throw new NoSuchElementException();
		Object returnVal = queue.get(queue.size() - 1);
		queue.removeLast();
		return returnVal;
	}
	
	Object peekLeft(){
		if(size() == 0)
			throw new NoSuchElementException();
		return queue.get(0);
	}
	Object peekRight(){
		if(size() == 0)
			throw new NoSuchElementException();
		return queue.get(queue.size() - 1);
	}
	
	int size(){
		return queue.size();
	}
	
	boolean isEmpty(){
		return queue.isEmpty();
	}
	@Override
	public String toString()
	{
		return queue.toString();
	}
}
