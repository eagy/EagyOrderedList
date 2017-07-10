
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
			if(head.getElement().hashCode() < element.hashCode()) {
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
		else if (first().hashCode() < element.hashCode()) {
			tail.setNext(temp);
			temp.setPrev(tail);
			tail = temp;
			
		}
		else if (last().hashCode() > element.hashCode()) {
			head.setPrev(temp);
			temp.setNext(head);
			head = temp;
		}
		else {
			
			DoubleNode<T> iterator = head; 
			boolean done = false; 
			
			DoubleNode<T> first = head; 
			DoubleNode<T> second = head.getNext();
			
			while (second != null) {
				if(element.hashCode() < second.getElement().hashCode())
					break;
				first = second; 
				second = second.getNext();
			}
			
			temp.setNext(first.getNext());
			temp.setPrev(first);
			first.setNext(temp);
			first.getNext().setPrev(temp);
		}
		
		count++;
		
	}

}
