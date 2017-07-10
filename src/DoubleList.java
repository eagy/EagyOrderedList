
public class DoubleList<T> implements ListADT<T>{
	protected DoubleNode<T> head;
	protected DoubleNode<T> tail;
	protected int count;
	
	/**
	 * Initializes the Doublelist. 
	 */
	public DoubleList() {
		head = tail = null;
		count = 0;
	}
	
	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new EmptyCollectionException("There are no elements in the collection");
		else if (head == tail) {
			DoubleNode<T> temp = tail;
			head = tail = null;
			
			return temp.getElement();
		}
		
		else {
			DoubleNode<T> temp = tail;
			
			tail = tail.getPrev();
			tail.setNext(null);
			temp.setPrev(null);
			
			return temp.getElement();
		}
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		DoubleNode<T> temp; 
		if(isEmpty())
			throw new EmptyCollectionException("There are no elements in the collection");
		else if (head == tail) {
			temp = head;
			head = tail = null;
			
			return temp.getElement();
		}
		else {
			temp = head;
			
			
			head = head.getNext();
			head.setPrev(null);
			temp.setNext(null);
			
			return temp.getElement();
		}
	}

	@Override
	public T remove(T element) {
		// TODO Auto-generated method stub
		DoubleNode<T> iterator = head; 
		DoubleNode<T> temp;
		if(isEmpty())
			throw new EmptyCollectionException("There are no elements in the collection.");
		else if (head == tail) {
			temp = head; 
			
			head = tail = null;
			
			return temp.getElement();
		}
		else if (head.getElement().equals(element)) {
			temp = head; 
			
			head = head.getNext();
			head.setPrev(null);
			temp.setNext(null);
			
			return temp.getElement();
		}
		else if (tail.getElement().equals(element)) {
			temp = tail; 
			 
			tail = tail.getPrev();
			tail.setNext(null);
			temp.setPrev(null);
			
			return temp.getElement();
		}
		else {
			while(iterator != null) {
				if(iterator.getElement().equals(element)) {
	
					iterator.getPrev().setNext(iterator.getNext());
					iterator.getNext().setPrev(iterator.getPrev());
				
					return iterator.getElement();
				}
				
				iterator = iterator.getNext();
			}
		}
		
		throw new ElementNotFoundException("There is no such element in this collection.");
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new EmptyCollectionException("There are no elements in the collection.");
		else
			return tail.getElement();
	}

	@Override
	public T last() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new EmptyCollectionException("There are no elements in the collection.");
		else
			return head.getElement();
	}

	@Override
	public boolean contains(T target) {
		// TODO Auto-generated method stub
		DoubleNode<T> iterator = head; 
		
		while(iterator != null && iterator.getElement().equals(target)) {
			if(iterator.getElement().equals(target))
				return true;
			
			iterator = iterator.getNext();
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return null;
		else {
			String result = "";
			DoubleNode<T> temp = head; 
			while (temp != null) {
				result += temp.getElement() + " ";
				temp = temp.getNext();
			}
			
			return result;
		}
	}

}
