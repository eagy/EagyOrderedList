
public class DoubleOrderedList<T> extends DoubleList<T> implements OrderedListADT<T>{
	
	public DoubleOrderedList() {
		super();
	}
	
	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		if (!(element instanceof Comparable))
			throw new NonComparableElementException("Objects must be of a comparable type.");
		
		DoubleNode<T> temp = new DoubleNode<>(element);
		Comparable<T> comp = (Comparable<T>)element;
		
		
		if(isEmpty())
			head = tail = temp;
		else if (comp.compareTo(first()) > 0) {
			tail.setNext(temp);
			temp.setPrev(tail);
			tail = temp;
			
		}
		else if (comp.compareTo(last()) < 0) {
			head.setPrev(temp);
			temp.setNext(head);
			head = temp;
		}
		else {
			boolean done = false; 			
			DoubleNode<T> first = head; 
			DoubleNode<T> second = head.getNext();
			
			while (second != null && !done) {
				if(comp.compareTo(second.getElement())<0)
					done = true;
				else {
					first = second; 
					second = second.getNext();
				}
			}
			
			temp.setNext(first.getNext());
			temp.setPrev(first);
			first.setNext(temp);
			first.getNext().setPrev(temp);
			
		}
		
		count++;
		
	}

}
