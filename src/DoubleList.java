
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
	public T removeFirst() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new EmptyCollectionException(getClass().getName());
		else if (head == tail) {
			DoubleNode<T> temp = tail;
			head = tail = null;
			
			count--;
			
			return temp.getElement();
		}
		
		else {
			DoubleNode<T> temp = tail;
			
			tail = tail.getPrev();
			tail.setNext(null);
			temp.setPrev(null);
			
			count--;
			
			return temp.getElement();
		}
	}

	@Override
	public T removeLast() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		DoubleNode<T> temp; 
		if(isEmpty())
			throw new EmptyCollectionException(getClass().getName());
		else if (head == tail) {
			temp = head;
			head = tail = null;
			
			count--;
			
			return temp.getElement();
		}
		else {
			temp = head;
			
			
			head = head.getNext();
			head.setPrev(null);
			temp.setNext(null);
			
			count--;
			
			return temp.getElement();
		}
	}

	@Override
	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
		// TODO Auto-generated method stub 
		if (isEmpty())
			throw new EmptyCollectionException(getClass().getName());
	
		DoubleNode<T> temp;
		
		DoubleNode<T> previous = null;
		DoubleNode<T> current = head;
		boolean found  = false;
		
		while (current != null && !found) {
			if(element.equals(current.getElement())) 
				found = true; 
			else
			{
				previous = current;
				current = current.getNext();
			}
		}
		
		if(!found)
			throw new ElementNotFoundException(getClass().getName());
		if (size() == 1)
			head = tail = null;
		else if (current.equals(head)) {
			head.setPrev(current.getNext());
			head = current.getNext();
		}
		else if(current.equals(tail)) {
			tail = previous;
			tail.setPrev(previous);
			tail.setNext(null);
		}
		else 
			previous.setNext(current.getNext());
		
		count--;
		
		return current.getElement();
		
	}

	@Override
	public T first() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new EmptyCollectionException(getClass().getName());
		else
			return tail.getElement();
	}

	@Override
	public T last() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new EmptyCollectionException(getClass().getName());
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
