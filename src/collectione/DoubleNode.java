package collectione;

public class DoubleNode {
	
	private Object content;
	private DoubleNode pred;
	private DoubleNode succ;

	public DoubleNode(Object content) {
		this.content = content;
		this.pred = null;
		this.succ = null;
	}
	
	public Object getContent() {
		return this.content;
	}
	
	public DoubleNode getPred() {
		return this.pred;
	}
	
	public DoubleNode getSucc() {
		return this.succ;
	}
	
	public void setPred(DoubleNode node) {
		this.pred = node;
	}
	
	public void setSucc(DoubleNode node) {
		this.succ = node;
	}
	
	@Override
	public String toString() {
		return content.toString();
	}
	
}
