 package cs3151.project3.model;

public class LinkedListQueue<T> implements Queue<T> {

	private Node<T> front;
	private Node<T> rear;
	private int size;
	
	public LinkedListQueue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	@Override
	public void add(T element) {
		Node<T> node = new Node<T>(element);
		if(size == 0) {
			front = node;
		}else {		
			rear.setNext(node);	
		}
		size++;
		this.rear = node;

	}

	@Override
	public T remove() {
		T element = this.front.getData();
		size--;
		this.front = this.front.getNext();
		return element;
	}

	@Override
	public T element() {		
		return this.front.getData();
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

}
