package collectione;

public class DoubleLinkedList {

	private DoubleNode head;
	private DoubleNode tail;

	DoubleLinkedList() {
		head = null;
		tail = null;
	}

	public void add(Object content) {
		DoubleNode nodeToStore = new DoubleNode(content);
		if (isEmpty()) {
			head = nodeToStore;
			tail = nodeToStore;
		} else {
			tail.setSucc(nodeToStore);
			nodeToStore.setPred(tail);
			tail = nodeToStore;
		}

	}

	public Object get(int index) {
		if (index < 0 || isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		DoubleNode currentNode = head;
		while (index != 0) {
			index--;
			if (currentNode.getSucc() == null)
				throw new IndexOutOfBoundsException();
			currentNode = currentNode.getSucc();
		}
		return currentNode;
	}

	public int indexOf(Object content) {
		if (isEmpty())
			return -1;
		DoubleNode currentNode = head;
		int indexCounter = 0;
		while (!currentNode.getContent().equals(content)) {
			if (currentNode.getSucc() == null)
				return -1;
			currentNode = currentNode.getSucc();
			indexCounter++;
		}
		return indexCounter;
	}

	public void insert(int index, Object content) {
		if(index < 0)
			throw new IndexOutOfBoundsException();
		DoubleNode currentNode = head;
		while (index > 1) {
			index--;
			if (currentNode.getSucc() == null)
				throw new IndexOutOfBoundsException();
			currentNode = currentNode.getSucc();
		}
		DoubleNode nodeToStore = new DoubleNode(content);
		if(index == 0)
		{
			if(isEmpty())
				tail = nodeToStore;
			nodeToStore.setSucc(head);
			if(head != null){
				head.setPred(nodeToStore);
			}
			head = nodeToStore;
		}
		else if (currentNode.getSucc() != null) {
			currentNode = currentNode.getSucc();
			nodeToStore.setSucc(currentNode);
			nodeToStore.setPred(currentNode.getPred());
			nodeToStore.getPred().setSucc(nodeToStore);
			currentNode.setPred(nodeToStore);
		} else {
			tail = nodeToStore;
			currentNode.setSucc(nodeToStore);
			nodeToStore.setPred(currentNode);
		}
	}
	
	private void insertFirst()
	{
		
	}
	
	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		if (isEmpty())
			return 0;
		DoubleNode currentNode = head;
		int sizeCounter = 1;
		while (currentNode.getSucc() != null) {
			currentNode = currentNode.getSucc();
			sizeCounter++;
		}
		return sizeCounter;
	}

	public boolean remove(Object content) {
		if(isEmpty())
			return false;
		if(head.getContent().equals(content))
		{
			removeFirst();
			return true;			
		} 
		if(tail.getContent().equals(content))
		{
			removeLast();
			return true;
		}
		
		DoubleNode currentNode = head;
		while (!currentNode.getContent().equals(content)) {
			if (currentNode.getSucc() == null)
				return false;
			currentNode = currentNode.getSucc();
		}
		DoubleNode pred = currentNode.getPred();
		DoubleNode succ = currentNode.getSucc();
		
		pred.setSucc(succ);
		succ.setPred(pred);
		return true;
	}

	public void removeFirst() {
		if(isEmpty())
		{
			return;
		}
		if(head == tail){
			head = null;
			tail = null;
		}
		else
		{
			DoubleNode oldHead = head;
			head = oldHead.getSucc();
			head.setPred(null);
		}
	}

	public void removeLast() {
		if(isEmpty())
		{
			return;
		}
		if(head == tail){
			head = null;
			tail = null;
		}
		else
		{
			DoubleNode oldTail = tail;
			tail = oldTail.getPred();
			tail.setSucc(null);
		}
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		String retVal = "[";
		DoubleNode currentNode = head;
		while (currentNode.getSucc() != null) {
			retVal += currentNode;
			retVal += ", ";
			currentNode = currentNode.getSucc();
		}
		retVal += currentNode;
		retVal += "]";
		return retVal;
	}
}
