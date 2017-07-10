
public class DoubleOrderedList<T> extends DoubleList<T> implements OrderedListADT<T>{
	
	public DoubleOrderedList() {
		super();
	}
	
	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		DoubleNode<T> temp = new DoubleNode<>(element);
		
		if(isEmpty())
			head = tail = temp;
		else if (head == tail) {
			if (head.getElement().getClass() != element.getClass())
				throw new NonComparableElementException("Objects must be of the same class");
			if(head.getElement().hashCode() > element.hashCode()) {
				tail = temp;
				head.setNext(tail);
				tail.setPrev(head);
			}
			else {
				head = temp;
				head.setNext(tail);
				tail.setPrev(head);
			}
		}
		else {
			DoubleNode<T> iterator = head; 
			boolean done = false; 
			
			while(iterator != null && iterator.getNext() != tail && !done) {
				if (iterator.getElement().hashCode() < temp.getElement().hashCode()
						&& iterator.getNext().hashCode() >= temp.getElement().hashCode()) {
					iterator.getNext().setPrev(temp);
					temp.setNext(iterator.getNext());
					iterator.setNext(temp);
					temp.setPrev(iterator);
					
					done = true;
				}
				
				iterator = iterator.getNext();
			}
			
			
		}
		
		count++;
		
	}

}
