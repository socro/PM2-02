package collectione;

public class Deque {
	DoubleLinkedList queue;
	
	Deque(){
		
	}
	
	void pushLeft(Object o){
		queue.insert(0, o);
	}
	void pushRight(Object o){
		queue.insert(queue.size() - 1, o);
	}
	
	Object popLeft(){
		Object returnVal = queue.get(0);
		queue.remove(returnVal);
		return returnVal;
	}
	Object popRight(){
		Object returnVal = queue.get(queue.size() - 1);
		queue.remove(returnVal);
		return returnVal;
	}
	
	Object peekLeft(){
		return queue.get(0);
	}
	Object peekRight(){
		return queue.get(queue.size() - 1);
	}
	
	int size(){
		return queue.size();
	}
	
	boolean isEmpty(){
		return queue.isEmpty();
	}
}
