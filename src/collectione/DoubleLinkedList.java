package collectione;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleLinkedList {

	private DoubleNode head;
	private DoubleNode tail;

	private List<DoubleNode> nodeStore;
	
	DoubleLinkedList(){
		nodeStore = new ArrayList<>();
		head = null;
		tail = null;
	}

	public void add(Object content) {
		DoubleNode nodeToStore = new DoubleNode(content);
		if (isEmpty()) {
			nodeStore.add(nodeToStore);
			head = nodeToStore;
			tail = nodeToStore;
		} else {
			tail.setSucc(nodeToStore);
			nodeToStore.setPred(tail);
			tail = nodeToStore;
			nodeStore.add(nodeToStore);
		}

	}

	public Object get(int index) {
		return nodeStore.get(index);
	}

	public int indexOf(Object content) {
		for (DoubleNode doubleNode : nodeStore) {
			if(doubleNode.getContent() == content)
			{
				return nodeStore.indexOf(doubleNode);
			}
		}
		return -1;
	}

	public void insert(int index, Object content) {
		if (index >= size()) {
			add(content);
		} else {
			DoubleNode nodeToStore = new DoubleNode(content);
			DoubleNode nodeAtIndex = nodeStore.get(index);

			nodeToStore.setSucc(nodeAtIndex);
			nodeToStore.setPred(nodeAtIndex.getPred());
			nodeToStore.getPred().setSucc(nodeToStore);
			nodeAtIndex.setPred(nodeToStore);
		}
	}

	public boolean isEmpty() {
		return nodeStore.isEmpty();
	}

	public int size() {
		return nodeStore.size();
	}

	public boolean remove(Object content) {
		if (nodeStore.size() == 0) {
			return false;
		} else if (nodeStore.size() == 1) {
			head = null;
			tail = null;
			nodeStore.clear();
			return true;
		} else {
			for (DoubleNode doubleNode : nodeStore) {
				if (doubleNode.getContent() == content) {
					if (head == doubleNode) {
						head = doubleNode.getSucc();
						head.setPred(null);
						
						return nodeStore.remove(doubleNode);
					}
					if (tail == doubleNode) {
						tail = doubleNode.getPred();
						tail.setSucc(null);
						
						return nodeStore.remove(doubleNode);
					}
					DoubleNode pred = doubleNode.getPred();
					DoubleNode succ = doubleNode.getSucc();

					pred.setSucc(succ);
					succ.setPred(pred);

					
				}
			}
		}
		return false;
	}

	public void removeFirst() {
		remove(head.getContent());
	}

	public void removeLast() {
		remove(tail.getContent());
	}

	@Override
	public String toString() {
		return Arrays.toString(nodeStore.toArray());
	}
}
