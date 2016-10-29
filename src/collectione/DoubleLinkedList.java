package collectione;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList {

	private DoubleNode head = null;
	private DoubleNode tail = null;

	private List<DoubleNode> nodeStore = new ArrayList<>();

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
		return nodeStore.indexOf(content);
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
		for (DoubleNode doubleNode : nodeStore) {
			if (doubleNode.getContent() == content) {
				DoubleNode pred = doubleNode.getPred();
				DoubleNode succ = doubleNode.getSucc();

				pred.setSucc(succ);
				succ.setPred(pred);

				nodeStore.remove(doubleNode);

				return true;
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
		String retVal = "";
		return retVal;
	}
}
